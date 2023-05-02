import javax.swing.text.AbstractDocument.LeafElement;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
      
        // TODO: Implement an add method to insert a value into the tree
        
        if(root == null){
            root = new TreeNode(value);
            return;
        }

        TreeNode currNode = root;
        while (true){
            System.out.println(currNode.value);
            if (value == currNode.value){
                return;
            }
            if (value < currNode.value){
                if (currNode.left == null){
                    currNode.left = new TreeNode(value);
                    return;
                }
                currNode = currNode.left;
            }
            else{
                if (currNode.right == null){
                    currNode.right = new TreeNode(value);
                    return;
                }
                currNode = currNode.right;
            }


        }
        
       
        
        
        // (1): if the root is null, then create a new TreeNode with the value and set it as the root.
        // (2): if the left child is null, then create a new TreeNode with the value and set it as the left child.
        // (3): if the right child is null, then create a new TreeNode with the value and set it as the right child.
        // (4): otherwise, set the current node to the left child and repeat steps 2 and 3.
    }

    public boolean contains(int value) {
        TreeNode currNode = root;
        while(currNode != null){
            if (currNode.value == value){
                return true;
            }
            else if (currNode.value < value){
                currNode  = currNode.right;
            }
            else{
                currNode = currNode.left;
            }
        }
        return false;
       
    }

    public void remove(int value) {
        TreeNode prevNode = null;
        TreeNode currNode = root;
        while (currNode != null) {
            if (currNode.value == value) {
                // No child case
                if (currNode.numChildren() == 0) {
                    removeHelper(prevNode, currNode);
                }
                //one child case
                else if (currNode.numChildren() == 1){
                    removeHelper(prevNode, currNode);
                }

                //two child case
                else{
                removeHelper(prevNode, currNode);
                }

            break;
        }
        
    }
    }

    private void removeHelper(TreeNode parent, TreeNode node){
        //no child case
        if (node.numChildren() == 0){
            if (parent.left == node){
                parent.left = null;
            }
            else if (parent.right == node){
                parent.right = null;
            }

            return;
        }
         //one child case
        if (node.numChildren() == 1){
            if (parent.left == node){
                if (parent.left.hasLeft()){
                    parent.left = parent.left.left;
                }
                else{
                    parent.left = null;
                }
                
            }
            else if (parent.right == node){
                if (parent.right.hasLeft()){
                    parent.right = parent.right.left;
                }
                else{
                    parent.right = null;
                }
                
            }
            return;
        }
        if (node.numChildren() == 2){
            if (parent.left == node){
                parent.left = parent.left.left;
            }
            else if (parent.right == node){
                parent.right = parent.right.left;
            }
            return;
        }
        //two child case
    }

    public void print() {
        // TODO: Implement a print method to print the tree.
        print_helper(root);
        System.out.println();
    }
    
    private static void print_helper(TreeNode node){
        if (node == null){
            return;
        }
        print_helper(node.left);
        System.out.println(node.value + ", ");
        print_helper(node.right);
    }
    public int size() {
        // TODO: Implement a method to count the number of nodes in the tree.
        return 0;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        // tree.print();
        // System.out.println(tree.contains(5));
        // System.out.println(tree.contains(3));
        // System.out.println(tree.contains(7));
        // System.out.println(tree.contains(2));
        // System.out.println(tree.contains(4));
        // System.out.println(tree.contains(6));
        // System.out.println(tree.contains(8));
        // System.out.println(tree.contains(1));
        System.out.println(tree.size());
        tree.remove(3);
        System.out.println("it should not contain");
        System.out.println(tree.contains(3));
        tree.print();
        System.out.println(tree.size());
    }
}