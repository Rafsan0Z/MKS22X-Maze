import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

  private char[][]maze;
  private boolean animate;
  private int length;
  private int width;
  private String Maze;

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
    File Data = new File(filename);
    Scanner inf = new Scanner(Data);
    Maze = "";
    int counter = 0;
    width = 0;
    while(inf.hasNextLine()){
        String line = inf.nextLine();
        if(width == 0){width = line.length();}
        Maze += line + "\n";
        counter++;
    }
    length = counter;
    maze = new char[length][width];
    File Data2 = new File(filename);
    Scanner inf2 = new Scanner(Data2);
    counter = 0;
    while(inf2.hasNextLine()){
      String line = inf2.nextLine();
      for(int i = 0; i < line.length(); i++){
        maze[counter][i] = line.charAt(i);
      }
      counter++;
    }
    animate = false;
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

  /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
  public int[] findStart(){
    int[] result = new int[2];
    int row = 0;
    int col = 0;
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      if(maze[i][j] == 'S'){
        row = i;
        col = j;
      }
    }
    result[0] = row;
    result[1] = col;
    return result;
  }


  public int solve(){
    int[] coords = findStart();
    return solve(coords[0],coords[1],0);
  }

  /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
  private int solve(int row, int col, int count){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
      if(animate){
          clearTerminal();
          System.out.println(this);
          wait(20);
      }
      char tile = maze[row][col];
      if(tile == 'E'){return count;}
      if(tile == '#'){return -1;}
      if(tile == '.'){return -1;}
      if(tile == '@'){return -1;}
      int[][] moves = new int[][] { {1,0} , {-1,0}, {0,1}, {0,-1} };
      for(int i = 0; i < moves.length; i++){
        int rowChange = row + moves[i][0];
        int colChange = row + moves[i][1];
        int check = solve(rowChange, colChange, count+1);
        if(check == 0){maze[row][col] = '.';}
        else{
          maze[row][col] = '@';
          return check;
        }
      }
    return -1; //so it compiles
  }

  public int getWidth(){
    return width;
  }

  public String GetMaze(){
    return Maze;
  }

  public String toString(){
    String result = "";
    for(int i = 0, j = 0; i < length && j < width; i = j+1, j++){
      result += maze[i][j];
      if(j == width - 1){result += "\n";}
    }
    return result;
  }


  public static void main(String args[]){

        try{
          Maze puzzle = new Maze(args[0]);
          String Solution = puzzle.toString();
          System.out.println(Solution);
        } catch(FileNotFoundException e){
          System.out.println("Please Input a valid file!");
        }
      }
}
