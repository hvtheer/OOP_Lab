package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private String director;
	private int length;
    
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public Disc(int id, String title, String director, int length) {
		super(id, title);
		this.director = director;
		this.length = length;
	}
	
	public Disc(int id, String title, String category,  String director, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

    public Disc(String title) {
        super(title);
    }
	
}
