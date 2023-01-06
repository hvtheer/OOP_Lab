package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
	// private static int nbDigitalVideoDiscs = 0;
		
	public DigitalVideoDisc(int id, String title, String director, int length) {
		super(id, title, director, length);
	}
	
	public DigitalVideoDisc(int id, String title, String category,  String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
    }

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
    @Override
	
	public String toString() {
		return this.getId() + ".DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$\n";
	}
}