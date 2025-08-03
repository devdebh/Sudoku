package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

public class GameService {
    private final Board board;

    public GameService(Board board) {
        this.board = board;
    }

    public boolean tryInsert(int row, int col, int value) {
        if (!isValidMove(row, col, value)) {
            System.out.printf("Movimento inválido para [%d,%d] com valor %d\n", col, row, value);
            return false;
        }
        return board.changeValue(col, row, value);
    }

    public boolean tryRemove(int row, int col) {
        return board.clearValue(col, row);
    }

    public boolean isValidMove(int row, int col, int value) {
        for (int c = 0; c < 9; c++) {
            if (c != col && board.getSpaces().get(c).get(row).getActual() != null &&
                    board.getSpaces().get(c).get(row).getActual() == value) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (r != row && board.getSpaces().get(col).get(r).getActual() != null &&
                    board.getSpaces().get(col).get(r).getActual() == value) {
                return false;
            }
        }

        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = boxRowStart + i;
                int c = boxColStart + j;
                if (r != row || c != col) {
                    Integer actual = board.getSpaces().get(c).get(r).getActual();
                    if (actual != null && actual == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void showErrors() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Space s = board.getSpaces().get(j).get(i);
                if (s.getActual() != null && !s.getActual().equals(s.getExpected())) {
                    System.out.printf("Erro na célula [%d,%d]: esperado %d, atual %d\n", j, i, s.getExpected(), s.getActual());
                }
            }
        }
    }
}
