package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class DigitalVideoDisc extends Disc implements Playable {
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

	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Play");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("Playing DVD: " + this.getTitle() + "!\n DVD length: " + this.getLength());
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
    @Override
	
	public String toString() {
		return this.getId() + ".DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$\n";
	}
}