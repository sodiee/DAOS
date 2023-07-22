package Traade_opgaver;

import java.util.Arrays;
import java.util.Random;

public class TestFindMax {

    private static final int rowindex = 20;
    private static final int colindex = 20000000;

    private static int[][] board = new int[rowindex][colindex];

    public static void main(String[] args) {
        fillBoard();
        //printBoard();

        System.out.println("Max: " + findMax());
        try {
            System.out.println("Max: " + findMaxThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static int findMax() {
        long l1 = System.nanoTime();
        int max = 0;
        for (int i = 0; i < rowindex; i++) {
            for (int j = 0; j < colindex; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }
        long l2 = System.nanoTime();
        System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");
        return max;
    }

    public static int findMaxThread() throws InterruptedException {
        long l1 = System.nanoTime();
        Traad traad1 = new Traad(Arrays.copyOf(board, (board.length / 2)));
        Traad traad2 = new Traad(Arrays.copyOfRange(board, board.length / 2, board.length));
        traad1.start();
        traad2.start();
        long l2 = System.nanoTime();
        System.out.println("Traad: Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");
        return Traad.max;
    }

    public static void fillBoard() {
        Random rand = new Random();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = rand.nextInt(1000000000);
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Traad extends Thread {

        int[][] boardCopy;

        static int max = 0;

        public Traad(int[][] boardCopy) {
            this.boardCopy = boardCopy;
        }

        public int getMax() {
            return max;
        }

        public void run() {
            for (int i = 0; i < rowindex; i++) {
                for (int j = 0; j < colindex; j++) {
                    if (board[i][j] > this.max) {
                        max = board[i][j];
                    }
                }
            }
        }
    }
}

