/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author v1
 */
public class Maze implements HW3Maze {
    int[][] mz = new int[8][8];
    int[][] check = new int[8][8];
    Queue<Integer> q = new LinkedList<>();
    Stack<String> q2 = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    @Override
    public void ReadMazeFromFile()  {
        String path;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path of .txt = ");
        path = sc.nextLine();
        File file = new File(path);
        try {
            Scanner sc2=new Scanner(new FileReader(file));
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    mz[i][j]=sc2.nextInt();
                    System.out.print(mz[i][j]+" ");
                }
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------------------------------");
    }

    @Override
    public void SolveMaze() {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(mz[i][j]==1){
                    q.add(i);
                    q.add(j);
                }
            }
        }
        //System.out.println(q);
        while(q.isEmpty()==false){
            int ssize=-1;
            int tempsize;
            int a=q.remove();
            int b=q.remove();
            
            q2.add(a+":"+b);
            
            while(mz[a][b]!=32){
                //System.out.println("a= "+a+" b= "+b);
                if(b>0 && mz[a][b-1]==mz[a][b]+1 && check[a][b-1]==0){
                    //System.out.println(stack.push(1));
                    stack.push(1);
                    ssize=stack.size();
                    //sola hareket
                    b=b-1;
                    q2.add(" "+a+":"+b);
                }
                else if(b<7 && mz[a][b+1]==mz[a][b]+1 && check[a][b+1]==0){
                    //System.out.println(stack.push(2));
                    stack.push(2);
                    ssize=stack.size();
                    //sağa hareket
                    b=b+1;
                    q2.add(" "+a+":"+b);
                }               
                else if(a<7 && mz[a+1][b]==mz[a][b]+1 && check[a+1][b]==0){
                    //System.out.println(stack.push(3));
                    stack.push(3);
                    ssize=stack.size();
                    //aşağı hareket
                    a=a+1;
                    q2.add(" "+a+":"+b);
                    
                }               
                else if(a>0 && mz[a-1][b]==mz[a][b]+1 && check[a-1][b]==0){
                    //System.out.println(stack.push(4));
                    stack.push(4);
                    ssize=stack.size();
                    //yukarı hareket
                    a=a-1;
                    q2.add(" "+a+":"+b);
                }               
                else if(a>0 && b>0 && mz[a-1][b-1]==mz[a][b]+1 && check[a-1][b-1]==0){
                    //System.out.println(stack.push(5));
                    stack.push(5);
                    ssize=stack.size();
                    //yukarı sola hareket
                    a=a-1;
                    b=b-1;
                    q2.add(" "+a+":"+b);
                }               
                else if(a>0 && b<7 && mz[a-1][b+1]==mz[a][b]+1 && check[a-1][b+1]==0){
                    //System.out.println(stack.push(6));
                    stack.push(6);
                    ssize=stack.size();
                    //yukarı sağa hareket
                    a=a-1;
                    b=b+1;
                    q2.add(" "+a+":"+b);
                }               
                else if(a<7 && b>0 && mz[a+1][b-1]==mz[a][b]+1 && check[a+1][b-1]==0){
                    //System.out.println(stack.push(7));
                    stack.push(7);
                    ssize=stack.size();
                    //aşağı sola hareket
                    a=a+1;
                    b=b-1;
                    q2.add(" "+a+":"+b);
                }               
                else if(a<7 && b<7 && mz[a+1][b+1]==mz[a][b]+1 && check[a+1][b+1]==0){
                    //System.out.println(stack.push(8));
                    stack.push(8);
                    ssize=stack.size();
                    //aşağı sağa hareket
                    a=a+1;
                    b=b+1;
                    q2.add(" "+a+":"+b);
                }
                else {
                    //kaç kez queue ya eklendiyse dönge kur o kadar delete işlemi yaptır! if lerin içine counter ekle!
                    //System.out.println("breakk");
                    tempsize=stack.size();
                    
                    if(!stack.isEmpty()){
                        //System.out.println("stack is not empty");
                    if(stack.lastElement()==5 && (ssize==tempsize)){
                                                //System.out.println("burda5");

                        check[a][b]=1;
                        a++;
                        b++;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==4 && (ssize==tempsize)){
                                               // System.out.println("burda4");

                        check[a][b]=1;
                        a++;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==3 && (ssize==tempsize)){
                                              //  System.out.println("burda3");

                        check[a][b]=1;
                        a--;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                        
                    }
                    else if(stack.lastElement()==2 && (ssize==tempsize)){
                                             //   System.out.println("burda2");

                        check[a][b]=1;
                        b--;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==1 && (ssize==tempsize)){
                                              //  System.out.println("burda1");

                        check[a][b]=1;
                        b++;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==6 && (ssize==tempsize)){
                                            //    System.out.println("burda6");

                        check[a][b]=1;
                        a++;
                        b--;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==7 && (ssize==tempsize)){
                                           //     System.out.println("burda7");

                        check[a][b]=1;
                        a--;
                        b++;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    else if(stack.lastElement()==8 && (ssize==tempsize)){
                                               // System.out.println("burda8");

                        check[a][b]=1;
                        a--;
                        b--;
                        stack.pop();
                        if(!q2.isEmpty()){
                        q2.pop();}
                    }
                    }
                    if(ssize!=tempsize){
                       // System.out.println("ssize!=tempsize");
                        q2.clear();
                        //stack.clear();
                        break;}
                    
                    
                   // q2.clear();
                   // break;
                }
                
            }
            //System.out.println("sıra==" + mz[a][b]);
            if(mz[a][b]==32){
                //System.out.println("32 yi bulduk");
                break;
            }
        }
    }

    @Override
    public void PrintSolution() {
        System.out.println(q2);
    }
    
}
