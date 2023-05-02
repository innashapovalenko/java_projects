import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.HashMap;

public class Bubbles
{
    

   
    public static int bubbleMoney(int[][] grid, int row, int col)
    {   
        int RowsNumber = grid.length;
        int ColNumber = grid[0].length;
        int[][] arrElement = new int[RowsNumber][ColNumber];
        for (int i=0; i< RowsNumber; i++){
            for (int j=0; j< ColNumber; j++){
                arrElement[i][j] = -4;
                arrElement[0][j] = grid[0][j];
            }
        }
        return bubbleMoneyhelper(grid, row, col, arrElement, 0);

    }

    public static int bubbleMoneyhelper(int[][] grid, int currR, int currC, int[][] arrElement, int sum){
        if (currC < 0 || currC >= grid[0].length){
            return 0;
        }
        
        if (arrElement[currR][currC] != -4){
            return arrElement[currR][currC];
        }
       
        sum = Math.max(bubbleMoneyhelper(grid, currR-1, currC-1, arrElement, sum), bubbleMoneyhelper(grid, currR-1, currC+1, arrElement,sum));
        return arrElement[currR][currC] = sum + grid[currR][currC];

        
    }
   



    /**
     * USAGE: java Bubbles file startRow startCol
     *        Ex. java Bubbles board.txt 6 3
     *
     * Reads file and stores the dollar amounts
     * in some variable.  Then calls bubbleMoney method
     * with the starting row and col.  You should print
     * the final answer returned by bubbleMoney
     */
    public static void main(String [] args)
    {
        try{
        
            File myObj = new File(args[0]);
            int RowUser = Integer.parseInt(args[1]);
            int ColUser = Integer.parseInt(args[2]);
    
            Scanner read = new Scanner(myObj);
            String line = read.nextLine();

            String [] rowColumnNumber = line.split(" ");
            int numRows = Integer.parseInt(rowColumnNumber[0]);
            int numCols = Integer.parseInt(rowColumnNumber[1]);
            

            int [][] arrayBubbles = new int[numRows][numCols];
            int l = 0;

            while (read.hasNextLine()) {
                line = read.nextLine();
                String [] arrayLine = line.split(" ");
                int[] arraInt = new int[arrayLine.length];
                for (int i = 0; i<arrayLine.length; i++){
                    arraInt[i] = Integer.parseInt(arrayLine[i]);
                    
                }
                arrayBubbles[l] = arraInt;
                l++;
            }
            // System.out.println(Arrays.deepToString(arrayBubbles));
            
            System.out.println(bubbleMoney(arrayBubbles, RowUser, ColUser));
            
        }
        catch (FileNotFoundException e){
            System.out.println("file is not found");
        }

        //time complexity O(n)
        //in our final solution we use memoization that helps us not to save elements again. That's why time complexity is just O(n)
    }
}
