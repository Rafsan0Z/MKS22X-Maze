import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  private String[][] ary;

  public static void main(String args[]) throws FileNotFoundException {
          //instead of a try/catch, you can throw the FileNotFoundException.
          //This is generally bad behavior

          File text = new File("Maze1.txt");
          // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"
          String maze = "";
          int counter = 0;
          int width = 0;
          int length = 0;
          //inf stands for the input file
          Scanner inf = new Scanner(text);

          while(inf.hasNextLine()){
              String line = inf.nextLine();
              if(width == 0){width = line.length();}
              maze += line + "\n";
              counter++;
          }
          length = counter;
          ary = new String[length][width];
      }
}
