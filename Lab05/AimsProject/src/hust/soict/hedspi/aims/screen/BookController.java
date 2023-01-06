package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.AimsMain;
import hust.soict.hedspi.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;

public class BookController extends OptionBase{
	Stage stage;
	
	BookController(Stage stage){
		super(stage);
	}
	
	@FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField title;
    
    @FXML
    void addBookToStoreBtn(ActionEvent event) {
    	float bookCost;
    	
    	try {
    		bookCost = Float.parseFloat(cost.getText());
    		Book book = new Book(1, title.getText(), category.getText(), bookCost);
    		title.setText("");
    		category.setText("");
    		cost.setText("");
    		AimsMain.store.addMedia(book);
    		Dialog<String> dialog = new Dialog<String>();
    		//Setting the title
    	      dialog.setTitle("Add book");
    	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
    	      //Setting the content of the dialog
    	      dialog.setContentText("Add " + book.getTitle() + " sucessfully");
    	      //Adding buttons to the dialog pane
    	      dialog.getDialogPane().getButtonTypes().add(type);
    	      dialog.showAndWait();
    	} catch (Exception e) {
    		
    	}
    }
}
