package hust.soict.itep.aims.screen;

import java.io.IOException;

import javax.swing.*;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class CartScreen extends JFrame{
    private Cart cart;
    private Store store;

    public CartScreen(Cart cart, Store store) {
        super();

        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/itep/aims/screen/cart.fxml"));
                    CartScreenController controller =  new CartScreenController(cart, store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
