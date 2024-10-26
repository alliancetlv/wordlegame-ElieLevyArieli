import java.util.Scanner;
public class GameUI {
    private Scanner input;

    public GameUI() {
        input = new Scanner(System.in);
    }
    public String readUserGuess(){
        return input.nextLine();
    }
    public void displayResult(String res,String guess, int guessLeft){
        System.out.println("You have " + guessLeft + " attempts left.");
        System.out.println("Your guess: " + guess);
        System.out.println("Feedback: " + res);
    }
    public void displayWin(){
        System.out.println("Congratulations, YOU WIN!");
    }
    public void displayLoss(String targetWord){
        System.out.println("Game over! The word was: " + targetWord);
    }
}
