package hust.soict.hedspi.test.store;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) throws LimitExceededException {

		Store store = new Store();

		Media dvd1 = new DigitalVideoDisc(0, "The lion king", "Animation", "Roger Aliers", 87, 19.95f);

		Media dvd2 = new DigitalVideoDisc(0, "Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);

		Media dvd3 = new DigitalVideoDisc(0, "Aladin", "Animation", "Geore Lucas", 87, 18.99f);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.displayInStore();

		store.removeMedia(dvd3);
		store.displayInStore();
	}

}
