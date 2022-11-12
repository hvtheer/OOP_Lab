public class Aims {
    public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King",
				"Animation","Roger Allder", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Sci-fi","Geogre Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation","Roger Allder", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//Cart Display DVD Details
		System.out.println();
        anOrder.displayCart();
		
        //Calculate total Cost
        System.out.printf("Total: %5.2f \n", anOrder.totalCost());
        
        // Remove DVD from cart
        System.out.println();
        anOrder.removeDigitalVideoDisc(dvd1);
        anOrder.displayCart();

        //Calculate total Cost
        System.out.printf("Total: %5.2f \n", anOrder.totalCost());
	}
}
