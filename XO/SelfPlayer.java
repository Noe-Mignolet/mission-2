/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

import java.util.Random;

/**
 * Represents a computer player that plays against itself in an automatic game.
 */
public class SelfPlayer extends Player {
    private final Random random;

    /**
     * Constructs a new SelfPlayer with the specified player type and game.
     * @param player The type of player (X or O).
     * @param game The game in which the player participates.
     */
    public SelfPlayer(PlayerType player, Game game) {
        super(player, game);
        this.random = new Random();
    }

    /**
     * Runs the thread for the SelfPlayer, making moves until the game is over.
     */
    @Override
    public void run() {
        while (!game.getGameOver()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (game) {
                if (game.getTurn() == playerType) {
                    Cell[] freeCells = game.getFreeCells();
                    if (freeCells.length > 0 && !game.getGameOver()) {
                        makeMove(freeCells);
                        game.printBoard();
                        synchronized (game) {
                            if (isWinner(playerType)) {
                                System.out.println("\nPlayer " + playerType + " wins!");
                                game.gameOver();
                            }
                        }
                    } else if (game.getGameOver()) {
                        break;
                    } else {
                        System.out.println("\nBoard is full!");
                        game.gameOver();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Makes a move for the SelfPlayer by randomly selecting an available cell.
     * @param freeCells An array of available cells for the player to choose from.
     */
    @Override
    public void makeMove(Cell[] freeCells) {
        Cell coordinate = new Cell(freeCells[random.nextInt(freeCells.length)]);
        game.getBoard()[coordinate.getRow()][coordinate.getCol()] = playerType;
        System.out.println("\nPlayer " + playerType + " made a move.");
        this.game.setCurrentPlayer((game.player1.playerType == playerType) ? game.player2.playerType : game.player1.playerType);
    }
}