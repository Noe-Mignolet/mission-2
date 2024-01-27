/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

import java.util.ArrayList;

/**
 * Represents the game board and common functionality for different game types.
 */
public abstract class Game {
    private final PlayerType[][] board;
    private final int size = 5;
    private PlayerType currentPlayer;
    protected Player player1, player2;
    private boolean gameOver;

    /**
     * Constructs a new Game with a 5x5 board and initializes game state.
     */
    public Game() {
        board = new PlayerType[size][size];
        gameOver = false;
    }

    /**
     * Sets the current player for the game.
     * @param currentPlayer The current player type (X or O).
     */
    public synchronized void setCurrentPlayer(PlayerType currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Gets the player1 object.
     * @return The player1 object.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets the player2 object.
     * @return The player2 object.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Prints the current state of the game board to the console.
     */
    public synchronized void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String cellValue = (board[i][j] != null) ? board[i][j].toString() : " ";
                System.out.print(" " + cellValue + " ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i < size - 1) {
                for (int k = 0; k < size * 4 - 1; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Gets the size of the game board.
     * @return The size of the game board.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the game board.
     * @return The game board as a 2D array of PlayerType.
     */
    public PlayerType[][] getBoard() {
        return board;
    }

    /**
     * Signals that the game is over.
     */
    public void gameOver() {
        gameOver = true;
    }

    /**
     * Checks if the game is over.
     * @return True if the game is over, false otherwise.
     */
    public boolean getGameOver() {
        return gameOver;
    }

    /**
     * Gets the current turn player.
     * @return The current turn player type (X or O).
     */
    public synchronized PlayerType getTurn() {
        return currentPlayer;
    }

    /**
     * Gets an array of free cells on the game board.
     * @return An array of Cell objects representing free cells.
     */
    public Cell[] getFreeCells() {
        ArrayList<Cell> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new Cell(i, j));
                }
            }
        }
        return freeCells.toArray(new Cell[0]);
    }
}