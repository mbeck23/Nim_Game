/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim 
*/
import java.util.Scanner;  // Import the Scanner class

public class GameRunner
{
  public static Game game;
  public static void main(String[] args)
  {
    System.out.println("Welcome to the Game of Nim!");
    Board.populate(); // static method call
    Game nim = new Game(); 
    game = nim;
    play(false);

  }
  
  public static void play(Boolean replay){
    if (replay == true){
      Board.repopulate();
    }
    game.play();
  }
}