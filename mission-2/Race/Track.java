/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package Race;

/**
 * Represents a track for a race, keeping track of the number of racers that have finished.
 */
public class Track {
    private int finishRacers = 0;

    /**
     * Gets the total number of racers that have finished.
     * @return The number of finishers.
     */
    public int getFinishRacers() {
        return finishRacers;
    }

    /**
     * Increments the count of racers that have finished.
     */
    public void setFinishRacers() {
        finishRacers++;
    }
}