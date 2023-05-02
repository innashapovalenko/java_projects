import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/** 
 * A very basic BST class
*/
public class BinarySearchTree
{
    // Special variables to help with tree drawing
    // You can ignore these three
    private static int gapCount = 0;
    private static final String gapNode = "[style=\"invis\"];\n";
    private static final String gapEdge = "[weight=100, style=\"invis\"];\n";
    
    private BSTNode root;

    /**
     * Creates an empty BST 
     */
    public BinarySearchTree()
    {
	root = null;
    }

    public void add(int value)
    {
	BSTNode newNode = new BSTNode(value);

	if (root == null)
	    root = newNode;
	else
	{
	    BSTNode tmp = root;
	    BSTNode parent = null;
	    
	    while (tmp != null)
	    {
		parent = tmp;
		if (value < tmp.value)
		    tmp = tmp.left;

		else
		    tmp = tmp.right;
	    }

	    newNode.parent = parent;
	    if (value < parent.value)
		parent.left = newNode;
	    else
		parent.right = newNode;
	}
    }

    public boolean find(int value)
    {
	if (root == null)
	    return false;
	
	BSTNode tmp = root;
	
	while (tmp != null)
	{
	    if (tmp.value == value)
		return true;
		
	    if (value < tmp.value)
		tmp = tmp.left;
	    else
		tmp = tmp.right;
	}

	return false;
    }

    /**
     * Should remove the node with given value from
     * the BST if it exists in the tree
     */
    public void remove(int value)
    {

		BSTNode n = findNode(value);
		if (n == null){
			return;
		}
		//no child case is working
		if (isLeaf(n))
		{
			if (isLeftChild(n)){
				n.parent.left = null;
			}
			else{
				n.parent.right = null;
			}
			return;
		}
	
		// one child case is working
		if (oneChild(n)){
			if (isLeftChild(n)){
				n.parent.left = oneSuccessor(n);
			}
			else{
				n.parent.right = oneSuccessor(n);
			}
			return;
		}
		//two children case
		BSTNode changevalue = inorderSuccessor(n);
		System.out.println(changevalue.value);
		int changeV = changevalue.value;
		remove(changevalue.value);
		n.value = changeV;
		// if (isLeftChild(n)){
		// 	remove(changevalue.value);
		// 	n.value = changeV;
		// }
		// else{
		// 	remove(changevalue.value);
		// 	n.value = changeV;
		// }
		
			

    }

	private boolean isLeftChild(BSTNode n){
		if (n.parent.value > n.value){
			return true;
		}
		return false;
	}
	
    /**
     * Helper function that works similiar to
     * find, except it returns the BSTNode (if found)
     * instead of true/false
     */
    private BSTNode findNode(int value)
    {
	if (root == null)
	    return null;
	
	BSTNode tmp = root;
	// if (tmp.value > value){
	// 	return (findNode(tmp.right.value));
	// }
	// else if (tmp.value < value){
	// 	return (findNode(tmp.left.value));
	// }
	// else{
	// 	return tmp;
	// }

	
	while (tmp != null)
	{
	    if (tmp.value == value){
			return tmp;
		}
		
		
	    if (value < tmp.value){
			tmp = tmp.left;
		}
		
	    else{
			tmp = tmp.right;
		}
		
	}

	return tmp;
	
    }
    
    private boolean isLeaf(BSTNode n)
    {
	return n.left == null && n.right == null;
    }
	private boolean oneChild(BSTNode n){
		if (n.left == null){
			if (n.right.left == null && n.right.right == null){
				return true;
			}
		}
		else if (n.right == null){
			if (n.left.left == null && n.left.right == null){
				return true;
			}
		}
		return false;
	}
	private BSTNode oneSuccessor(BSTNode n){
		BSTNode tmp = n;
		if (tmp.left != null){
			return tmp.left;
		}
		else {
			return tmp.right;
		}
	}

    /**
     * Finds the next node (in order) for some given node
     */
    private BSTNode inorderSuccessor(BSTNode n)
    {
		BSTNode tmp = n;

		if (tmp.left != null){
			tmp = tmp.left;
			while (tmp.right != null){
				tmp = tmp.right;
			}
			return tmp;
		}

		else if (tmp.right != null){
			tmp = tmp.right;
			while (tmp.left != null){
				tmp = tmp.left;
			}
			return tmp;
		}

		 
		else{
			return null;
		}

    }
	
