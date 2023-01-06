package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}

	public String toString() {
		return id + ".DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$\n";
	}

	public boolean isMatch(String title) {
		return this.title.equals(title);
	}

	public boolean isMatch(int id) {
		return this.id == id;
	}
}
