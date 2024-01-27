/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a human player that plays against a computer opponent in a manual game.
 */
public class UserPlayer extends Player {
    private final Scanner scan;

    /**
     * Constructs a new UserPlayer with the specified player type and game.
     * @param player The type of player (X or O).
     * @param game The game in which the player participates.
     */
    public UserPlayer(PlayerType player, Game game) {
        super(player, game);
        this.scan = new Scanner(System.in);
    }

    /**
     * Runs the thread for the UserPlayer, making moves until the game is over.
     */
    @Override
    public void run() {
        while (!game.getGameOver()) {
            if (game.getTurn() == playerType) {
                Cell[] freeCells = game.getFreeCells();
                if (freeCells.length > 0 && !game.getGameOver()) {
                    makeMove(freeCells);
                    game.printBoard();
                    if (isWinner(playerType)) {
                        System.out.println("Player " + playerType + " wins!");
                        game.gameOver();
                    }
                } else if (game.getGameOver()) {
                    break;
                } else {
                    System.out.println("Board is full!");
                    game.gameOver();
                    break;
                }
            }
        }
    }

    /**
     * Makes a move for the UserPlayer based on user input.
     * @param freeCells An array of available cells for the player to choose from.
     */
    @Override
    public void makeMove(Cell[] freeCells) {
        int choice = getChoice(freeCells);
        game.getBoard()[freeCells[choice].getRow()][freeCells[choice].getCol()] = playerType;
        System.out.println("Player " + playerType + " made a move.");
        this.game.setCurrentPlayer((game.player1.playerType == playerType) ? game.player2.playerType : game.player1.playerType);
    }

    /**
     * Gets the user's choice of cell based on input.
     * @param freeCells An array of available cells for the player to choose from.
     * @return The index representing the user's choice.
     */
    private int getChoice(Cell[] freeCells) {
        synchronized (game) {
            System.out.println("Select a cell:");

            int num = freeCells[0].getRow();
            for (int i = 0; i < freeCells.length; i++) {
                String cellValue = game.getBoard()[freeCells[i].getRow()][freeCells[i].getCol()] != null ?
                        game.getBoard()[freeCells[i].getRow()][freeCells[i].getCol()].toString() : freeCells[i].toString();

                if (num < freeCells[i].getRow()) {
                    num = freeCells[i].getRow();
                    System.out.println();
                }
                System.out.printf("%-10s", (i + 1) + ". " + cellValue);
                if (num == freeCells[i].getRow()) {
                    System.out.print("\t");
                }
            }


            int choice = 0;
            boolean isValid = false;
            while (!isValid) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = scan.nextInt();
                    while (choice < 1 || choice > freeCells.length) {
                        System.out.print("Out of bounds index, pick again: ");
                        choice = scan.nextInt();
                    }
                    isValid = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer!");
                    scan.nextLine();
                }
            }
            return choice - 1;
        }
    }
}