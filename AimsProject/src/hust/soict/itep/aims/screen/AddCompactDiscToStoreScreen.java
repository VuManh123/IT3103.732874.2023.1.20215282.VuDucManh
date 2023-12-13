package hust.soict.itep.aims.screen;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.itep.aims.screen.MediaStore;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.NegativeNumberException;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    JButton btnAdd = new JButton("Add");
    JButton btnAddTracks = new JButton("Add Tracks");

    CompactDisc disc;
    String director, length, artist;
    public AddCompactDiscToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
        super(store, cart, storeScreenCenter);
        JPanel director = super.createSubPanel("Director");
        JPanel length = super.createSubPanel("Length");
        JPanel artist = super.createSubPanel("Artist");
        super.centerPanel.add(director, BorderLayout.CENTER);
        super.centerPanel.add(length, BorderLayout.CENTER);
        super.centerPanel.add(artist, BorderLayout.CENTER);

        btnAdd.addActionListener(new btnListener());
        btnAddTracks.addActionListener(new btnListener());
        super.centerPanel.add(btnAdd);
        super.centerPanel.add(btnAddTracks);
        super.setTitle("Add CD");
        btnAdd.setVisible(false);
    }

    private class btnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Tracks")) {
                for (JTextField tf : textFields) {
                    if (tf.getName().equals("Title")) {
                        title = tf.getText();
                    }
                    if (tf.getName().equals("Cost")) {
                        cost = tf.getText();
                    }
                    if (tf.getName().equals("Category")) {
                        category = tf.getText();
                    }
                    if (tf.getName().equals("Director")) {
                        director = tf.getText();
                    }
                    if (tf.getName().equals("Length")) {
                        length = tf.getText();
                    }
                    if (tf.getName().equals("Artist")) {
                        artist = tf.getText();
                    }
                }

                try {
                    disc = new CompactDisc(Integer.parseInt(length), director ,title, category, Float.parseFloat(cost), artist);
                    new AddTrackToCDScreen(disc);
                    btnAdd.setVisible(true);
                    btnAddTracks.setVisible(false);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    e1.printStackTrace();
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    e1.printStackTrace();
                }

            }

            if(e.getActionCommand().equals("Add")) {
                if(store.addMedia(disc)) {
                    StoreScreenCenter.add(new MediaStore(disc));
                    StoreScreenCenter.repaint();
                    StoreScreenCenter.revalidate();
                }
            }

        }
    }
}