package hust.soict.itep.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;
import hust.soict.itep.aims.screen.CartScreen;


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

        CompactDisc cd = new CompactDisc(52, "Pop", "Doi Bo", "Lu Tien", 17.04f, "Truc Nhan");
        Track track1 = new Track("Duong", 17);
        Track track2 = new Track("Hust", 22);
        cd.addTrack(track1);
        cd.addTrack(track2);
        store.addMedia(cd);

        Book book1 = new Book("Cho toi mot ve di tuoi tho", "Comic", 20.25f);
        Book book2 = new Book("Toi thay hoa vang tren co xanh", "Action", 17.04f);
        book1.addAuthor("Nguyen Ngoc Anh");
        book2.addAuthor("Nguyen Ngoc Anh");
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
        addBookMenu.addActionListener(new btnListener());
        addDVDMenu.addActionListener(new btnListener());
        addCDMenu.addActionListener(new btnListener());


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


    private class btnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("View Cart")) {
                new CartScreen(cart, store)
                dispose();
            }
            if(command.equals("View Store")) {
                new StoreScreen(store, cart);
                dispose();
            }
            if(command.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store, cart, center);
            }
            if(command.equals("Add Book")) {
                new AddBookToStoreScreen(store, cart, center);
            }
            if(command.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store, cart, center);
            }
        }
    }

}
