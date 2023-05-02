
// This is kind of like a LinkedListNode, but for it had two children instead of one (left and right).
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public int numChildren(){
        if (left == null && right == null){
            return 0;
        }
        else if (left == null && right != null){
            return 2;
        }
        return 1;
    }

    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }
}