import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Definition of Node Class
class Node{
    private int X;
    private int Y;

    Node(int x, int y){
        this.X = x;
        this.Y = y;
    }

    // Getters
    public int getX(){return this.X;}
    public int getY(){return this.Y;}

    // Manhattan Distance
    public int manhattanDistance(Node target){
        return Math.abs( this.X - target.getX() ) + Math.abs(this.Y - target.getY());
    }
}


public class Solution {

static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
     // Robot node
    Node robot = new Node(posr, posc);

    // List of dirty Nodes
    List<Node> dirtyNodes = new ArrayList<Node>();

    // Find dirty nodes
    for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length(); j++){
            if ( board[i].charAt(j) == 'd' ){
                Node dirty = new Node(i,j);
                dirtyNodes.add(dirty);
            }
        }
    }

    // Nearest dirty node
    Node nearest = null;
    for ( Node n : dirtyNodes){
        if ( null == nearest || n.manhattanDistance( robot ) < nearest.manhattanDistance( robot ))
            nearest = n;
    }

    // Find move
    String move = new String();
    if ( null != nearest){
        // Distance
        int nearX = nearest.getX();
        int nearY = nearest.getY();
        int robotX = robot.getX();
        int robotY = robot.getY();

        if (nearY > robotY )
            move = "RIGHT";
        else if (nearX > robotX )
            move = "DOWN";
        else if (nearY < robotY )
            move = "LEFT";
        else if (nearX < robotX )
            move = "UP";
        else
            move = "CLEAN";
    }


    // Print move
    System.out.println(move);
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
