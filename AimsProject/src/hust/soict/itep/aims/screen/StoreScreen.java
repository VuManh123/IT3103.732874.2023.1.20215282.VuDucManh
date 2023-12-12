package hust.soict.itep.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;


public class StoreScreen extends JFrame {
    private static Store store;
    private static Cart cart;
    private JPanel center;

    public StoreScreen(Store store, Cart cart) throws HeadlessException {
        this.store = store;
        this.cart = cart;
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

    public static void main(String[] args) throws HeadlessException {
        store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",  "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        CompactDisc cd = new CompactDisc("Hay Trao Cho Anh", "VPop", 17.04f, "Son Tung MTP", "MTP");
        Track track1 = new Track("Bonjour", 17);
        Track track2 = new Track("Monsieur", 22);
        cd.addTrack(track1);
        cd.addTrack(track2);
        store.addMedia(cd);

        List<String> authors1 = new ArrayList<>();
        authors1.add("Vu Duc Manh");
        List<String> authors2 = new ArrayList<>();
        authors2.add("Vu Duc Cuong");
        Book book1 = new Book(2345, "Manh Vu", "Comic", 20.25f, authors1);
        Book book2 = new Book(1234, "Hello Kitty", "Action", 17.04f, authors2);
        store.addMedia(book1);
        store.addMedia(book2);

        new StoreScreen(store, cart);
    }


    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store"); // sm = sub-menu
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCDMenu);
        smUpdateStore.add(addDVDMenu);


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

        JLabel title = new JLabel("AIMS");
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

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

}