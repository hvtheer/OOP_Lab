package hust.soict.hedspi.aims.media;

import java.util.Objects;

import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Track implements Playable {
	private String title;
    private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	public Track(int length) {
		super();
		this.length = length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Play");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("Playing Track: " + this.getTitle() + "!\n Track length: " + this.getLength());
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		return length == other.length && Objects.equals(title, other.title);
	}
}
