package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDER = 20;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public boolean addMedia(Media m) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDER) {
            return false;
        } else {
            itemsOrdered.add(m);
            return true;
        }
    }
	
	public boolean removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Media's removed successfully.");
            return true;
        } else {
            System.out.println("Can not remove media!");
            return false;
        }
    }
	
	/**--------------------------------------------------------------**/
	public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (Media disc : itemsOrdered){
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }
	
	public double totalCost() {
		double total = 0;
		for (Media m : itemsOrdered){
			total += (double) m.getCost();
		}
		return total;
	}

	/**
	    * This function display cart according to the assignment required format
	    * ***********************CART***********************
		* Ordered Items:
		* 1. DVD - [Title] - [category] - [Director] - [Length]: [Prsice] $
		* 2. DVD - [Title] - ...
		* Total cost: [total cost]
		* ***************************************************
	
	public void displayCart2() {
        System.out.println("***********************CART***********************\nOrdered Items:");
        int i=1;
        double total = 0;
        for (Media disc : itemsOrdered){
            System.out.printf("%d. DVD %-20s %-15s %-20s %-5d %-5.2f \n",i, disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
            i++;
            total += (double) disc.getCost();
        }
        System.out.printf("Total cost: %f", total);
    }
	**/
	
	/**
     * It searches for a DVD in the cart by its id.
     * @param id of the DVD to search
     * @return The method returns a boolean value.
     */
    public boolean searchInCart(int id){
        for (Media disc: itemsOrdered){
            if(disc.getId() == id){
                System.out.println(disc.toString());
                return true;
            }
        }
        System.out.println("Not found!");
        return false;
    }
	
}
