import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

  private char[][]maze;
  private boolean animate;

  /*Constructor loads a maze text file, and sets animate to false by default.
      When the file is not found then:
         throw a FileNotFoundException

      You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      You ma also assume the maze has a border of '#' around the edges.
      So you don't have to check for out of bounds!
    */
  public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
    }

  private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }

  public int solve(){
    //find the location of the S.
    //erase the S
    //and start solving at the location of the s.
    //return solve(???,???);
  }

  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
      if(animate){
          clearTerminal();
          System.out.println(this);
          wait(20);
      }
    //COMPLETE SOLVE
    return -1; //so it compiles
  }


  public static void main(String args[]){

          String[][] ary;

          File text = new File("Maze1.txt");
          // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"
          String Maze = "";
          int counter = 0;
          int width = 0;
          int length = 0;
          //inf stands for the input file
          Scanner inf = new Scanner(text);

          while(inf.hasNextLine()){
              String line = inf.nextLine();
              if(width == 0){width = line.length();}
              Maze += line + "\n";
              counter++;
          }
          length = counter;
          ary = new String[length][width];
          for(int i = 0,j = 0; i < length && j < width; i = j + 1, j++){
            ary[i][j] = "";
          }
          System.out.println(Maze);
      }
}
