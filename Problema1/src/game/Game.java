package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Game {

    private void printBoard(String[][] board) {
        for (String[] row : board) {
            for (String elem : row)
                System.out.print(" " + elem + " ");
            System.out.println();
        }
    }

    private void clearRow(String[] row) {
        Arrays.fill(row, "⬜");
    }

    private void clearBoard(String[][] board) {
        for (String[] row : board) {
            clearRow(row);
        }
    }

    private int[][] pattern1 = {{1, 3}, {1, 4}, {1, 5}, {2, 2}, {2, 5}, {3, 6}, {4, 5}, {5, 4}, {6, 3}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}};
    private int[][] pattern2 = {{1, 4}, {2, 3}, {3, 4}, {4, 4}, {5, 4}, {6, 4}, {7, 2}, {7, 3}, {7, 4}, {7, 5}};

    private void loadPattern(String[][] board, int[][] pattern) {
        for (int[] pos : pattern) {
            board[pos[0]][pos[1]] = "⬛";
        }
    }

    public void play() {
        int player = 0;
        String[][] board = new String[8][8];
        clearBoard(board); // Inicializar tablero vacío

        // Dibujar y cargar patrones
        loadPattern(board, pattern1);
        printBoard(board);

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // Otro patrón
        clearBoard(board);
        loadPattern(board, pattern2);
        printBoard(board);

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        boolean playing = true;
        while (playing) {
            try {
                Random r = new Random();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int newCar = r.nextInt(8);
                board[0][newCar] = "🚙";
                board[7][player] = "🚗";

                printBoard(board);

                String key = br.readLine(); // Entrada del usuario

                if (key.equals("q")) {
                    playing = false;
                    break;
                } else if (key.equals("a") && player > 0) {
                    board[7][player] = "⬜";
                    player--;
                } else if (key.equals("d") && player < 7) {
                    board[7][player] = "⬜";
                    player++;
                }

                if (board[7][player].equals("🚙") || board[6][player].equals("🚙")) {
                    playing = false;
                    System.out.println("¡Perdiste!");
                }

                // Mover autos enemigos hacia abajo
                for (int i = 6; i >= 0; i--) {
                    board[i + 1] = board[i].clone();
                }
                clearRow(board[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}