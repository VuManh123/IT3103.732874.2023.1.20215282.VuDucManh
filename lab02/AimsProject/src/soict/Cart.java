package soict;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Method to add a abc.DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full. Cannot add more items.");
        }
    }

    // Method to remove a abc.DigitalVideoDisc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // Method to calculate the total cost of the items in the cart
    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
