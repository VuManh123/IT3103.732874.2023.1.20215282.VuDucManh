package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyStore = 0;

    // Method add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyStore == MAX_NUMBERS_ORDERED) {
            System.out.println("The store is almost full");
            return;
        } else {
            itemsInStore[qtyStore] = disc;
            qtyStore++;
            System.out.println("The disc has been added");
        }
    }
    //Remove
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = 0;
        for (int i = 0; i < qtyStore; i++) {
            if (itemsInStore[i].equals(disc) ) {
                System.out.println("Remove " + itemsInStore[i].getTitle());
                System.arraycopy(itemsInStore, i+1, itemsInStore, i, itemsInStore.length-i-1);
                i--;
                qtyStore --;
                index ++;
            } else if (i == qtyStore-1 && index == 0) {
                System.out.println("Not found!");
            }
        }
    }
    //Total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyStore; i++) {
            total += itemsInStore[i].getCost();
        }
        return total;
    }
}
