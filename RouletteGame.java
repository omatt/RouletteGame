
/**
 * Roulette game in Java
 * 
 * @author Reyes, Omar Matthew B.
 * @version 2013/09/24
 */
import java.util.Random;
import java.util.Scanner;
public class RouletteGame{
    Scanner scan = new Scanner(System.in);
    int playerMoney = 1000;
    int winNumber;
    boolean playAgain = true;
    public static void main(String [] args){        
        RouletteGame roulette = new RouletteGame();     

        System.out.println("Welcome to our Casino. You will be playing with $" + roulette.playerMoney +".");
        roulette.playRoullete();
    }

    public void generateRandom(){
        Random random = new Random();
        winNumber = 0 + (int) (random.nextDouble() * ((49 - 0) + 1));
    }    

    public void playRoullete(){
        while(playAgain == true){
            int dealInput = -1, dealPlayerMoney = -1;
            while(dealInput < 0 || dealInput > 49){
                System.out.println("Choose number from 0 to 49 to deal on");
                dealInput = scan.nextInt();
            }

            while(dealPlayerMoney < 0 || dealPlayerMoney > playerMoney){
                System.out.println("Please type in the amount of money you want to deal on:");
                dealPlayerMoney = scan.nextInt();
            }

            generateRandom();
            System.out.println("The roullete has decided ... it stopped on number " + winNumber);

            if(winNumber == dealInput){
                System.out.println("Congratulatios! You won $" + dealPlayerMoney * 3);
                playerMoney+=dealPlayerMoney * 3;                
            }
            else if((winNumber % 2) == (dealInput % 2)){
                dealPlayerMoney*=0.5;
                System.out.println("You chose the good color. You gain $" + dealPlayerMoney);
                playerMoney+=dealPlayerMoney;
            }
            else{
                System.out.println("Sorry ... you lost your deal.");
                playerMoney-=dealPlayerMoney;
            }

            if(playerMoney <= 0){
                System.out.println("You lost all your money! That's the end of the game...");
                playAgain = false;
            }
            else{
                System.out.println("Now you have $" + playerMoney);

                System.out.println("Dou you want to leave the game (y/n)?");
                char leaveGame = scan.next().charAt(0);
                if(leaveGame == 'y' || leaveGame == 'Y'){
                    System.out.println("Bye! See you next time!");
                    playAgain = false;
                }
            }
        }
    }
}
