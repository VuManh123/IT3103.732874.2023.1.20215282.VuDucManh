package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.disc.DigitalVideoDisc;

public class Cart {
    // Định nghĩa hằng số MAX_NUMBERS_ORDERED với giá trị 20, giới hạn số lượng đĩa có thể được thêm vào giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Khai báo một mảng itemsOrdered để lưu trữ danh sách các đĩa DVD trong giỏ hàng, với kích thước là MAX_NUMBERS_ORDERED
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Biến qtyOrdered dùng để theo dõi số lượng đĩa DVD hiện đang có trong giỏ hàng
    private int qtyOrdered = 0;

    // Phương thức để thêm một đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) { // Kiểm tra xem giỏ hàng còn chỗ trống hay không
            itemsOrdered[qtyOrdered] = disc; // Thêm đĩa vào giỏ hàng
            qtyOrdered++; // Tăng số lượng đĩa đã thêm vào giỏ hàng
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full. Cannot add more items.");
        }
    }

    // Phương thức để loại bỏ một đĩa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--; // Giảm số lượng đĩa trong giỏ hàng sau khi loại bỏ
                System.out.println("The disc has been removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // Phương thức để tính tổng giá trị của các đĩa trong giỏ hàng
    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost(); // Lấy giá trị từ mỗi đĩa và cộng dồn vào tổng giá trị
        }
        return totalCost;
    }

    // Lab 03: Method overloading
    // Phương thức để thêm một danh sách đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        } else {
            for (int i = 0; i < dvdList.length; i++) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc has been added");
            }
        }
    }
    // Phương thức để thêm 2 đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        } else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
    }

    // Lab 03: Print()
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].getTitle());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************");
    }
    //Lab 03: Search
    public void search(String title) {
        int index = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle() == title) {
                index++;
            }
        }
        if (index == 0 || qtyOrdered == 0) {
            System.out.println("Cannot find DVD!");
        } else {
            System.out.println("Find " + index + title + "DVD\n");
        }
    }

    public void search(int id) {
        int index = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getID() == id) {
                index++;
            }
        }
        if (index == 0 || qtyOrdered == 0) {
            System.out.println("Cannot find DVD!");
        } else {
            System.out.println("Find " + index + id + "DVD\n");
        }
    }
}
