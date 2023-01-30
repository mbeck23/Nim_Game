import java.util.Scanner;  // Import the Scanner class
import java.util.Random;;

public class Board {

    //public static int numPlayers;
    static Random rand = new Random();
    public static int numObjects;

    public static String player1Name;
    public static String player2Name;
    public static int currentPlayer;

    public static boolean autoPlay;
    
    public static void populate(){

        currentPlayer = rand.nextInt(2)+1; //starts using random player
        
        numObjects = rand.nextInt(42)+9;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
 
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        
        System.out.println(" ");
        System.out.println("Total number of pieces = " + numObjects);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Player1 name?");
        player1Name = scanner.nextLine();  // Read user 
        
        
        System.out.println("Player2 name?");
        player2Name = scanner.nextLine();  // Read user input

       System.out.println();
       System.out.println("Activate autoplay for player2? y/n");
       String autoPlayInput = scanner.nextLine();

       boolean tempBool = false;
       
       while(tempBool == false){
        if (autoPlayInput.equals("y")){
            autoPlay = true;
            tempBool = true;
        }
        else if (autoPlayInput.equals("n")){
            autoPlay = false;
            tempBool = true;
        }
        else {
            System.out.println("enter a valid input: y/n");
            autoPlayInput = scanner.nextLine();
        }
       }

    }
    public static void repopulate(){

        currentPlayer = rand.nextInt(2)+1; //starts using random player
        
        numObjects = rand.nextInt(42)+9;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
 
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        System.out.println(" ");
        System.out.println("Total number of pieces = " + numObjects);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

       System.out.println();
       System.out.println("Activate autoplay for player2? y/n");
       String autoPlayInput = scanner.nextLine();

       boolean tempBool = false;
       
       while(tempBool == false){
        if (autoPlayInput.equals("y")){
            autoPlay = true;
            tempBool = true;
        }
        else if (autoPlayInput.equals("n")){
            autoPlay = false;
            tempBool = true;
        }
        else {
            System.out.println("enter a valid input: y/n");
            autoPlayInput = scanner.nextLine();
        }
       }
    }
}
