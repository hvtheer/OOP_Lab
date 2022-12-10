package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media implements Playable{
	private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;
    
    public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	/**
     * The function takes the information stored in the object and returns it as a string
     *
     * @return A string representation of the DVD object.
     */
    public String toString(){
    	StringBuffer printDisc = new StringBuffer();
        printDisc.append("DVD");
        printDisc.append(" - ");
        printDisc.append(title);
        printDisc.append(" - ");
        printDisc.append(category);
        printDisc.append(" - ");
        printDisc.append(director);
        printDisc.append(" - ");
        printDisc.append(length);
        printDisc.append(": ");
        printDisc.append(cost);
        return  printDisc.toString();
    }
	
    /**
     * This function returns true if the title of the book is equal to the title passed in as a parameter.
     *
     * @param title The title of the page.
     * @return The boolean value of the comparison of the title of the book to the title of the book being searched for.
     */
    public boolean isMatch(String title){
        return this.title.equals(title);
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
