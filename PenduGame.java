import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PenduGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String wordToGuess = "";

            try {
                List<String> words = Files.readAllLines(Paths.get("words.txt"));
                Random random = new Random();
                wordToGuess = words.get(random.nextInt(words.size())).toLowerCase();
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture du fichier de mots.");
                e.printStackTrace();
                return;
            }

            GameStatus gameStatus = new GameStatus(wordToGuess);

            while (gameStatus.getErrorCount() < GameStatus.MAX_ERRORS && !gameStatus.isWordGuessed()) {
                PenduGraphics.printGameStatus(gameStatus);
                System.out.print("Entrez une lettre ou un mot: ");
                String input = scanner.nextLine().toLowerCase();

                if (input.length() == 1) {
                    gameStatus.checkLetter(input.charAt(0));
                } else {
                    gameStatus.checkWord(input);
                }
            }

            PenduGraphics.printGameStatus(gameStatus);
            if (gameStatus.isWordGuessed()) {
                System.out.println("Félicitations! Vous avez trouvé le mot: " + gameStatus.getWordToGuess());
            } else {
                System.out.println("Vous avez perdu! Le mot était: " + gameStatus.getWordToGuess());
            }
        }
    }
}