package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_DVD = 1000;
	private int dvdStored = 0;
	private DigitalVideoDisc itemsInStore[] =  new DigitalVideoDisc[MAX_NUMBERS_DVD];
	
	public int getDvdStored() {
		return dvdStored;
	}

	public void setDvdStored(int dvdStored) {
		this.dvdStored = dvdStored;
	}
	
	public void addDVD(DigitalVideoDisc dvd) {
		int quantity = this.getDvdStored();
		if (quantity >= MAX_NUMBERS_DVD) {
			System.out.println("The cart is almost full.");
		} else {
			this.itemsInStore[quantity] = dvd;
			System.out.println("The disc has been added.");
			quantity = quantity + 1;
			this.setDvdStored(quantity);
		}
	}
	public void removeDVD(DigitalVideoDisc dvd) {
		DigitalVideoDisc itemsTempStored[] = new DigitalVideoDisc[this.getDvdStored()-1];
		for (int i = 0, j = 0; i < this.getDvdStored(); i++) {
			if (!this.itemsInStore[i].getTitle().equals(dvd.getTitle())) {
				itemsTempStored[j] = this.itemsInStore[i];
				j++;
			}
		}
		for (int k = 0; k < this.getDvdStored() - 1; k++) {
			this.itemsInStore[k] = itemsTempStored[k];
		}
		System.out.println("The disc has been removed.");
		this.setDvdStored(this.getDvdStored() - 1);
	}
}
