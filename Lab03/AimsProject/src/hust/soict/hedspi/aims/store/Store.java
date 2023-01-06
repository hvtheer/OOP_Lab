package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100;
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	private int qtyInStore;

	public int getQtyInStore() {
		return qtyInStore;
	}

	public void addDVD(DigitalVideoDisc disc) {
		if (qtyInStore < MAX_NUMBERS_IN_STORE) {
			itemsInStore.add(disc);
			qtyInStore++;
			System.out.printf("The disc %s has been added\n", disc.getTitle());
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void addDVD(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
			this.addDVD(dvd);
		}
	}

	public void removeDVD(DigitalVideoDisc disc) {
		if (qtyInStore > 0) {
			if (itemsInStore.contains(disc)) {
				itemsInStore.remove(disc);
				qtyInStore--;
				System.out.printf("The disc %s has been removed\n", disc.getTitle());
			} else {
				System.out.println("Not found");
			}
		}

	}

	public void displayInStore() {
		System.out.println("***********************CART***********************");
		for (DigitalVideoDisc disc : itemsInStore) {
			System.out.printf(disc.toString());
		}
		System.out.println("***************************************************");
	}
}

