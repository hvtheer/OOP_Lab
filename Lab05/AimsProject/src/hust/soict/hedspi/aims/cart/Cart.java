package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public ObservableList<Media> getItemsOrdered(String title) {
		ObservableList<Media> mediaList = FXCollections.observableArrayList();
		if (title == "")
			return itemsOrdered;
		for (Media media : itemsOrdered) {
			if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
				mediaList.add(media);
			}
		}
		return mediaList;
	}
	public ObservableList<Media> getItemsOrdered(int id) {
		ObservableList<Media> mediaList = FXCollections.observableArrayList();
		mediaList.add(findMediaById(id));
		return mediaList;
	}
	
	public Media findMediaById(int id) {
		for (Media media : itemsOrdered)
			if (media.getId() == id)
				return media;
		return null;
	}
	
	public Media findMediaByTitle(String title) {
		for (Media media : itemsOrdered)
			if (media.getTitle().equals(title))
				return media;
		return null;
	}
	
	public void addMedia(Media item) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (!itemsOrdered.contains(item)) {
				itemsOrdered.add(item);
				System.out.printf("The item has been added\n");
				Dialog<String> dialog = new Dialog<String>();
			    dialog.setTitle("Add to cart");
			    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
			    dialog.setContentText("The " + item.getTitle() + " has been added!");
			    dialog.getDialogPane().getButtonTypes().add(type);
			    dialog.showAndWait();
			} else {
				System.out.printf("The item has been already added in list of ordered items\n");
				Dialog<String> dialog = new Dialog<String>();
			    dialog.setTitle("Add to cart");
			    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
			    dialog.setContentText("The " + item.getTitle() + " has been already added in list of ordered items!");
			    dialog.getDialogPane().getButtonTypes().add(type);
			    dialog.showAndWait();
			}
		} else {
			System.out.printf("The number of media has reached its limit\n");
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Add to cart");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("The number of media has reached its limit!");
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		}
	}
	
	public void removeMedia(Media item) {
		if (itemsOrdered.size() > 0) {
			if (itemsOrdered.contains(item)) {
				itemsOrdered.remove(item);
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
			System.out.printf("The item hasn't been already added in list of ordered items\n");
			Dialog<String> dialog = new Dialog<String>();
		    dialog.setTitle("Remove from cart");
		    ButtonType type = new ButtonType("Finish", ButtonData.OK_DONE);
		    dialog.setContentText("The " + item.getTitle() + " hasn't been already added in list of ordered items");
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.showAndWait();
		}
	}

	public double totalCost() {
		double total = 0;
		for (Media item : itemsOrdered) {
			total += (double)item.getCost();
		}
		return total;
	}

	public void displayCart() {
		System.out.println("***********************CART***********************");
        for (Media item : itemsOrdered){
            System.out.printf(item.toString());
        }
		System.out.printf("Total cost: %5.2f$\n", this.totalCost());
		System.out.println("***************************************************");
	}
	
	public void addMedia(Media... dvdList) {
		for (Media dvd : dvdList) {
			this.addMedia(dvd);
		}
	}

	public void addMedia(Media dvd1, Media dvd2) {
		this.addMedia(dvd1);
		this.addMedia(dvd2);
	}

	public void searchById(int id) {
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				System.out.printf(item.toString());
				return;
			}
        }
		System.out.printf("The item with id %d isn't not found\n", id);
	}

	public void searchByTitle(String title) {
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.printf(item.toString());
				return;
			}
		}
		System.out.printf("The item with title %s isn't not found\n", title);
	}
}
