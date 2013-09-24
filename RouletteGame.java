
/**
 * Simple roulette game in Java.
 * 
 * @author Reyes, Omar Matthew B.
 * @version 
 * 2013/09/24 Converted the Python code into Java.
 * 2013/09/25 Improved error handling.
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class RouletteGame{
    Scanner scan = new Scanner(System.in);
    // Initialize variables
    int playerMoney = 1000;
    int winNumber;
    boolean playAgain = true;
    public static void main(String [] args){        
        RouletteGame roulette = new RouletteGame();             
        roulette.playRoullete();
    }

    public void generateRandom(){
        Random random = new Random();
        //Generate random bounds with a minimum of 0 and a maximum of 49.
        winNumber = 0 + (int) (random.nextDouble() * ((49 - 0) + 1));
    }    

    public void playRoullete(){
        while(playAgain == true){
            System.out.println("Welcome to our Casino. You will be playing with $" + playerMoney +".");
            // Set the dealInput and dealPlayerMoney into -1 for them to enter
            // necessary inital looping statements.
            int dealInput =  -1, dealPlayerMoney = -1;
            // While input is not in range continue seeking appropriate input from user 
            while(dealInput < 0 || dealInput > 49){
                try{
                    System.out.println("Choose number from 0 to 49 to deal on");
                    dealInput = scan.nextInt();
                }
                //Catch InputMismatchException when input requirement is not met
                catch(InputMismatchException error){    
                    // Move to next exception.
                    scan.next();          
                }
            }

            // While input is not in range continue seeking appropriate input from user
            while(dealPlayerMoney < 0 || dealPlayerMoney > playerMoney){
                try{
                    System.out.println("Please type in the amount of money you want to deal on:");
                    dealPlayerMoney = scan.nextInt();
                }
                catch(InputMismatchException error){
                    scan.next();
                }
            }

            // Invoke generateRandom method
            generateRandom();
            System.out.println("The roullete has decided ... it stopped on number " + winNumber);

            // Roulette rule: if the input is same with the result; 
            // add dealPlayerMoney * 3
            if(winNumber == dealInput){
                System.out.println("Congratulatios! You won $" + dealPlayerMoney * 3);
                playerMoney+=dealPlayerMoney * 3;                
            }
            // Roulette rule: if the input is same with color (roulette has only two
            // colors within each block - so technically - chances are 50/50);
            // add dealPlayerMoney / 2
            else if((winNumber % 2) == (dealInput % 2)){
                dealPlayerMoney*=0.5;
                System.out.println("You chose the good color. You gain $" + dealPlayerMoney);
                playerMoney+=dealPlayerMoney;
            }
            // Roulette rule: if the input doesn't match the number and "color";
            // deduct dealPlayerMoney
            else{
                System.out.println("Sorry ... you lost your deal.");
                playerMoney-=dealPlayerMoney;
            }

            // If there's no more balance on the player's money;
            // end of game
            if(playerMoney <= 0){
                System.out.println("You lost all your money! That's the end of the game...");
                playAgain = false;
            }
            else{
                // Display current money
                System.out.println("Now you have $" + playerMoney);
                // Ask if going to play again
                System.out.println("Dou you want to leave the game (y/n)?");
                String leaveGame = scan.next();
                // Require input. Convert input into lowercase.
                if(leaveGame.toLowerCase().equals("y")){
                    System.out.println("Bye! See you next time!");
                    playAgain = false;
                    /** End Game **/
                }
                // Other than that - the game would prompt you to play again by not
                // change the boolean playAgain from being "true".
            }
        }
    }
}
