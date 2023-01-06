package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();

		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		// anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		// anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		// anOrder.addDigitalVideoDisc(dvd3);

		//Overloading by differing types of parameter
		DigitalVideoDisc[] dvdList = new DigitalVideoDisc[] { dvd1, dvd2, dvd3 };
		anOrder.addDigitalVideoDisc(dvdList);

		// display dvds' details in Cart
		System.out.println();
		anOrder.displayCart();

		// Remove DVD from cart
		System.out.println();
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.displayCart();

		//Overloading by differing the number of parameters
		System.out.println();
		anOrder.addDigitalVideoDisc(dvd2, dvd3);
		anOrder.displayCart();
	}
}
