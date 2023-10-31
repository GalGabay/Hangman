import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to hangman! Player 1 - peak a word please: ");

        String peakedWord = scanner.nextLine();

        System.out.println("Alright, now player 2 - start guessing: ");



        char[] peakedWordGuessed = peakedWord.toCharArray();
        for(int i=0; i<peakedWord.length(); i++) {
            peakedWordGuessed[i] = '-';
        }
        game(scanner, peakedWord, peakedWordGuessed);
    }

    private static void game(Scanner scanner, String peakedWord, char[] peakedWordGuessed) {
        String mistakes = "";
        while(!isGameFinished(mistakes, peakedWordGuessed)) {
            mistakes = isCorrectGuess(peakedWord, scanner, peakedWordGuessed, mistakes);
        }
    }

    private static String isCorrectGuess(String peakedWord, Scanner scanner, char[] peakedWordGuessed, String mistakes) {
        System.out.println("Guess a letter: ");
        char guessedChar = scanner.next().charAt(0);

        if(peakedWord.contains("" + guessedChar)) {
            System.out.println("You are right! there is the board: ");
            for(int i=0;i<peakedWord.length(); i++){
                if(peakedWord.charAt(i) == guessedChar) {
                    peakedWordGuessed[i] = guessedChar;
                }
            }
        } else {
            System.out.println("You are wrong! there is the board: ");
            mistakes += guessedChar;
        }
        System.out.println(printGallows(mistakes.length(), peakedWordGuessed, mistakes));
        printMistakes(peakedWordGuessed, mistakes);
        return mistakes;
    }

    private static boolean isGameFinished(String mistakes, char[] peakedWordGuessed) {
        boolean hasWon = true;
        for(int i=0; i<peakedWordGuessed.length & hasWon; i++) {
            if(peakedWordGuessed[i] == '-') {
                hasWon = false;
            }
        }
        if(hasWon) {
            System.out.println("You win!");
            return true;
        }

        if(mistakes.length() == 6) {
            System.out.println("You Lose! Game Over...");
            return true;
        } else {
            return false;
        }
    }







    public static void printMistakes(char[] peakedWordGuessed, String mistakes) {
        System.out.print("The word you found so far: ");
        for(int i=0; i<peakedWordGuessed.length; i++) {
            System.out.print(peakedWordGuessed[i] + " ");
        }
        System.out.println();
        System.out.println("Your mistakes are: " + mistakes);
    }

    public static String printGallows(int numMistakes, char[] peakedWordGuessed, String mistakes) {

        switch (numMistakes) {
            case 0:
                return
            "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +   //if the user didn't miss any guesses.
                    "    |\n" +
                    "    |\n" +
                    "=========\n";
            case 1:
                return
                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +   //if the user missed one guess.
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n";
            case 2:
                return
                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +    //if the user missed two guesses.
                            "|   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n";
            case 3:
                return
                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +   //if the user missed three guesses.
                            "/|   |\n" +
                            "     |\n" +
                            "     |\n" +
                            " =========\n";
            case 4:
                return
                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +   //if the user missed four guesses.
                            "     |\n" +
                            "     |\n" +
                            " =========\n";
            case 5:
                return
                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +  //if the user missed five guesses.
                            "/    |\n" +
                            "     |\n" +
                            " =========\n";
            case 6:
                return
                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +   //if the user missed six guesses.
                            "/ \\  |\n" +
                            "     |\n" +
                            " =========\n";
            default:
                return "Wrong";

    }

 }
}
