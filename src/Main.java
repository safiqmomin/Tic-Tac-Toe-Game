import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;

        while (!gameOver){
            printBoard(board);
            System.out.print("Player " + player + ", please enter the row: ");
            int row = scanner.nextInt();
            if (row >= board.length){
                System.out.println("Please enter a valid entry between 0 and 1: ");
                row = scanner.nextInt();
            }
            System.out.print("Player " + player + ", please enter the column: ");
            int col = scanner.nextInt();
            if (col >= board.length){
                System.out.println("Please enter a valid entry between 0 and 1: ");
                col = scanner.nextInt();
            }
            System.out.println();

            if(board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won!");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid entry. Please try again!");
            }

        }

    }

    //Returns true if the player has won
    private static boolean haveWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }


        for (int col = 0; col <board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    //Prints the board
    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (int col = 0; col < chars.length; col++) {
                System.out.print(chars[col] + " | ");
            }
            System.out.println();
        }
    }
}
