import java.util.Scanner;

public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        /*
         PSEUDO CODE
         do
             clear the board, set player to X, moveCount to 0
             do
                 display the board
                 do
                     get row and col (1 - 3), subtract 1 for the indices
                 while the move is not valid
                 record the move, increment moveCount
                 if moveCount >= 5 and the player has a win, announce win
                 else if moveCount >= 7 and it is a tie, announce tie
                 else toggle the player
             while the game is not over
             ask to play again
         while they want to play again
        */

        Scanner in = new Scanner(System.in);
        String player;
        int moveCount;
        int row;
        int col;
        boolean done;
        boolean playAgain;

        do
        {
            clearBoard();
            player = "X";
            moveCount = 0;
            done = false;

            do
            {
                display();

                do
                {
                    row = SafeInput.getRangedInt(in, "Player " + player + ", enter the row", 1, ROWS) - 1;
                    col = SafeInput.getRangedInt(in, "Player " + player + ", enter the col", 1, COLS) - 1;

                    if (!isValidMove(row, col))
                    {
                        System.out.println("That space is already taken. Try again.");
                    }
                } while (!isValidMove(row, col));

                board[row][col] = player;
                moveCount++;

                if (moveCount >= 5 && isWin(player))
                {
                    display();
                    System.out.println("Player " + player + " wins!");
                    done = true;
                }
                else if (moveCount >= 7 && isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    done = true;
                }
                else if (player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }
            } while (!done);

            playAgain = SafeInput.getYNConfirm(in, "Do you want to play again?");
        } while (playAgain);
    }


    private static void clearBoard()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }


    private static void display()
    {
        System.out.println();
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                System.out.print(board[r][c] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }


    private static boolean isWin(String player)
    {
        return isColWin(player) || isRowWin(player) || isDiagnalWin(player);
    }

    private static boolean isColWin(String player)
    {
        for (int c = 0; c < COLS; c++)
        {
            if (board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player)
    {
        for (int r = 0; r < ROWS; r++)
        {
            if (board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }


    private static boolean isTie()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (board[r][c].equals(" "))
                {

                    return isBlocked(board[0][0], board[0][1], board[0][2])
                            && isBlocked(board[1][0], board[1][1], board[1][2])
                            && isBlocked(board[2][0], board[2][1], board[2][2])
                            && isBlocked(board[0][0], board[1][0], board[2][0])
                            && isBlocked(board[0][1], board[1][1], board[2][1])
                            && isBlocked(board[0][2], board[1][2], board[2][2])
                            && isBlocked(board[0][0], board[1][1], board[2][2])
                            && isBlocked(board[0][2], board[1][1], board[2][0]);
                }
            }
        }
        return true;
    }


    private static boolean isBlocked(String a, String b, String c)
    {
        boolean hasX = a.equals("X") || b.equals("X") || c.equals("X");
        boolean hasO = a.equals("O") || b.equals("O") || c.equals("O");
        return hasX && hasO;
    }
}