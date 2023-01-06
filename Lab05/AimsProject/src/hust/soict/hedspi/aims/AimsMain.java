package hust.soict.hedspi.aims;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.AddBookToStoreScreen;
import hust.soict.hedspi.aims.screen.AddCompactDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.AddDigitalVideoDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.CartScreen;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AimsMain extends Application{
	public static Cart cart;
	public static Store store;
	public static Scene cartScreen, storeScreen, bookScene, cdScene, dvdScene;
	public static Stage stages;
	
	@Override
	public void start(Stage stage) throws Exception {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		        stages = new Stage();
		    }
		});
		bookScene = new AddBookToStoreScreen().getBookScreen(stage);
		cdScene = new AddCompactDiscToStoreScreen().getCDScreen(stage);
		dvdScene = new AddDigitalVideoDiscToStoreScreen().getDVDScreen(stage);
		storeScreen = new StoreScreen().getStoreScreen(stage);
		cartScreen = new CartScreen().getCartScreen(stage);
		stage.setScene(storeScreen);
		stages = stage;
		stage.show();
	}
	
	public static void main(String args[]) {
		cart = new Cart();
		store = new Store();
		launch();
	}
	
}