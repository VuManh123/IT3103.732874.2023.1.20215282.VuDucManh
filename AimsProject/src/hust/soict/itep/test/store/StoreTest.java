package hust.soict.itep.test.store;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Cart Store = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",  "Animation", "Roger Allers", 87, 19.95f);
        Store.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Store.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        Store.addDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(Store.totalCost());

        //Check remove
        Store.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(Store.totalCost());
    }
}
