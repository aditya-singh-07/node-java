/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class Problem {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
  
    boolean Safe(int mat[][], int row, int col)
    {
        int i, j;
  
   
        for (i = 0; i < col; i++)
            if (mat[row][i] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (mat[i][j] == 1)
                return false;
 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (mat[i][j] == 1)
                return false;
  
        return true;
    }
  
 
    boolean solve(int mat[][], int col)
    {
     
        if (col >= N)
            return true;
  

        for (int i = 0; i < N; i++) {
        
            if (Safe(mat, i, col)) {
       
                mat[i][col] = 1;
  

                if (solve(mat, col + 1) == true)
                    return true;
  
                mat[i][col] = 0; 
            }
        }
  
        return false;
    }
  
    void print(int mat[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]
                                 + " ");
            System.out.println();
        }
    }

    boolean chk()
    {
        int mat[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 } };
  
        if (solve(mat, 0) == false) {
            System.out.print("not possible");
            return false;
        }
  
        print(mat);
        return true;
    }
  

    public static void main(String args[])
    {
        Problem backtrack = new Problem();
        backtrack.chk(); 
        /*
        
        4
        0  0  1  0 
        1  0  0  0 
        0  0  0  1 
        0  1  0  0  
        
        2
        not possible
        
        */
        
    }
}