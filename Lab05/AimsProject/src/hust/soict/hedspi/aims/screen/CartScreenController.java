package hust.soict.hedspi.aims.screen;


import javafx.beans.value.ChangeListener ;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;

import hust.soict.hedspi.aims.AimsMain;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController extends OptionBase{
	private Stage stage;
	
	 @FXML
	 private Button btnPlay;

	 @FXML
	 private Button btnRemove;
	
	@FXML
	public TableView<Media> tblMedia;
	
	@FXML
	public TableColumn<Media, String> colMediaTitle;
	
	@FXML
	public TableColumn<Media, String> colMediaCategory;
	
	@FXML
	public TableColumn<Media, Float> colMediaCost;
	
	@FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private Button placeOrderBtn;
    
    @FXML
    private Label totalCost;
	
	public CartScreenController(Stage stage) {
		super(stage);
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		AimsMain.cart.removeMedia(media);
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		AimsMain.cart.getItemsOrdered().clear();
		Dialog<String> dialog = new Dialog<String>();
	      dialog.setTitle("Complete checkout");
	      ButtonType type = new ButtonType("Finsh", ButtonData.OK_DONE);
	      dialog.setContentText("Check out complete! Thank you ^^");
	      dialog.getDialogPane().getButtonTypes().add(type);
	      dialog.showAndWait();
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof Playable) {
			((Playable) media).play();
		}
	}
	
	
	@FXML
	private void initialize() {
		System.out.println(String.valueOf(AimsMain.cart.totalCost()));
		
		colMediaTitle.setCellValueFactory(
					new PropertyValueFactory<Media, String>("title")
				);
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category")
			);
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(AimsMain.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		setTotalCost();
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
				}
				);
		tblMedia.getItems().addListener(
				new ListChangeListener<Media>() {
					
					@Override
					public void onChanged(Change<? extends Media> arg0) {
						setTotalCost();
					}
				}
				);
		tfFilter.textProperty().addListener(
					new ChangeListener<String>() {
						@Override
						public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
							if(radioBtnFilterTitle.selectedProperty().getValue() || newValue.equals("")) {
								showFilteredMedia(newValue);
							} else {
								int id;
								try {
									id = Integer.parseInt(newValue);
								} catch (Exception e) {
									id = 0;
								}
							}
						}
					}
				);
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}
	
	void setTotalCost() {
		totalCost.setText(" " + Math.round(AimsMain.cart.totalCost()* 100.0) / 100.0 + " $");
	}
	
	void showFilteredMedia(String title) {
		tblMedia.setItems(AimsMain.cart.getItemsOrdered(title));
	}
	
	void showFilteredMedia(int id) {
		tblMedia.setItems(AimsMain.cart.getItemsOrdered(id));
	}
	
}
