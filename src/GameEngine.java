/**
 * This task was created by Niv Seker (https://github.com/sekerniv)
 *
 * For any questions or further assistance, feel free to reach out!
 */

// Leave this import as it is. You'll need it
import assignmentfiles.*;
public class GameEngine {
    private String targetWord;
    private int attemptsLeft;
    private boolean isWin;

    public GameEngine(String targetWord) {
        this.targetWord=targetWord;
        this.attemptsLeft=6;
        this.isWin=false;
    }

    public String playGuess(String guess) {
        if (guess.equals(targetWord)) {
            isWin = true;
        }
        if (this.attemptsLeft>0) {
            this.attemptsLeft--;
            return evaluateGuess(targetWord, guess);
        } else {
            return "No attempts left.";
        }
    }

    public static void main(String[] args) {
        WordLoader wordLoader = new WordLoader();
        String targetWord = wordLoader.getRandomWord();

        GameEngine gameEngine = new GameEngine(targetWord);
        GameUI gameUI = new GameUI();
        System.out.println(targetWord);
        String userGuess=" ";
        while(!gameEngine.isGameOver()){
            userGuess = gameUI.readUserGuess();
            String feedback = gameEngine.playGuess(userGuess);
            gameUI.displayResult(feedback, userGuess, gameEngine.getAttemptsLeft());
            if (userGuess.equals(targetWord)) {
                gameUI.displayWin();
                gameEngine.attemptsLeft=0;
            }
        }
        if (gameEngine.isGameOver() && !userGuess.equals(targetWord)) {
            gameUI.displayLoss(gameEngine.getTargetWord());
        }
    }

    /**
     * Compares the player's guess to the target word and returns feedback.
     * For each character in the guess:
     * - '*' if the character is in the correct position.
     * - '+' if the character is in the target word but in the wrong position.
     * - '-' if the character is not in the target word.
     * The comparison is done up to the length of the shorter word, ignoring any extra characters.
     * Example:
     * targetWord = "taper", guess = "water"
     * Returns: "-*+**"
     **/
    public static String evaluateGuess(String targetWord, String guess) {
        String res = "";
        for (int i = 0; i < targetWord.length() && i < guess.length(); i++) {
            if (guess.charAt(i) == targetWord.charAt(i)) {
                res += "*";
            } else if (targetWord.indexOf(guess.charAt(i)) != -1) {
                res += "+";
            } else {
                res += "-";
            }
        }
            return res;
    }

    public boolean isGameOver() {
        return isWin || attemptsLeft <= 0;
    }

    public boolean isWin() {
        return isWin;
    }

    public String getTargetWord() {
        return targetWord;
    }
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
