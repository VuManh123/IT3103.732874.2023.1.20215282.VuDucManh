package hust.soict.itep.aims.screen;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    JPanel centerPanel;
    JPanel StoreScreenCenter;
    Store store;
    Cart cart;
    String title, category, cost;

    ArrayList<JTextField> textFields = new ArrayList<JTextField>();

    public AddItemToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
        this.store = store;
        this.cart = cart;
        this.StoreScreenCenter = storeScreenCenter;
        this.setSize(700, 400);

        this.setLayout(new BorderLayout());
        this.add(createCenter(), BorderLayout.CENTER);
        this.setVisible(true);
    }
    protected JPanel getCenterPanel() {
        return this.centerPanel;
    }

    protected JPanel createSubPanel(String text) {
        JPanel subContainer = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(50);
        tf.setName(text);
        textFields.add(tf);
        JLabel lb = new JLabel(text);
        subContainer.add(lb);
        subContainer.add(tf);
        subContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        return subContainer;

    }
    JPanel createCenter() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(10, 1, 5, 5));

        JPanel titleP = createSubPanel("Title");
        JPanel costP = createSubPanel("Cost");
        JPanel categoryP = createSubPanel("Category");

        centerPanel.add(titleP);
        centerPanel.add(costP);
        centerPanel.add(categoryP);

        return centerPanel;
    }

}
