package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered =
			new ArrayList<Media>();
	private int qtyOrdered;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void addMedia(Media item) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			if (!itemsOrdered.contains(item)) {
				itemsOrdered.add(item);
				qtyOrdered++;
				System.out.printf("The item has been added\n");
			} else 
				System.out.println("The item is already in list of ordered items");
		} else 
			System.out.println("The cart is almost full");
	}
	
	public void removeMedia(Media item) {
		if (qtyOrdered > 0) {
			if (itemsOrdered.contains(item)) {
				itemsOrdered.remove(item);
				qtyOrdered--;
				System.out.printf("The item has been removed\n");
				return;
			}
		} else System.out.println("The item is not already in list of ordered items");
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
		for (Media item : itemsOrdered){
			if (item.getId() == id) {
				System.out.printf(item.toString());
				return;
			}
        }
		System.out.println("Not found");
	}

	public void searchByTitle(String title) {
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.printf(item.toString());
				return;
			}
		}
		System.out.println("Not found");
	}

	public ArrayList<Media> getItemsOrdered() {
		return null;
	}	
}
