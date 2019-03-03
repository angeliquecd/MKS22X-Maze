import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR\
        int numrows=0;
        int numcols=0;
        File text = new File(filename);
        Scanner inf = new Scanner(text);
        while(inf.hasNextLine()){
          numrows++;
            String line = inf.nextLine();
            numcols=line.length();
          }
        //    System.out.println(""+numrows+numcols);
        maze = new char[numrows][numcols];
        System.out.println(maze[0][0]);
        int row=-1;
        animate=true;
        File text2 = new File(filename);
        Scanner inf2 = new Scanner(text);
        while(inf2.hasNextLine()){
          row++;
            String line = inf2.nextLine();
            for (int col=0;col<line.length();col++){
              maze[row][col]=line.charAt(col);
            //  System.out.println(""+maze[row][col]);
            }
            //System.out.println(line);//hopefully you can do other things with the line
        }
    }
public String toString(){
  String value="";
  for (int row=0;row<maze.length;row++){
    for (int col=0;col<maze[0].length;col++){
      value+=maze[row][col];
    }
    value+="\n";
  }
  return value;
}

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
      ArrayList<Integer> moves = new ArrayList<Integer>(4);
      int xcor =0;
      int ycor =0;
      for (int i=0;i<maze.length;i++){
        for (int b=0;b<maze[0].length;b++){
          if (maze[i][b]=='S'){
            xcor=i;
            ycor=b;
            maze[i][b]='@';}
          }
        }
    System.out.println(this);
    return solveHelper(xcor,ycor);}
    private int solveHelper(int row, int col){
      int xcor=row;
      boolean backtracking =false;
      int ycor=col;
      int count = 0;
      char spot = ' ';
      int finalcount =0;
        int[] moves = new int[2];
        int[] movesbackward = new int[2];
       for (int move=0;move<4;move++){
          count =0;
         if (move==0){
            spot = maze[xcor][ycor+1];
           moves[0]=0;
           moves[1]=1;}
           if (move==1){
              spot = maze[xcor][ycor-1];
             moves[0]=0;
             moves[1]=-1;}
             if (move==2){
                spot = maze[xcor+1][ycor];
               moves[0]=1;
               moves[1]=0;}
               if (move==3){
                  spot = maze[xcor-1][ycor];
                 moves[0]=-1;
                 moves[1]=0;}
          if (spot =='E') return finalcount;
           if (spot==' '){
            maze[xcor+moves[0]][ycor+moves[1]]='@';
            finalcount++;
            System.out.println(this);
           return solveHelper(xcor+moves[0],ycor+moves[1]);}
          else {
            count++;
          movesbackward[0]=moves[0];
        movesbackward[1]=moves[1];}}
      if (count>0){
        finalcount--;
           maze[xcor+movesbackward[0]][ycor+movesbackward[1]]='.';
           System.out.println(this);
           return solveHelper(xcor+movesbackward[0],ycor+movesbackward[1]);
         }
         return -1;
       }
            //find the location of the S.


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);



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


}
