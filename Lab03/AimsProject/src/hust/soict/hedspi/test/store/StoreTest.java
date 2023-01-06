package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {

		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Aliers", 87, 19.95f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geore Lucas", 87, 18.99f);

		store.addDVD(dvd1, dvd2, dvd3);
		store.displayInStore();

		store.removeDVD(dvd3);
		store.displayInStore();
	}

}
