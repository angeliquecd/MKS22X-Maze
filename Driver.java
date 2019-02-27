
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver{
    public static void main(String[]args){
      String filename = "Maze1.txt";
      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.

      //  f.setAnimate(true);
        //f.solve();
        System.out.println(f);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
