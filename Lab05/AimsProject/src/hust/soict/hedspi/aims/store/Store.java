package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100;
	private ObservableList<Media> itemsInStore =
			FXCollections.observableArrayList();

	public void addMedia(Media item) {
		if (itemsInStore.size() < MAX_NUMBERS_IN_STORE) {
			if (!itemsInStore.contains(item)) {
				itemsInStore.add(item);
				System.out.printf("The item has been added\n");
				Dialog<String> dialog = new Dialog<String>();
			    dialog.setTitle("Add to store");
			    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
			    dialog.setContentText("The " + item.getTitle() + " has been added!");
			    dialog.getDialogPane().getButtonTypes().add(type);
			    dialog.showAndWait();
			} else {
				System.out.printf("The item has been already added in list of items in store\n");
				Dialog<String> dialog = new Dialog<String>();
			    dialog.setTitle("Add to store");
			    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
			    dialog.setContentText("The " + item.getTitle() + " has been already added in list of items in store!");
			    dialog.getDialogPane().getButtonTypes().add(type);
			    dialog.showAndWait();
			}
		} else {
			System.out.printf("The number of media has reached its limit\n");
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Add to store");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("The number of media has reached its limit!");
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		}
	}
	
	public void removeMedia(Media item) {
		if (itemsInStore.size() > 0) {
			if (itemsInStore.contains(item)) {
				itemsInStore.remove(item);
				System.out.printf("The item has been removed\n");
				Dialog<String> dialog = new Dialog<String>();
			    dialog.setTitle("Remove from cart");
			    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
			    dialog.setContentText("The " + item.getTitle() + " has been removed!");
			    dialog.getDialogPane().getButtonTypes().add(type);
			    dialog.showAndWait();
				return;
			}
		} else {
			System.out.printf("The item hasn't been already added in list of items in store\n");
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Remove from cart");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("The " + item.getTitle() + " hasn't been already added in list of items in store");
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		}
	}

	public void addMedia(Media[] itemsList) {
		for (Media item : itemsList) {
			this.addMedia(item);
		}
	}

	public void displayInStore() {
		System.out.println("***********************CART***********************");
		for (Media item : itemsInStore) {
			System.out.printf(item.toString());
		}
		System.out.println("***************************************************");
	}

	public ObservableList<Media> getItemsInStore() {
		return itemsInStore;
	}
}

