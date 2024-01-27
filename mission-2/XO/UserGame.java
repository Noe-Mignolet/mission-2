/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

/**
 * Represents a game where a human player plays against a computer opponent in a manual mode.
 */
public class UserGame extends Game {

    /**
     * Constructs a new UserGame with a human player against a computer opponent.
     */
    public UserGame() {
        this.player1 = new UserPlayer(PlayerType.X, this);
        this.player2 = new SelfPlayer(PlayerType.O, this);
        setCurrentPlayer(PlayerType.X);
    }
}