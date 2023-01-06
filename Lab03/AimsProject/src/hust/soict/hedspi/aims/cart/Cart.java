package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	ArrayList<DigitalVideoDisc> itemsOrdered =
			new ArrayList<DigitalVideoDisc>();
	private int qtyOrdered;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(disc);
			qtyOrdered++;
			System.out.printf("The disc %s has been added\n", disc.getTitle());
		} else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > 0) {
			if (itemsOrdered.contains(disc)) {
				itemsOrdered.remove(disc);
				qtyOrdered--;
				System.out.printf("The disc %s has been removed\n", disc.getTitle());
			} else {
				System.out.println("Not found");
			}
		}

	}

	public double totalCost() {
		double total = 0;
		for (DigitalVideoDisc disc : itemsOrdered) {
			total += (double)disc.getCost();
		}
		return total;
	}

	public void displayCart() {
		System.out.println("***********************CART***********************");
        for (DigitalVideoDisc disc : itemsOrdered){
            System.out.printf(disc.toString());
        }
		System.out.printf("Total cost: %5.2f\n", this.totalCost());
		System.out.println("***************************************************");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
			this.addDigitalVideoDisc(dvd);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}

	public void searchById(int id) {
		for (DigitalVideoDisc disc : itemsOrdered){
			if (disc.isMatch(id)) {
				System.out.printf(disc.toString());
				return;
			}
        }
		System.out.println("Not found");
	}

	public void searchByTitle(String title) {
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc.isMatch(title)) {
				System.out.printf(disc.toString());
				return;
			}
		}
		System.out.println("Not found");
	}	
}
