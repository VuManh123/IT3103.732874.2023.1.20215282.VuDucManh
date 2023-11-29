package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
    // Method add DVD
    public void addMedia(Media item) {
        if (item == null) {
            System.out.println("Not found item! ");
            return;
        } else {
            if(itemsInStore.contains(item)) {
                System.out.println("Item is already in the list!");
                return;
            } else {
                System.out.println("Item " + item.getTitle() +" add successfully");
                itemsInStore.add(item);
            }
        }
    }
    //Remove
    public void removeMedia(Media item) {
        if(!itemsInStore.contains(item)) {
            System.out.println("Item is not already in the list!");
            return;
        } else {
            System.out.println("Item " + item.getTitle() +" remove successfully");
            itemsInStore.remove(item);
        }
    }
    //Total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsInStore.size(); i++) {
            total += itemsInStore.get(i).getCost();
        }
        return total;
    }
    //Search by Title
    public Media searchTitle(String title) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(title)) {
                return itemsInStore.get(i);
            }
        }
        return null;
    }

    // Print
    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).getTitle()) ;
        }
        System.out.println("**************************************************");
    }
}
