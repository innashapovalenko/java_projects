public class CharLinkedList {
    private CharNode head;
    private int size;

    public CharLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void add(char x) {
        if (size == 0){
            head = new CharNode(x);
            // System.out.println(head);
            size += 1;
        }
        else if (size == 1){
            CharNode newNode = new CharNode(x);
            CharNode tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = newNode;     
            size += 1;    
        }
        else{
            CharNode newNode = new CharNode(x);
            CharNode tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            } 
            tmp.next = newNode;  
            size += 1;
        }
    }

    public void set(int i, char x) {
        try{
            //CharNode newNode = new CharNode(x);
            
            if (size == 0 || i < 0 || i>=size){
                throw new IndexOutOfBoundsException();
            }        

            CharNode tmp = head;
            for (int k = 0; k<i; k++){
                tmp = tmp.next;

            }
            tmp.c = x;
    
    }
    catch(IndexOutOfBoundsException e){
        System.out.println("index out of range");
        throw e;
    }
    }

    public char get(int i) {

            if (size == 0 || i < 0 || i>=size){
                throw new IndexOutOfBoundsException();
            }        
            CharNode tmp = head;
            for (int j = 0; j<i; j++){
                tmp = tmp.next;

            }
            return tmp.c;
    }

    public char remove(int i) {
        if (size == 0 || i < 0 || i>=size){
            throw new IndexOutOfBoundsException();
        }        
        CharNode tmp = head;
        for (int j = 0; j<i; j++){
            tmp = tmp.next;
        }
        tmp = tmp.next;
        size = size -1;
        return tmp.c;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String line = "";
        CharNode tmp = head;
        
        if (size == 0){
            return line;
        }
        line += tmp.c;  
        while (tmp.next != null){
            tmp = tmp.next;
            line = line + tmp.c;
        } 
        return line;
            
            
        
        
    }
}
