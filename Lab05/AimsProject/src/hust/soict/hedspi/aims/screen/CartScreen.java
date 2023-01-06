package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	
	public Scene getCartScreen(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("fxml/cart.fxml"));
		System.out.println(getClass()
				.getResource("fxml/cart.fxml"));
		CartScreenController controller = new CartScreenController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
