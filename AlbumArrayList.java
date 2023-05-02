public class AlbumArrayList extends AlbumList{
    
    protected int numItems;
    private Album[] arr;
    

    public AlbumArrayList(){
        numItems = 0;
        Album [] arr = new Album[10];
		this.arr = arr;
	}
    public AlbumArrayList(int n){
        numItems = 0;
        Album [] arr = new Album[n];
		this.arr = arr;
	}
    public void add(Album newA){
        numItems += 1;
        if (numItems == 1){
            arr[0] = newA;
        }
        if (numItems > arr.length){
            Album [] arrn = new Album [numItems*2];
            for (int i = 0; i < numItems; i++){
                if (i < numItems-1 || i == 0){
                    arrn[i]=arr[i];
                }
                else{
                    arrn[i] = newA;
                }
                
            }
            arr = arrn;

        }
        else{
            arr[numItems-1] = newA;
        }

    }
  

    public Album remove(Album targetA){
        numItems -= 1;
        Album[] arrN = new Album[numItems];
        Album album = targetA;
        
        for (int i = 0; i < numItems; i++){
            if (targetA.toString().equals(arr[i].toString())){
                arrN[i] = arr[i+1];
            }
            else{
                arrN[i] = arr[i];
            }
            
        }

        if (arr[numItems] != album){
            arrN[numItems-1] = arr[numItems];
        }


        arr = arrN;
        return album;

    }

	public Album remove(int idx){
        Album[] arrN = new Album[numItems-1];
        Album album = arr[idx];
        numItems -= 1;

        for (int i = 0; i < numItems; i++){
            if (idx == i){
                arrN[i] = arr[i+1];
            }
            else{
                arrN[i] = arr[i];
            }
        }

        if (arr[numItems] != album){
            arrN[numItems-1] = arr[numItems];
        }

        arr = arrN;
        return album;

    }

	public int size(){
		return numItems;
	}

	public Album get(int idx){
        return arr[idx];
    }

	public void set(int idx, Album newA){
        try{
            if (idx < numItems && idx >= 0){
                arr[idx] = newA;    
            }
            else{
                throw new ArrayIndexOutOfBoundsException();
            }
            
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("wrong index");
        }
             

    }
    
}
