package hust.soict.hedspi.aims.screen.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ObservableList;

public class StoreScreen extends JFrame {
    private Store store;
   
    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JPanel title = new JPanel();
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 6; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        
		Media dvd1 = new DigitalVideoDisc(1, "The lion king", "Animation", "Roger Aliers", 87, 19.95f);

		Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "Geore Lucas", 87, 24.95f);

		Media dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", "Geore Lucas", 87, 18.99f);

        Media dvd4 = new DigitalVideoDisc(4, "The lion king 2", "Animation", "Roger Aliers", 87, 19.95f);

		Media dvd5 = new DigitalVideoDisc(5, "Star Wars 2", "Science Fiction", "Geore Lucas", 87, 24.95f);

		Media dvd6 = new DigitalVideoDisc(6, "Aladin 2", "Animation", "Geore Lucas", 87, 18.99f);

        Media [] dvdList = new Media [] {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6};
		store.addMedia(dvdList);
		new StoreScreen(store);
    }

}
