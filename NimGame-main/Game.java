import java.util.Scanner;  // Import the Scanner class
import java.util.Random;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    
    //create the player objects
    Player player1 = new Player(Board.player1Name, 0);
    Player player2 = new Player(Board.player2Name,0);

    public void play(){
        
        boolean gameEnd = false; //condition for while loop using boolean
    
        System.out.println("Please select less than or equal to half of the remaining pieces.");
        
        
        while (gameEnd == false){
            

            if (Board.currentPlayer == 1){
                System.out.println(Board.numObjects + " pieces remaining.");
                player1.playerTurn();
            }
            else if (Board.currentPlayer == 2){
                System.out.println(Board.numObjects + " pieces remaining.");
                player2.playerTurn();

            }

            String piecesTookenInput;
            int piecesTooken = 0;
            boolean isInt;


            //collects user input
            if (Board.currentPlayer == 2){
                if (Board.autoPlay == false){
                    isInt = scanner.hasNextInt();
                    piecesTookenInput = scanner.nextLine();  // Read user input
                    while (!isInt){ // checks to make sure user input is an integer
                        System.out.println("Please enter an integer");
                        isInt = scanner.hasNextInt();
                        piecesTookenInput = scanner.nextLine();
                    }
                    piecesTooken = Integer.valueOf(piecesTookenInput);
                }

                else if (Board.autoPlay == true){
                    piecesTooken = rand.nextInt(((Board.numObjects)/2))+1;
                    System.out.print(player2.playerName + " has taken " + piecesTooken + " pieces.");
                    System.out.println();
                    }
            }
            if (Board.currentPlayer == 1){
                isInt = scanner.hasNextInt();
                piecesTookenInput = scanner.nextLine();  // Read user input
                while (!isInt){ // checks to make sure user input is an integer
                    System.out.println("Please enter an integer");
                    isInt = scanner.hasNextInt();
                    piecesTookenInput = scanner.nextLine();
                }
                piecesTooken = Integer.valueOf(piecesTookenInput);
            }

            //checks if selected number is less than or equal to half.
            boolean isLessThanHalf = false;

            while(isLessThanHalf == false){
                while (piecesTooken > ((Board.numObjects)/2)){
                    System.out.println("Please pick a number less than or equal to half of the remaining pieces.");
                    System.out.println("Current number of pieces: " + Board.numObjects); 

                    isInt = scanner.hasNextInt();
                    piecesTookenInput = scanner.nextLine();  // Read user input
                    while (!isInt){ // checks to make sure user input is an integer
                        System.out.println("Please enter an integer");
                        isInt = scanner.hasNextInt();
                        piecesTookenInput = scanner.nextLine();
                    }
                    piecesTooken = Integer.valueOf(piecesTookenInput);
                }
                
                isLessThanHalf = true;
            } 

            if (isLessThanHalf == true){
                Board.numObjects -= piecesTooken;
                System.out.println("Great Job!");

                if (Board.numObjects == 1){

                    if (Board.currentPlayer == 2){
                        System.out.println(player1.playerName + " loses!");
                        player2.addScore();
                    }
                    else if (Board.currentPlayer == 1){
                        System.out.println(player2.playerName + " loses!");
                        player1.addScore();
                    }

                    System.out.println(player1.playerName + "'s score is: " + player1.score);
                    System.out.println(player2.playerName + "'s score is: " + player2.score);
                    System.out.println("");

                    gameEnd = true;
                    }

                // UNIQUE FEATURE: Bonus Turn
                int bonusToggle = rand.nextInt(15);
                if (bonusToggle == 7 && Board.currentPlayer == 1){
                    System.out.println(player1.playerName + " gets a bonus turn!");
                }
                else if (bonusToggle == 8 && Board.currentPlayer == 2){
                    System.out.println(player2.playerName + " gets a bonus turn!");
                }

                else {
                    if (Board.currentPlayer == 1){
                        Board.currentPlayer = 2;
                    }
                    else if (Board.currentPlayer == 2){
                        Board.currentPlayer = 1;
                    }
                        isLessThanHalf = false;
                    }
                }
            }
            System.out.println("Would you like to play again? y/n");
            String playAgain = scanner.nextLine();
                if (playAgain.equals("y")){
                GameRunner.play(true);
                }

        }
    }

