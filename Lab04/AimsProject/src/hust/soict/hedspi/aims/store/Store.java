package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int qtyInStore;

	public int getQtyInStore() {
		return qtyInStore;
	}

	public void addMedia(Media item) {
		if (qtyInStore < MAX_NUMBERS_IN_STORE) {
			if (!itemsInStore.contains(item)) {
				itemsInStore.add(item);
				qtyInStore++;
				System.out.printf("The item has been added\n");
				return;
			}
		}
		else System.out.println("The cart is almost full");
	}
	
	public void removeMedia(Media item) {
		if (qtyInStore > 0) {
			if (itemsInStore.contains(item)) {
				itemsInStore.remove(item);
				qtyInStore--;
				System.out.printf("The item has been removed\n");
			} else 
				System.out.println("The item is already in list of ordered items");
		} else 
			System.out.println("Not found");
	}

	public void addDVD(Media... dvdList) {
		for (Media dvd : dvdList) {
			this.addDVD(dvd);
		}
	}

	public void displayInStore() {
		System.out.println("***********************CART***********************");
		for (Media item : itemsInStore) {
			System.out.printf(item.toString());
		}
		System.out.println("***************************************************");
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}

