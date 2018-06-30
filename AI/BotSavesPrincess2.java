import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    private int X;
    private int Y;

    Node(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX(){return this.X;}
    public int getY(){return this.Y;}
}

public class Solution {

static void nextMove(int n, int r, int c, String [] grid){
    // Robot Position
    Node robot = new Node(r, c);

    // Find Princess
    Node princess = null;
    for (int i = 0; i < n; i++){
         for(int j = 0; j < n; j++){
             if ( grid[i].charAt(j) == 'p') princess = new Node(i,j);
         }
    }

    // Robot moves
    String move = new String();
    if (null != princess){
        int princessX = princess.getX();
        int princessY = princess.getY();
        int robotX = robot.getX();
        int robotY = robot.getY();

        if(princessX > robotX )
            move = "DOWN";
        else if (princessX < robotX)
            move = "UP";
        else if (princessY > robotY)
            move = "RIGHT";
        else if (princessY < robotY )
            move = "LEFT";
    }

    System.out.println(move);
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}
