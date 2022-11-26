package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	/**
	 * @param disc
	 */
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		int quantity = this.getQtyOrdered();
		if (quantity >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else {
			this.itemsOrdered[quantity] = disc;
			System.out.println("The disc has been added.");
			quantity = quantity + 1;
			this.setQtyOrdered(quantity);
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int quantity = this.getQtyOrdered();
		if (quantity + dvdList.length  > MAX_NUMBERS_ORDERED)
			System.out.println("The cart is almost full.");
		else {
			for (DigitalVideoDisc item : dvdList) {
				this.itemsOrdered[quantity] = item;
				quantity = quantity + 1;
				this.setQtyOrdered(quantity);
			}
			System.out.println("All disc of the list has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	/**
	 * @param disc
	 */
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc itemsTempOrdered[] = new DigitalVideoDisc[this.getQtyOrdered()-1];
		for (int i = 0, j = 0; i < this.getQtyOrdered(); i++) {
			if (!this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				itemsTempOrdered[j] = this.itemsOrdered[i];
				j++;
			}
		}
		for (int k = 0; k < this.getQtyOrdered() - 1; k++) {
			this.itemsOrdered[k] = itemsTempOrdered[k];
		}
		System.out.println("The disc has been removed.");
		this.setQtyOrdered(this.getQtyOrdered() - 1);
	}
	public double totalCost() {
		double total = 0;
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}
	public void displayCart() {
		System.out.println("=====DISPLAY CART=====");
		for (int i = 0; i < this.getQtyOrdered(); i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("===============");
		System.out.println("Total cost is: ");
		System.out.println(this.totalCost());
	}
	public boolean isMatch(String title) {
		for (DigitalVideoDisc item : this.itemsOrdered) {
			if (item.getTitle().equals(title))
				return true;
		}
		return false;
	}
	public void searchDVDByTitle(String title) {
		int count = 0;
		for (DigitalVideoDisc item : this.itemsOrdered) {
			if (item.getTitle().equals(title)) {
				System.out.println(item.toString());
				System.out.println("\n");
				count++;
			}
		}
		if (count == 0) System.out.println("No DVD is found with " + title);
	}
	public void searchDVDById(int id) {
		for (DigitalVideoDisc item : this.itemsOrdered) {
			if (item.getId() == id) {
				System.out.println(item.toString());
				return ;
			}
		}
		System.out.println("No DVD is found with this " + id);
	}
	/**
	 * @param qtyOrdered
	 */
	public Cart(int qtyOrdered) {
		super();
		this.qtyOrdered = qtyOrdered;
	}
}
