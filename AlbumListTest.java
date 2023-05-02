public class AlbumListTest {
    
	public static boolean add_empty() {
		AlbumArrayList list = new AlbumArrayList();
        // Album newAlbumArtist = new Album("infinity - survive");
        Album album = new Album("jd - k"); 
		list.add(album);
		System.out.println(list.get(0));
        System.out.println("size: "+list.size());


        return true;
	}
    public static boolean add_one() {
		AlbumArrayList list1 = new AlbumArrayList();
        // Album newAlbumArtist = new Album("infinity - survive");
        Album album = new Album("jd - k"); 
		list1.add(album);
        Album album1 = new Album("uk - ch"); 
        list1.add(album1);
        System.out.println("first element: "+list1.get(0));
		System.out.println("second element: "+list1.get(1));
        System.out.println("size: "+list1.size());


        return true;
	}

    public static boolean more_complex() {
        try{
            AlbumArrayList list1 = new AlbumArrayList();
        // Album newAlbumArtist = new Album("infinity - survive");
            Album album = new Album("jd - k"); 
            list1.add(album);
            Album album1 = new Album("uk - ch"); 
            list1.add(album1);
            Album album2 = new Album("mick - what's a wonderful world");
            list1.add(album2);
            list1.remove(album);
            list1.remove(0);
            Album album3 = new Album("kozak - oy u luzi chervona kalyna");
            list1.set(0, album3);
            System.out.println("first element: "+list1.get(0));
            // System.out.println("second element: "+list1.get(1));
            System.out.println("size: "+list1.size());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("wrong index");
        }
		



        return true;
	}


	public static void main(String[] args){
		System.out.println(add_empty());
        System.out.println(add_one());
        System.out.println(more_complex());
	}
}

