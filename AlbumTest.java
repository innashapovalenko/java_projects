
class AlbumTest {
	public static void main(String[] args){
		// Test 1
		String badAlbum =  "Michael Jackson - BAD";

		Album a1 = new Album(badAlbum);

		System.out.println("a1 album: " + a1.getAlbum() + ". a1 artist: " + a1.getArtist());


		// Test 2
		String artist =  "Nina Simone";
		String album = "Black Gold";

		Album a2 = new Album(artist, album);

		System.out.println("a2 is " + a2);

	}
}

