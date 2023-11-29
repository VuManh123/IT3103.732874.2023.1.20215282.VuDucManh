package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    // itemsOrdered array
    private List<Media> itemsOrdered = new ArrayList<Media>();

    // Method add Media
    public void addMedia(Media item ) {
        if (item == null) {
            System.out.println("Not found item! ");
        } else {
            if(itemsOrdered.contains(item)) {
                System.out.println("Item is already in the list!");
            } else {
                System.out.println("Item " + item.getTitle() +" added successfully");
                itemsOrdered.add(item);
            }
        }
    }

    // Remove media
    public void removeMedia(Media item) {
        if(!itemsOrdered.contains(item)) {
            System.out.println("Item is not already in the list!");
        } else {
            System.out.println("Item " + item.getTitle() +" remove successfully");
            itemsOrdered.remove(item);
        }
    }

    // Phương thức để tính tổng giá trị của các đĩa trong giỏ hàng
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    // Lab 03: Method overloading
    // Lab 03: Print()
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(itemsOrdered.get(i).getTitle()) ;
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************");
    }
    //Lab 03: Search
    public Media search(String title) {
        int index = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(index).getTitle() == title) {
                index++;
            }
        }
        if (index == 0 || itemsOrdered.size() == 0) {
            System.out.println("Cannot find DVD!\n");
        } else {
            System.out.println("Find " + index +" "+ title + " DVD\n");
        }
        return null;
    }

    public Media search(int id) {
        int index = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(index).getId() == id) {
                index++;
            }
        }
        if (index == 0 || itemsOrdered.size() == 0) {
            System.out.println("Cannot find DVD!\n");
        } else {
            System.out.println("Find " + index +" "+ id + " DVD\n");
        }
        return null;
    }

}
