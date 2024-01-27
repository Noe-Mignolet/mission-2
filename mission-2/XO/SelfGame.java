/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

/**
 * Represents an automatic game where computer players play against each other.
 */
public class SelfGame extends Game {

    /**
     * Constructs a new SelfGame with automatic players (computer vs. computer).
     */
    public SelfGame() {
        this.player1 = new SelfPlayer(PlayerType.X, this);
        this.player2 = new SelfPlayer(PlayerType.O, this);
        setCurrentPlayer(PlayerType.X);
    }
}