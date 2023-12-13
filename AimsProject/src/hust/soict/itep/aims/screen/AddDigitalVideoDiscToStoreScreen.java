package hust.soict.itep.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.itep.aims.screen.MediaStore;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.NegativeNumberException;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    String title, category, cost, director, length;
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
        super(store, cart, storeScreenCenter);
        JPanel dirP = super.createSubPanel("Director");
        JPanel lenP = super.createSubPanel("Length");
        super.getCenterPanel().add(dirP, BorderLayout.CENTER);
        super.getCenterPanel().add(lenP, BorderLayout.CENTER);
        JButton btn = new JButton("Add");
        btn.addActionListener(new btnListener());
        super.getCenterPanel().add(btn, BorderLayout.SOUTH);
        super.setTitle("add DVD");
    }

    private class btnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for(JTextField tf: textFields) {
                if(tf.getName().equals("Title")) {
                    title = tf.getText();
                }
                if(tf.getName().equals("Cost")) {
                    cost = tf.getText();
                }
                if(tf.getName().equals("Category")) {
                    category = tf.getText();
                }
                if(tf.getName().equals("Director")) {
                    System.out.println(tf.getText());
                    director = tf.getText();
                }
                if(tf.getName().equals("Length")) {
                    length = tf.getText();
                }
            }

            DigitalVideoDisc dvd;
            try {
                dvd = new DigitalVideoDisc(title, category, director, Integer.parseInt(length), Float.parseFloat(cost));
                if(store.addMedia(dvd)) {
                    StoreScreenCenter.add(new MediaStore(dvd));
                    StoreScreenCenter.repaint();
                    StoreScreenCenter.revalidate();
                }else {
                    JOptionPane.showMessageDialog(centerPanel, "This DVD is already in your store!");
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
                e1.printStackTrace();
            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
                e1.printStackTrace();
            }
        }


    }

}