package br.com.dio.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        int[][] entrada = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        List<List<Space>> grid = convertToBoardGrid(entrada);
        Board board = new Board(grid);

        assertNotNull(board);
        assertEquals(9, board.getBoard().size());
        assertEquals(9, board.getBoard().get(0).size());
        assertEquals(5, board.getBoard().get(0).get(0).getActual());
    }

    // Método auxiliar para converter int[][] em List<List<Space>>
    private List<List<Space>> convertToBoardGrid(int[][] input) {
        List<List<Space>> grid = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<Space> row = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                row.add(new Space(input[i][j], i, j)); // Certifique-se de que o construtor Space(int valor, int linha, int coluna) exista
            }
            grid.add(row);
        }
        return grid;
    }
}
