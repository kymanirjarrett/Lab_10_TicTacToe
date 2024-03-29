public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();
        display();

        while (true) {
            int[] move = getPlayerMove();
            int row = move[0] - 1;
            int col = move[1] - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                display();

                if (isWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isTie()) {
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getPlayerMove() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        int[] move = new int[2];
        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            move[0] = input.nextInt();
            move[1] = input.nextInt();
        } while (move[0] < 1 || move[0] > 3 || move[1] < 1 || move[1] > 3);
        return move;
    }
}