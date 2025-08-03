package br.com.dio;

import br.com.dio.model.Board;
import br.com.dio.model.Space;
import br.com.dio.service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Board board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameService service = null;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Mostrar tabuleiro");
            System.out.println("3 - Inserir valor");
            System.out.println("4 - Remover valor");
            System.out.println("5 - Mostrar erros");
            System.out.println("6 - Resetar tabuleiro");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    board = createBoardFromInput(); // Cria a partir da entrada manual
                    service = new GameService(board);
                    System.out.println("Jogo iniciado.");
                }
                case 2 -> {
                    checkIfGameStarted();
                    printBoard();
                }
                case 3 -> {
                    checkIfGameStarted();
                    System.out.print("Linha: ");
                    int row = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int col = scanner.nextInt();
                    System.out.print("Valor: ");
                    int value = scanner.nextInt();
                    if (service.tryInsert(row, col, value)) {
                        System.out.println("Valor inserido.");
                    }
                }
                case 4 -> {
                    checkIfGameStarted();
                    System.out.print("Linha: ");
                    int row = scanner.nextInt();
                    System.out.print("Coluna: ");
                    int col = scanner.nextInt();
                    if (service.tryRemove(row, col)) {
                        System.out.println("Valor removido.");
                    }
                }
                case 5 -> {
                    checkIfGameStarted();
                    service.showErrors();
                }
                case 6 -> {
                    checkIfGameStarted();
                    board.reset();
                    System.out.println("Tabuleiro resetado.");
                }
                case 7 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    // --------------------------
    // Cria o tabuleiro do jogo
    // --------------------------
    private static Board createBoardFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os dados no formato: linha,coluna;valor,fixed (ex: 0,0;5,true)");
        System.out.println("Digite uma linha vazia para finalizar.");
        List<List<Space>> grid = initEmptyGrid();

        while (true) {
            String input = scanner.nextLine();
            if (input.isBlank()) break;

            try {
                String[] parts = input.split(";");
                String[] coords = parts[0].split(",");
                int row = Integer.parseInt(coords[0]);
                int col = Integer.parseInt(coords[1]);

                String[] valfix = parts[1].split(",");
                int value = Integer.parseInt(valfix[0]);
                boolean fixed = Boolean.parseBoolean(valfix[1]);

                Space s = new Space(value, fixed);
                if (!fixed) s.setActual(null);
                grid.get(col).set(row, s);
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        return new Board(grid);
    }

    // --------------------------
    // Inicia matriz 9x9 vazia
    // --------------------------
    private static List<List<Space>> initEmptyGrid() {
        List<List<Space>> grid = new ArrayList<>();
        for (int col = 0; col < 9; col++) {
            List<Space> column = new ArrayList<>();
            for (int row = 0; row < 9; row++) {
                column.add(new Space(0, false)); // valor default 0
            }
            grid.add(column);
        }
        return grid;
    }

    // --------------------------
    // Exibe o tabuleiro
    // --------------------------
    private static void printBoard() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) System.out.print("| ");
                Integer val = board.getSpaces().get(col).get(row).getActual();
                System.out.print((val != null ? val : ".") + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    // --------------------------
    // Verifica se jogo já iniciou
    // --------------------------
    private static void checkIfGameStarted() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado.");
            throw new IllegalStateException("Board não inicializado.");
        }
    }
}
