/*
 * Nadezda Ambartzumove - 207267113
 * Amit Shomrat - 308032218
 * Noe Mignolet - 209709260
 */

package XO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game;

        // Prompt the user to select the game mode.
        System.out.print("""
                Welcome to the game.
                Please select your game option and then press enter.
                1. Automatic game - computer against computer.
                2. Manual game - computer against you.
                Your choise:\s""");
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        boolean isValid = false;

        // Validate user input for game mode selection.
        while (!isValid) {
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) isValid = true;
                else throw new IllegalArgumentException();
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.print("Please choose only 1 or 2: ");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Initialize the game based on user's choice.
        if (choice == 1) game = new SelfGame();
        else game = new UserGame();

        // Start threads for player1 and player2.
        Thread thread1 = new Thread(game.getPlayer1());
        Thread thread2 = new Thread(game.getPlayer2());
        thread1.start();
        thread2.start();
    }
}