    /**
     * Creates a text file for use with Graphviz's<br>
     * dot and dotty programs.<br><br>
     * Once the file is created you can create a pdf with an image of<br>
     * your tree by typing the following at the command-line:<br>
     * dot -Tpdf -o outputFile.pdf inputFile<br>
     * replacing outputFile.pdf with the name you wish to use<br>
     * for the output file and replacing inputFile with the name of<br>
     * the input file you generated.
     *
     * @param fileName
     */
    public void drawTree(String fileName)
    {
	BufferedWriter bw = null;

	try
	{
	    FileWriter fw = new FileWriter(fileName);
	    bw = new BufferedWriter(fw);

	    bw.write("graph BST {\n");

	    drawTreeHelper(root, bw);

	    bw.write("}\n");

	    bw.close();
	    fw.close();
	}
	catch (IOException ioe)
	{
	    System.out.println("Error opening file: " + ioe);
	}
    }

    private void drawTreeHelper(BSTNode n, BufferedWriter bw) throws IOException
    {
	String nodeID = "node" + ((Integer)n.hashCode()).toString();
	bw.write("\t" + nodeID + "[label=\"" + n.value + "\"];\n");

	String leftID = null;
	String rightID = null;
	
	if (n.left != null)	
	    leftID = "node" + ((Integer)n.left.hashCode()).toString();
	if (n.right != null)
	    rightID = "node" + ((Integer)n.right.hashCode()).toString();

	// Two children 
	if (n.left != null && n.right != null)
	{
	    gapCount++;
	    String gapID = "nodeg" + new Integer(gapCount).toString();
	    String gNode = gapID + gapNode;

	    // Write the nodes left, gap, right
	    bw.write("\t" + leftID + ";\n");
	    bw.write("\t" + gNode);
	    bw.write("\t" + rightID + ";\n");

	    // Write the edges left, gap, right
	    bw.write("\t" + nodeID + " -- " + leftID + ";\n");
	    bw.write("\t" + nodeID + " -- " + gapID + gapEdge);
	    bw.write("\t" + nodeID + " -- " + rightID + ";\n");

	    // Recurse left and right subtrees
	    drawTreeHelper(n.left, bw);
	    drawTreeHelper(n.right, bw);
	}
	else if (n.left != null)
	{
	    gapCount++;
	    String gapID = "nodeg" + new Integer(gapCount).toString();
	    String gNode = gapID + gapNode;

	    // Write the nodes left, gap
	    bw.write("\t" + leftID + ";\n");
	    bw.write("\t" + gNode);

	    // Write the edges left, gap
	    bw.write("\t" + nodeID + " -- " + leftID + ";\n");
	    bw.write("\t" + nodeID + " -- " + gapID + gapEdge);

	    // Recurse left subtree
	    drawTreeHelper(n.left, bw);   
	}
	else if (n.right != null)
	{
	    gapCount++;
	    String gapID = "nodeg" + new Integer(gapCount).toString();
	    String gNode = gapID + gapNode;

	    // Write the nodes gap, right
	    bw.write("\t" + gNode);
	    bw.write("\t" + rightID + ";\n");

	    // Write the edges gap, right
	    bw.write("\t" + nodeID + " -- " + gapID + gapEdge);
	    bw.write("\t" + nodeID + " -- " + rightID + ";\n");

	    // Recurse right subtree
	    drawTreeHelper(n.right, bw);
	}
    }
    
    public static void main(String [] args)
    {
	// Testing 2a
	int [] data = {44, 17, 32, 28, 88, 29, 97, 65, 82, 76, 54, 80, 78};
	BinarySearchTree tree = new BinarySearchTree();

	for (Integer i : data)
	    tree.add(i);

	tree.drawTree("Original.dot");
	tree.remove(29);
	tree.drawTree("remove29.dot");
	tree.remove(32);
	tree.drawTree("remove32.dot");
	tree.remove(65);
	tree.drawTree("remove65.dot");
	// tree.remove(82);
	// tree.drawTree("remove82.dot");


    }
}
