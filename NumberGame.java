import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100)+1;
            int attempLeft = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 - 100.");
            System.out.println("You have 10 attempts");

            while(attempLeft > 0){
                System.out.println("Enter Your Guess: ");

                if (!scanner.hasNextInt()){
                    System.out.println("Please Enter a whole number");
                    continue;
                }
                int guess = scanner.nextInt();
                if (guess < 1 || guess > 100){
                    System.out.println("Your number is between 1 to 100.");
                    continue;
                }
                attempLeft--;
                if (guess == numberToGuess){
                    System.out.println("Correct you guessed the number ");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("too low Attempt Left: " + attempLeft);
                }else{
                    System.out.println("too high. attempts left: " + attempLeft);
                }
            }
            if (!guessedCorrectly){
                System.out.println("Out of attempts . the number was: " + numberToGuess );
                }
            System.out.println("Round Won:"+score);
            System.out.println("Play another round?(yes / no): ");
            playAgain= scanner.next();
        }while(playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing.");
        scanner.close();
    }
}