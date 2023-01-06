package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();

		Media dvd1 = new DigitalVideoDisc(1, "The lion king", "Animation", "Roger Aliers", 87, 19.95f);
		cart.addMedia(dvd1);

		Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);
		cart.addMedia(dvd2);

		Media dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", "Geore Lucas", 87, 18.99f);
		cart.addMedia(dvd3);

		// cart.displayCart();
		cart.searchById(2);
		cart.searchByTitle("Aladin");
	}

}
