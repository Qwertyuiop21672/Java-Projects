import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Variable declaration
        String[][] board = new String[6][7];
        String turn = "X";
        int move;
        Scanner s = new Scanner(System.in);

        //Start of game
        for (String[] row: board) {
            Arrays.fill(row, " ");
        }
        while (checkVictory(board)) {
            printBoard(board, turn);
            System.out.println("Choose a column 1-7:");
            move = s.nextInt();
            makeMove(board, turn, move);
            if (move >= 1 && move <= 7 && board[0][move-1] == " ") {
                if (turn == "X") {
                    turn = "O";
                } else {
                    turn = "X";
                }
            } else {
                System.out.println("==========================\nTHAT COLUMN IS FULL\n==========================");
            }
        }
    }
    public static void printBoard(String[][] array, String turn) {
        System.out.println("__________________________\nIt is "+turn+"'s turn to move");
        for (String[] row: array) {
            System.out.println(Arrays.toString(row).replaceAll("[,]", " |"));
        }
    }
    public static void makeMove(String[][] array, String turn, int move) {
        boolean done = false;
        if (move >= 1 && move <= 7) {
            for (int i = 5; i >= 0; i--) {
                if (array[i][move-1] == " ") {
                    array[i][move-1] = turn;
                    break;
                }
            }
        }
    }
    public static boolean checkVictory(String[][] array) {
        String winning = "";
        int idk;
        int streak;
        //iterates through board
        for (int r = 0; r <= 5; r++) {
            for (int c = 0; c <= 6; c++) {
                //if the tile has a piece in it
                if (!(array[r][c] == " ")) {
                    winning = array[r][c];

                    //UP and DOWN
                    streak = 1;
                    idk = 1;
                    while (idk <= 3) {
                        if (r - idk >= 0) {
                            if (winning == array[r-idk][c]) {
                                streak += 1;
                            }
                        }

                        idk++;
                        if (streak == 4) {
                            System.out.println("__________________________");
                            for (String[] row: array) {
                                System.out.println(Arrays.toString(row).replaceAll("[,]", " |"));
                            }
                            System.out.println("==========================\n"+winning + " wins!\n==========================" );

                            return false;
                        }
                    }
                    //LEFT and RIGHT
                    streak = 1;
                    idk = 1;
                    while (idk <= 3) {
                        if (c - idk >= 0) {
                            if (winning == array[r][c-idk]) {
                                streak += 1;
                            }
                        }

                        idk++;
                        if (streak == 4) {
                            System.out.println("__________________________");
                            for (String[] row: array) {
                                System.out.println(Arrays.toString(row).replaceAll("[,]", " |"));
                            }
                            System.out.println("==========================\n"+winning + " wins!\n==========================" );

                            return false;
                        }
                    }
                    //DOWN DIAGONAL
                    streak = 1;
                    idk = 1;
                    while (idk <= 3) {
                        if (c - idk >= 0 && r - idk >= 0) {
                            if (winning == array[r-idk][c-idk]) {
                                streak += 1;
                            }
                        }

                        idk++;
                        if (streak == 4) {
                            System.out.println("__________________________");
                            for (String[] row: array) {
                                System.out.println(Arrays.toString(row).replaceAll("[,]", " |"));
                            }
                            System.out.println("==========================\n"+winning + " wins!\n==========================" );

                            return false;
                        }
                    }
                    //UP DIAGONAL
                    streak = 1;
                    idk = 1;
                    while (idk <= 3) {
                        if (c - idk >= 0 && r + idk <= 5) {
                            if (winning == array[r+idk][c-idk]) {
                                streak += 1;
                            }
                        }

                        idk++;
                        if (streak == 4) {
                            System.out.println("__________________________");
                            for (String[] row: array) {
                                System.out.println(Arrays.toString(row).replaceAll("[,]", " |"));
                            }
                            System.out.println("==========================\n"+winning + " wins!\n==========================" );

                            return false;
                        }
                    }
                }
            }
        }

        //System.out.println(two);

        return true;
    }
}