import java.util.ArrayList;

public class GameStatus {
    public static final int MAX_ERRORS = PenduGraphics.PENDU_STAGES.length - 1;
    private String wordToGuess;
    private char[] wordProgress;
    private ArrayList<Character> wrongGuesses;
    private int errorCount;

    public GameStatus(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.wordProgress = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            this.wordProgress[i] = '_';
        }
        this.wrongGuesses = new ArrayList<>();
        this.errorCount = 0;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public char[] getWordProgress() {
        return wordProgress;
    }

    public ArrayList<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void checkLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                wordProgress[i] = letter;
                found = true;
            }
        }
        if (!found) {
            if (!wrongGuesses.contains(letter)) {
                wrongGuesses.add(letter);
                errorCount++;
            }
        }
    }

    public void checkWord(String word) {
        if (word.equals(wordToGuess)) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                wordProgress[i] = wordToGuess.charAt(i);
            }
        } else {
            errorCount = MAX_ERRORS; // Perte immédiate si le mot est incorrect
        }
    }

    public boolean isWordGuessed() {
        for (char c : wordProgress) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}