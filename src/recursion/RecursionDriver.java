/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 *
 * @author andrewjoseph
 */
public class RecursionDriver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String file = args [0];
        
        String path = file;
        File input = new File(path);
        String[][] maze = new String[12][12];
        
        try (Scanner sc = new Scanner(input)) {
            
            
            while (sc.hasNext()) {
                for (int row = 0; row < 12; row++) {  
                    for (int col = 0; col < 12; col++) {
                        String next = sc.next();
                        maze[row][col] = next;   
                        //System.out.print(maze[row][col] + " ");  //test print
                    }
                    //System.out.println();       //test print
                }
            }
        Solve s = new Solve(maze);
         
            
        }
    }
}

