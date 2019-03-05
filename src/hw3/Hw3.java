/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//C:\Users\v1\Desktop\asd2.txt
/**
 *
 * @author v1
 */
public class Hw3{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        
        Maze myMaze = new Maze();
        myMaze.ReadMazeFromFile();
        myMaze.SolveMaze();
        myMaze.PrintSolution();
        
    }

    
}
