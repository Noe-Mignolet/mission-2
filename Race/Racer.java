/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package Race;

/**
 * Represents a racer participating in a race, implementing the Runnable interface for concurrent execution.
 */
public class Racer implements Runnable {
    private static int globalId = 1;
    private final int ID;
    private int speed;
    private final Track track;

    /**
     * Initializes a racer with a unique ID, speed, and a reference to the race track.
     * @param speed The speed of the racer (1 to 10).
     * @param track The track on which the racer is running.
     */
    public Racer(int speed, Track track) {
        ID = globalId++;
        setSpeed(speed);
        this.track = track;
    }

    /**
     * Runs the thread for the Racer, simulating the racer's movement until the race is completed.
     */
    @Override
    public void run() {
        Thread.currentThread().setPriority(speed);
        for (int i = 1; i <= 99; i++) {
            System.out.println("Runner " + ID + " ran " + i + " meters");
        }
        printRunnerFinish();
    }

    /**
     * Prints information about the racer finishing and updates the finish count in the track.
     */
    private synchronized void printRunnerFinish() {
        track.setFinishRacers();
        int position = track.getFinishRacers();
        System.out.printf("Runner %d ran 100 meters\nRunner %d finished %d%s\n", ID, ID, position, position == 1 ? "st" : position == 2 ? "nd" : position == 3 ? "rd" : "th");
    }

    /**
     * Sets the speed of the racer within the valid range (1 to 10), or defaults to 1 if invalid.
     * @param speed The speed to set for the racer.
     */
    public void setSpeed(int speed) {
        try {
            if (speed >= 1 && speed <= 10) {
                this.speed = speed;
            } else {
                throw new IllegalArgumentException("Runner " + ID + " with invalid speed. His speed changed to 1 !");
            }
        } catch (IllegalArgumentException e) {
            this.speed = 1;
            System.out.println(e.getMessage());
        }
    }
}