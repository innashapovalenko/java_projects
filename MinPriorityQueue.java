import java.util.ArrayList;

class MinPriorityQueue
{
    // Keep the nodes in an ArrayList.  Two advantages
    // (1) We can store objects that store both value and priority
    // (2) We don't have to worry about expanding
    // PriQueueNode is defined at the bottom of this file.
    ArrayList<PriQueueNode> items;

    /**
     * Creates an empty priority queue
     */
    public MinPriorityQueue()
    {
       items = new ArrayList<PriQueueNode>();
    }
 
    /**
     * @return the item with the minimum priority
     */
    public Object peek()
    {
       return items.get(0).data;
    }
    
    /**
     * Removes and returns the item with the minimum priority
     * @return the item associated with the minimum priority
     */
    public Object dequeue()
    {
        //root
        if (items.size()!= 1){
            PriQueueNode last = items.get(items.size()-1);
            items.set(0, last);
            items.remove(items.size()-1);
            bubbleDown(0);
        }
        
        
        return null; // In order to compile.  Please remove.
    }
  

    /**
     * Moves an item at the given index down the tree
     * As long as at least one of it's children is smaller
     * or we reach a leaf position.
     * @param idx the index of the item to move
     */
    protected void bubbleDown(int idx)
    {

    
        int childLeftIndx = 2*idx+1;
        int childRightIndx = 2*idx +2;

        if (childLeftIndx >= items.size() && childRightIndx >= items.size()){
            return;
        }

        try{

        
        double childLeftPriority = items.get(childLeftIndx).priority;
        // double childRightPriority = items.get(childRightIndx).priority;
        
        

        double childRightPriority = items.get(childRightIndx).priority;

        
        double currentRootPriority = items.get(idx).priority;



        if (currentRootPriority > childLeftPriority || currentRootPriority > childRightPriority){
            if (childLeftPriority < childRightPriority){
                
                PriQueueNode child = items.get(childLeftIndx);
                PriQueueNode current = items.get(idx);
                items.set(childLeftIndx, current);
                items.set(idx, child);
                bubbleDown(childLeftIndx);
            }
            else{
                PriQueueNode child = items.get(childRightIndx);
                PriQueueNode current = items.get(idx);
                items.set(childRightIndx, current);
                items.set(idx, child);
                bubbleDown(childRightIndx);
                

            }
        }
    }
    catch(IndexOutOfBoundsException e){
        e.printStackTrace();
    }
    }
 
     /**
      * Returns index position of the child node
      * whose priority is smallest.
      * A given index may only have 1 or no children.
      */
    protected Integer getMinChild(int idx)
    {
        
        double nowPr = items.get(idx).priority;
        PriQueueNode nowNode; 

        for (int i=idx; i<items.size(); i++){

             int leftChild = 2*idx+1;
             int rightChild = 2*idx +2;

             PriQueueNode leftC = items.get(leftChild);
             PriQueueNode rightC = items.get(rightChild);

             double leftPriority = items.get(leftChild).priority;
             double rightPriority = items.get(rightChild).priority;

             if (nowPr > leftPriority || nowPr > rightPriority){
                if (leftPriority < rightPriority){
                    nowNode = leftC;
                    nowPr = leftPriority;
                    return getMinChild(leftChild);
                }
                else{
                    nowNode = rightC;
                    nowPr = rightPriority;
                    return getMinChild(leftChild);
                }
             }
        }
        // FILL IN HERE
        int result = (int) nowPr;
        return result; // In order to compile.  Please remove.
    }
     
    /**
     * Inserts an item into the queue with the given priority
     * @param item the item to insert
     * @param priority the item's priority value
     */
    public void enqueue(double priority, Object val)
    {
        //The last thing in the list, is the last thing in the bottom layer
        PriQueueNode newItem = new PriQueueNode(priority, val);
        items.add(newItem);
        bubbleUp(items.size() - 1);
    }
    public Integer size(){
        return items.size();
    }
    public PriQueueNode get(int idx){
        return items.get(idx);
    }
 
    /**
     * Moves the item at the given index "up" the "tree" until its parent is smaller
     * @param idx the index of the item to move
     */
    protected void bubbleUp(int idx)
    {
        int parentIDX = (idx-1)/2; //if idx == 0, parent == 0, so priorities are the same!
        double parentPriority = items.get(parentIDX).priority;
        double currentPriority = items.get(idx).priority;
        if(currentPriority < parentPriority) {
            
            //Swap items
            PriQueueNode parent = items.get(parentIDX);
            PriQueueNode current = items.get(idx);
            items.set(parentIDX, current);
            items.set(idx, parent);
 
            bubbleUp(parentIDX); // Recursive implementation
        }
    }
 
    /**
     * @return a string representation of the heap
     */
    public String toString()
    {
        return items.toString();
    }
    
    public static void main(String [] args)
    {
        // Write tests here based on question two from previous in the lab
        // You can use arbitrary data (or perhaps null) for the "value" of each node
        // Make sure you use the same priorities, in the same order as in question two
        System.out.println("Your program is running, but you need to write some test code here in the main!");
        MinPriorityQueue items = new MinPriorityQueue();
        items.enqueue(12.2, "12.2");
        items.enqueue(23.0, "23.0");
        items.enqueue(9.0, "9.0");
        items.enqueue(8.0, "8.0");
        items.enqueue(12.0, "12.0");
        items.enqueue(15.5, "15.5");
        items.dequeue();
        items.dequeue();

        for (int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).toString() + " , ");
        }




    }
}

class PriQueueNode{

    // This object allows us to store the
    // data and the priority for this data 
    // together in "package" together
    //
    // +-PriQueueNode----+
    // | data: "hello!"  |
    // | pri: 2.4        |
    // +-----------------+
    public Object data;
    public double priority;

    public PriQueueNode(double pri, Object newVal){
        priority = pri;
        data = newVal;
    }

    public String toString(){
        return "(" + data + " {pri: " + priority + "})";
    }
}
