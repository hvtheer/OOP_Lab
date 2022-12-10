package hust.soict.hedspi.aims.media;

public class Disc extends Media{
	private String director;
    private int length;
    
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
	
    public Disc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
    
	public Disc() {
		// TODO Auto-generated constructor stub
	}

}
