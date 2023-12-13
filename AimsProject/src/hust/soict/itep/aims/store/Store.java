package hust.soict.itep.aims.store;
import java.util.ArrayList;

import hust.soict.itep.aims.media.Media;

public class Store {

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();


    //Add
    public boolean addMedia(Media item) {
        if (item == null) {
            System.out.println("Not found item! ");
        } else {
            if(itemsInStore.contains(item)) {
                System.out.println("Item is already in the list!");
            } else {
                System.out.println("Item " + item.getTitle() +" add successfully");
                itemsInStore.add(item);
            }
        }
        return false;
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
    //Print
    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).getTitle()) ;
        }
        System.out.println("**************************************************");
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

}
