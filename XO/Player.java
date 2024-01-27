/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

/**
 * Represents an abstract player in the game, implements Runnable for concurrent gameplay.
 */
public abstract class Player implements Runnable {
    protected final PlayerType playerType;
    protected final Game game;

    /**
     * Constructs a new Player with the specified player type and game.
     * @param playerType The type of player (X or O).
     * @param game The game in which the player participates.
     */
    public Player(PlayerType playerType, Game game) {
        this.playerType = playerType;
        this.game = game;
    }

    /**
     * Abstract method to be implemented by subclasses representing the player's move.
     */
    public abstract void run();

    /**
     * Abstract method to be implemented by subclasses representing the logic for making a move.
     * @param freeCells An array of available cells for the player to choose from.
     */
    public abstract void makeMove(Cell[] freeCells);

    /**
     * Checks if the player is a winner based on the current state of the game.
     * @param player The player type to check for a win.
     * @return True if the player is a winner, false otherwise.
     */
    protected synchronized boolean isWinner(PlayerType player) {
        return checkLines(player) || checkDiagonals(player);
    }

    /**
     * Checks for a winning combination along the rows or columns.
     * @param player The player type to check for a win.
     * @return True if a winning combination is found, false otherwise.
     */
    private boolean checkLines(PlayerType player) {
        for (int i = 0; i < game.getBoard().length; i++) {
            if (checkLine(player, i, 0, 0, 1) || checkLine(player, 0, i, 1, 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a winning combination along the diagonals.
     * @param player The player type to check for a win.
     * @return True if a winning combination is found, false otherwise.
     */
    private boolean checkDiagonals(PlayerType player) {
        return checkLine(player, 0, 0, 1, 1) || checkLine(player, 0, game.getSize() - 1, 1, -1)
                || checkLine(player, 1, 0, 1, 1) || checkLine(player, game.getSize() - 1, 1, -1, 1);
    }

    /**
     * Checks for a winning combination along a specified line.
     * @param player The player type to check for a win.
     * @param startRow The starting row of the line.
     * @param startCol The starting column of the line.
     * @param rowIncrement The increment in the row direction.
     * @param colIncrement The increment in the column direction.
     * @return True if a winning combination is found, false otherwise.
     */
    private boolean checkLine(PlayerType player, int startRow, int startCol, int rowIncrement, int colIncrement) {
        int count = 0;
        for (int i = 0; i < game.getSize(); i++) {
            int row = startRow + i * rowIncrement;
            int col = startCol + i * colIncrement;

            if (row >= 0 && row < game.getSize() && col >= 0 && col < game.getSize()) {
                if (game.getBoard()[row][col] == player) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }
}