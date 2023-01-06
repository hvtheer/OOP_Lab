package hust.soict.hedspi.aims.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddDigitalVideoDiscToStoreScreen {
	public Scene getDVDScreen(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass()
					.getResource("fxml/DVD.fxml"));
		DVDController controller = new DVDController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}

}
