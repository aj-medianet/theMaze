/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author andrewjoseph
 */
public class Solve {
    private int x;
    private int y;
    private int hx;
    private int hy;

    public Solve(String[][] m) {
      this.printMaze(m);
      this.getStartingPosition(m);
      this.play(m, x, y, hx, hy);
    }
    
    
    public void getStartingPosition(String[][] maze) {
        //checks top row
        for (int j = 0; j < 12; j++) {
            int i = 0;
            if (this.getPosition(maze, i, j).equals(".")) {
                x = i;
                y = j;
                hx = i + 1;
                hy = j;
            }
        }
        
        //checks bottom row
        for (int l = 0; l < 12; l++) {
            int k = 11;
            if(this.getPosition(maze, k, l).equals(".")) {
                x = k;
                y = l;
                hx = k;
                hy = l + 1;
            }
        }
        
        //checks left side
        for (int n = 0; n < 12; n++) {
            int m = 0;
            if(this.getPosition(maze, n, m).equals(".")) {
                x = n;
                y = m;
                hx = n + 1;
                hy = m;
            }
        }
        
        //checks right side
        for (int q = 0; q < 12; q++) {
            int p = 11;
            if (this.getPosition(maze, q, p).equals(".")) {
                x = q;
                y = p;
                hx = q - 1;
                hy = p;
            }
        }
        
    }
    
    //solves the maze
    public void play(String[][] maze, int posX, int posY, int handX, int handY) {
        
        String s = this.getPosition(maze, posX, posY);

        this.setPosition(maze, posX, posY);
        this.printMaze(maze);
        
        //base case
        if (s.equals("F")) {
            this.printMaze(maze);
            gameOver();            
        } else {
            //facing left
            if (posX > handX) {                  
                if (this.getNextHand(maze, handX, handY).equals(".") || this.getNextHand(maze, handX, handY).equals("X")) {
                    this.setNextHand(maze, handX, handY);
                    this.setLast(maze, posX, posY);
                    posY = handY;
                    posX = handX;
                    handY = handY + 1;
                }else if (this.getNext(maze, posX, posY - 1).equals(".") || this.getNext(maze, posX, posY - 1).equals("X")) {
                    this.setNext(maze, posX, posY - 1);
                    this.setLast(maze, posX, posY);
                    posY = posY - 1;
                    handY = handY - 1;
                } else if (this.getNext(maze, posX - 1, posY).equals("#")) {
                    handX = handX + 1;
                    handY = handY - 1;
                } else if (this.getNext(maze, posX - 1, posY).equals("F")) {
                    this.setGameOver(maze, posX - 1, posY);
                    this.setLast(maze, posX, posY);
                    posX = posX - 1;
                }
            }
            
            //facing right
            else if (posX < handX) {           
                 if (this.getNextHand(maze, handX, handY).equals(".") || this.getNextHand(maze, handX, handY).equals("X")) {
                    this.setNextHand(maze, handX, handY);
                    this.setLast(maze, posX, posY);
                    posY = handY;
                    posX = handX;
                    handY = handY - 1;
                }else if (this.getNext(maze, posX, posY + 1).equals(".") || this.getNext(maze, posX, posY + 1).equals("X")) {
                    this.setNext(maze, posX, posY + 1);
                    this.setLast(maze, posX, posY);
                    posY = posY + 1;
                    handY = handY + 1;  
                    
                }else if (this.getNext(maze, posX, posY + 1).equals("#")) {
                    handX = handX - 1;
                    handY = handY + 1;
                } else if (this.getNext(maze, posX, posY + 1).equals("F")) {
                    this.setGameOver(maze, posX, posY + 1);
                    this.setLast(maze, posX, posY);
                    posY = posY + 1;
                }
            }       
                
            //facing down
             else if (posY > handY) {           
                if (this.getNextHand(maze, handX, handY).equals(".") || this.getNextHand(maze, handX, handY).equals("X")) {
                    this.setNextHand(maze, handX, handY);
                    this.setLast(maze, posX, posY);
                    posY = handY;
                    posX = handX;
                    //handY = handY - 1;
                    handX = handX - 1;
                }else if (this.getNext(maze, posX + 1, posY).equals(".") || this.getNext(maze, posX + 1, posY).equals("X")) {
                    this.setNext(maze, posX + 1, posY);
                    this.setLast(maze, posX, posY);
                    posX = posX + 1;
                    handX = handX + 1;
                } else if (this.getNext(maze, posX + 1, posY).equals("#")) {
                    handX = handX + 1;
                    handY = handY + 1;
                } else if (this.getNext(maze, posX + 1, posY).equals("F")) {
                    this.setGameOver(maze, posX + 1, posY);
                    this.setLast(maze, posX, posY);
                    posX = posX + 1;
                }                
            }

            //facing up   
             else {      
                if(this.getNextHand(maze, handX, handY).equals(".") || this.getNextHand(maze, handX, handY).equals("X")) {
                        this.setNextHand(maze, handX, handY);
                        this.setLast(maze, posX, posY);
                        posY = handY;
                        posX = handX;
                        handX = handX + 1;
                        
                }else if(this.getNext(maze, posX - 1, posY).equals(".") || this.getNext(maze, posX - 1, posY).equals("X")) {
                    this.setNext(maze, posX - 1, posY);
                    this.setLast(maze, posX, posY);
                    posX = posX - 1;
                    handX = handX - 1;
                }else if(this.getNext(maze,posX - 1, posY).equals("#")) {
                    handX = handX - 1;
                    handY = handY - 1;
                }else if(this.getNext(maze, posX - 1, posY).equals("F")) {
                    this.setGameOver(maze, posX - 1, posY);
                    this.setLast(maze, posX, posY);
                    posX = posX - 1;
                }
            }
        System.out.print("posX: " + posX + " posY: " + posY + " handX: " + handX + " handY: " + handY + "\n");  //debug print
        this.play(maze, posX, posY, handX, handY);  //recursive call 
        }        
    }
    
    public void printMaze(String[][] maze) {
        for(int row = 0; row < 12; row++) {
            for(int col = 0; col < 12; col++) {
                System.out.print(this.getPosition(maze, row, col) + " ");                
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void setPosition(String[][] maze, int posX, int posY) {
       maze[posX][posY] = "O";

    }
    
    public String getNext(String[][] maze, int posX, int posY) {
        return maze[posX][posY];
    }
    
    public void setNext(String[][] maze, int posX, int posY) {
        maze[posX][posY] = "O";
    } 
    
    public void setLast(String[][] maze, int posX, int posY) {
        maze[posX][posY] = "X";
    }

    public String getPosition(String[][] maze, int posX, int posY) {
        return maze[posX][posY];
    }  
    
    public String getNextHand(String[][] maze, int handX, int handY) {
        return maze[handX][handY];
    }
    
    public void setNextHand(String[][] maze, int handX, int handY) {
        maze[handX][handY] = "O";
    }
    
    public void gameOver() {
        System.out.println("You've solved the maze!");
    }

    private void setGameOver(String[][] maze, int posX, int posY) {
        maze[posX][posY] = "F";
    }  
}
