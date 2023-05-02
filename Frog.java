import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;



/**
 * Handles display, movement, and fly eating capabalities for frogs
 */
public class Frog
{
    protected static final String imgFile = "frog.png";

    protected GridLocation location;

    protected FlyWorld world;

    protected BufferedImage image;
    protected int numMoves = 0;

    /**
     * Creates a new Frog object.<br>
     * The image file for a frog is frog.jpg<br>
     *
     * @param loc a GridLocation
     * @param fw the FlyWorld the frog is in
     */
    public Frog(GridLocation loc, FlyWorld fw)
    {
        location = loc;
        world = fw;
        try
        {
            image = ImageIO.read(new File(imgFile));
        }
        catch (IOException ioe)
        {
            System.out.println("Unable to read image file: " + imgFile);
            System.exit(0);
        }
        location.setFrog(this);
    }

    /**
     * @return BufferedImage the image of the frog
     */
    public BufferedImage getImage()
    {
    return image;
    }

    /**
     * @return GridLocation the location of the frog
     */
    public GridLocation getLocation()
    {
    return location;
    }

    /**
     * @return boolean, always true
     */
    public boolean isPredator()
    {
    return true;
    }

    /**
    * Returns a string representation of this Frog showing
    * the location coordinates and the world.
    *
    * @return the string representation
    */
    public String toString(){
        String s = "Frog in world:  " + this.world + "  at location (" + this.location.getRow() + ", " + this.location.getCol() + ")";
        return s;
    }

    /**
     * Generates a list of <strong>ALL</strong> possible legal moves<br>
     * for a frog.<br>
     * You should select all possible grid locations from<br>
     * the <strong>world</strong> based on the following restrictions<br>
     * Frogs can move one space in any of the four cardinal directions but<br>
     * 1. Can not move off the grid<br>
     * 2. Can not move onto a square that already has frog on it<br>
     * GridLocation has a method to help you determine if there is a frog<br>
     * on a location or not.<br>
     *
     * @return GridLocation[] a collection of legal grid locations from<br>
     * the <strong>world</strong> that the frog can move to
     */
    public GridLocation[] generateLegalMoves()
    {
        GridLocation[] frogs = new GridLocation[4];
        int row = location.getRow();
        int col = location.getCol();
      
        if (world.isValidLoc(row-1, col) && !world.getLocation(row-1, col).hasPredator()){
            frogs[numMoves] = world.getLocation(row-1, col);
            numMoves += 1;

        }
        if (world.isValidLoc(row+1, col) && !world.getLocation(row+1, col).hasPredator()){
            frogs[numMoves] = world.getLocation(row+1, col);
            numMoves += 1;

        }
        if (world.isValidLoc(row, col-1) && !world.getLocation(row, col-1).hasPredator()){
            frogs[numMoves] = world.getLocation(row, col-1);
            numMoves += 1;

        }
        if (world.isValidLoc(row, col+1) && !world.getLocation(row, col+1).hasPredator()){
            frogs[numMoves] = world.getLocation(row, col+1);
            numMoves += 1;

        }
        
        return frogs;

    }

    /**
     * This method updates the frog's position.<br>
     * It should randomly select one of the legal locations(if there any)<br>
     * and set the frog's location to the chosen updated location.
     */
    public void update()
    {   
        GridLocation[] legal = generateLegalMoves();
        if (legal.length != 0){
            Random rand = new Random();
            int rand_int = rand.nextInt(numMoves);
            // System.out.println("Frog's old location:" + location.toString());
            location.removeFrog();
            location = legal[rand_int];
            location.setFrog(this);
            // System.out.println("Frog's new location:" + location.toString());
            numMoves = 0;
        }
        
    
    }

    /**
     * This method helps determine if a frog is in a location<br>
     * where it can eat a fly or not. A frog can eat the fly if it<br>
     * is on the same square as the fly or 1 spaces away in<br>
     * one of the cardinal directions
     *
     * @return boolean true if the fly can be eaten, false otherwise
     */ 
    public boolean eatsFly()
    {   
        //location of Frog
        int rowF = location.getRow();
        int colF = location.getCol();

        // location of Mosca

        int rowM = world.getFlyLocation().getRow();
        int colM = world.getFlyLocation().getCol();

        if (rowF == rowM && colF==colM){
            return true;
        }
        if (rowF+1 == rowM && colF == colM){
            return true;
        }
        if (rowF-1 == rowM && colF == colM){
            return true;
        }
        if (rowF == rowM && colF-1 == colM){
            return true;
        }
        if (rowF == rowM && colF+1 == colM){
            return true;
        }
        return false; 
    }   
}
