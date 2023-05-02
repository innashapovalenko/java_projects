import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;



/**
 * Contains information about the world (i.e., the grid of squares)<br>
 * and handles most of the game play work that is NOT GUI specific
 */
public class FlyWorld
{
    protected int numRows;
    protected int numCols;
    protected int numFrogs;
    protected int numSpiders;

    protected GridLocation [][] world;

    protected GridLocation start;
    protected GridLocation goal;
    
    protected Fly mosca;
    protected Frog[] frogs;
    protected Spider[] spiders;

    /**
     * Reads a file containing information about<br>
     * the grid setup.  Initializes the grid<br>
     * and other instance variables for use by<br>
     * FlyWorldGUI and other pieces of code.
     *
     *@param fileName the file containing the world grid information
     */
    public FlyWorld(String fileName) {
        try(Scanner input = new Scanner(new File(fileName))){
            String line = input.nextLine();
            String [] rowColumnNumber = line.split(" ");
            numRows = Integer.parseInt(rowColumnNumber[0]);
            numCols = Integer.parseInt(rowColumnNumber[1]);
            world = new GridLocation[numRows][numCols];
            frogs = new Frog[numRows*numCols];
            spiders = new Spider[numRows*numCols];
            // int numFrogs = 0;
            numFrogs = 0;
            for (int i = 0; i<numRows; i++){
                line = input.nextLine();
                for (int j=0; j<numCols; j++){
                    world[i][j] = new GridLocation(i, j);
                    if(line.charAt(j) == 's'){
                        start = world[i][j];
                        start.setBackgroundColor(Color.GREEN);
                        mosca = new Fly(start, this);
                    }
                    if(line.charAt(j) == 'h'){
                        goal = world[i][j];
                        goal.setBackgroundColor(Color.RED);
                    }
                    if (line.charAt(j) == 'f'){
                        frogs[numFrogs] = new Frog(world[i][j], this);
                        numFrogs += 1;
                    }
                    if (line.charAt(j) == 'a'){
                        spiders[numSpiders] = new Spider(world[i][j], this);
                        numSpiders += 1;
                    }
                }
            }
                   

            // The following print statements are just here to help you know 
            // if you've done part 1 correctly.  You can comment them out or 
            // delete them before you make your final submission
            System.out.println("numRows: " + this.numRows + "   numCols: " + this.numCols);
            System.out.println("start: " + this.start + "   goal: " + this.goal);
            //System.out.println("Mosca: " + this.mosca.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("Not found");
            System.exit(numCols);
        }
}

    /**
     * @return int, the number of rows in the world
     */
    public int getNumRows(){
        return numRows;
    }

    /**
     * @return int, the number of columns in the world
     */
    public int getNumCols(){
        return numCols;
    }

    /**
     * Deterimes if a specific row/column location is<br>
     * a valid location in the world (i.e., it is not out of bounds)
     *
     * @param r a row
     * @param c a column
     *
     * @return boolean
     */
    public boolean isValidLoc(int r, int c){
        if(r < 0 || c < 0 || r >= numRows || c >= numCols){
            return false;
        }
        return true;
    }

    /**
     * Returns a specific location based on the given row and column
     *
     * @param r the row
     * @param c the column
     *
     * @return GridLocation
     */
    public GridLocation getLocation(int r, int c){
        return world[r][c];
    }

    /**
     * @return FlyWorldLocation, the location of the fly in the world
     */
    public GridLocation getFlyLocation(){
        return mosca.getLocation();
    }

    /**
     * Moves the fly in the given direction (if possible)
     * Checks if the fly got home or was eaten
     *
     * @param direction the direction, N,S,E,W to move
     *
     * @return int, determines the outcome of moving fly<br>
     *              there are three possibilities<br>
     *              1. fly is at home, return ATHOME (defined in FlyWorldGUI)<br>
     *              2. fly is eaten, return EATEN (defined in FlyWorldGUI)<br>
     *              3. fly not at home or eaten, return NOACTION (defined in FlyWorldGUI)
     */
    public int moveFly(int direction){
        mosca.update(direction);
        int eatMosca = 0;
        if (mosca.getLocation().equals(goal)){
            return FlyWorldGUI.ATHOME;
        }
        for (int j =0; j<numFrogs;j++){
            if (frogs[j].eatsFly()){
                eatMosca += 1;
                return FlyWorldGUI.EATEN;
            }
        }
        for (int k =0; k<numSpiders;k++){
            if (spiders[k].eatsFly()){
                eatMosca += 1;
                return FlyWorldGUI.EATEN;
            }
        }

        if (eatMosca == 0){
            return FlyWorldGUI.NOACTION;
        }
        return FlyWorldGUI.NOACTION; 
    }
    /**
     * Moves all predators. After it moves a predator, checks if it eats fly
     *
     * @return boolean, return true if any predator eats fly, false otherwise
     */
    public boolean movePredators(){
        for (int i =0; i<numFrogs; i++){
            frogs[i].update();
            if (frogs[i].eatsFly() == true){
                return true;
            }
        }
        for (int j =0; j<numSpiders; j++){
            spiders[j].update();
            if (spiders[j].eatsFly() == true){
                return true;
            }
        }
        
        return false;
    }
}
