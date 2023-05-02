/**
 * Album represents an audio production by an artist
 */
public class Album{
	public String Artist;
    public String Album;


	public Album(String nArtist, String nAlbum){
		this.Artist = nArtist;
		this.Album = nAlbum;


	}

	public Album(String albumString){
		
		String [] parts = albumString.split(" - ");
		this.Album = parts[1];
		this.Artist = parts[0];

	}

	@Override
	public String toString(){
		return this.Artist + " - " + this.Album;
		
	}

	@Override
	public boolean equals(Object o){
		if (this == o) {
            return true;
        } else if (o instanceof Album) {
            
            Album p1 = (Album)o;
            
            return this.Album.equals(p1.Album) && this.Artist.equals(p1.Artist);

            
        } else {
            return false;
        }
    }


	public String getArtist() {
		return this.Artist;
	}

	public String getAlbum() {
		return this.Album;
	}
	
}