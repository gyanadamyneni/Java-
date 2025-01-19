import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Generate a pseudo-random number between 1 and 100
        int secretNumber = generateRandomNumber();

        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        final int maxAttempts = 7;

        // Welcome message
        System.out.println("Welcome to Guess the Number!");
        System.out.println("Try to guess the number between 1 and 100.");

        // Main game loop
        while (attempts < maxAttempts) {
            // Get user input
            int userGuess = getUserGuess(scanner);
            attempts++;

            // Check if the guess is correct, too low, or too high
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else {
                displayHint(userGuess, secretNumber);
            }
        }

        // Display a message if the user couldn't guess the number in 7 attempts
        if (attempts == maxAttempts) {
            System.out.println("Better luck next time! The correct number was: " + secretNumber);
        }
    }

    // Generate a pseudo-random number between 1 and 100
    private static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    // Get user input for the guess
    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    // Provide a fun hint based on the user's guess
    private static void displayHint(int userGuess, int secretNumber) {
        if (userGuess < secretNumber) {
            System.out.println("Too low! " + getHint());
        } else {
            System.out.println("Too high! " + getHint());
        }
    }

    // Provide a fun hint
    private static String getHint() {
        String[] hints = {
                "Hint: Keep going!",
                "Hint: You're getting warmer!",
                "Hint: Don't give up!",
                "Hint: Victory is just around the corner!"
        };

        int randomIndex = (int) (Math.random() * hints.length);
        return hints[randomIndex];
    }
}
