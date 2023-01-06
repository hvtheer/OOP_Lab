package hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreScreen {
	
	public Scene getStoreScreen(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("fxml/store.fxml"));
		System.out.println(getClass()
				.getResource("fxml/store.fxml"));
		StoreController controller = new StoreController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
