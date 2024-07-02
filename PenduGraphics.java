public class PenduGraphics {
    public static final String[] PENDU_STAGES = {
            " +---+\n     |\n     |\n     |\n    ===",
            " +---+\n O   |\n     |\n     |\n    ===",
            " +---+\n O   |\n |   |\n     |\n    ===",
            " +---+\n O   |\n/|   |\n     |\n    ===",
            " +---+\n O   |\n/|\\  |\n     |\n    ===",
            " +---+\n O   |\n/|\\  |\n/    |\n    ===",
            " +---+\n O   |\n/|\\  |\n/ \\  |\n    ==="
    };

    public static void printGameStatus(GameStatus gameStatus) {
        System.out.println(PENDU_STAGES[gameStatus.getErrorCount()]);
        System.out.print("Mot: ");
        for (char c : gameStatus.getWordProgress()) {
            System.out.print(c + " ");
        }
        System.out.println("\nLettres incorrectes: " + gameStatus.getWrongGuesses());
        System.out.println("Erreurs: " + gameStatus.getErrorCount() + "/" + GameStatus.MAX_ERRORS);
    }
}