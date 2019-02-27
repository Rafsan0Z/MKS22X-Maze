import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

  private char[][]maze;
  private boolean animate;


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
