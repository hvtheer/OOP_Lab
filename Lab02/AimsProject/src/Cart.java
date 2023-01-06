import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDER = 20;
	
	ArrayList<DigitalVideoDisc> itemsOrder = new ArrayList<DigitalVideoDisc>();
	
	private int qtyOrdered;
	
	public int getQtyOrder() {
        return qtyOrdered;
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDER){
            itemsOrder.add(disc);
            qtyOrdered++;
            System.out.printf("The disc %s has been added\n", disc.getTitle());
        } else {
            System.out.println("The cart is almost full");
        }
	}
	
	public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (DigitalVideoDisc disc : itemsOrder){
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
        }
    }
	
	public double totalCost() {
		double total = 0;
		for (DigitalVideoDisc disc : itemsOrder){
			total += (double) disc.getCost();
		}
		return total;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > 0) {
			if (itemsOrder.contains(disc)) {
				itemsOrder.remove(disc);
				qtyOrdered--;
				System.out.printf("The disc %s has been removed\n",disc.getTitle());
			} else System.out.println("No found");
		} else System.out.println("Empty cart");
		
	}
}
