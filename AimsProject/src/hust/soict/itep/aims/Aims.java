package hust.soict.itep.aims;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Cart anOrder = new Cart();
    private static Store store = new Store();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Tạo một giỏ hàng mới
        // Tạo các đối tượng đĩa DVD mới và thêm chúng vào giỏ hàng
        /*DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95F);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95F);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99F);
        anOrder.addMedia(dvd3);
        // In tổng giá trị của giỏ hàng
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Loại bỏ một đĩa DVD khỏi giỏ hàng và in tổng giá trị còn lại
        anOrder.removeMedia(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Lab03: Check method overloading:
        // Example using addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
        DigitalVideoDisc[] dvdArray = new DigitalVideoDisc[3];
        dvdArray[0] = new DigitalVideoDisc("Movie 1", "Category 1", "Director 1", 120, 19.99f);
        dvdArray[1] = new DigitalVideoDisc("Movie 2", "Category 2", "Director 2", 150, 24.99f);
        dvdArray[2] = new DigitalVideoDisc("Movie 3", "Category 1", "Director 3", 110, 17.99f);

        //anOrder.addMedia(dvdArray);

        // Example using addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Movie A", "Category 2", "Director A", 130, 21.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Movie B", "Category 3", "Director B", 140, 22.99f);

        //anOrder.removeMedia(dvd4, dvd5);

        anOrder.print();
        anOrder.search(1);
        anOrder.search("The Lion King");

        // Check Media
        List<Media> mediae = new ArrayList<Media>();
        Book book = new Book(9393, "Hoa giay", "Category 5", 21.98f, Collections.singletonList("Hoa"));
        mediae.add(0,book);
        mediae.add(1,dvd1);
        for (Media m: mediae){
            System.out.println(m.toString());
        }*/
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",  "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        CompactDisc cd = new CompactDisc("Hay Trao Cho Anh", "VPop", 17.04f, "Son Tung MTP", "MTP");
        Track track1 = new Track("Bonjour", 17);
        Track track2 = new Track("Monsieur", 22);
        cd.addTrack(track1);
        cd.addTrack(track2);
        store.addMedia(cd);

        List<String> authors1 = new ArrayList<>();
        authors1.add("Author1");
        authors1.add("Author2");

        List<String> authors2 = new ArrayList<>();
        authors2.add("Author3");
        authors2.add("Author4");
        Book book1 = new Book(2345, "Manh Vu", "Comic", 20.25f, authors1);
        Book book2 = new Book(1234, "Hello Kitty", "Action", 17.04f, authors2);
        store.addMedia(book1);
        store.addMedia(book2);
        showMenu();
    }

    private static void displayMainMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        System.out.println("Choice: ");
    }

    private static void displayStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        System.out.println("Choice: ");
    }

    private static void displayMediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.println("Choice: ");
    }

    private static void displayCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        System.out.println("Choice: ");
    }
    public static void showMenu() {
        for (;;) {
            displayMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    store.print();
                    storeMenu();
                    break;
                case 2:
                    mediaDetailsMenu();
                    break;
                case 3:
                    anOrder.print();
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid choice! Choose again!");
            }
        }
    }

    public static void storeMenu() {
        for (;;) {
            displayStoreMenu();
            int choice = scanner.nextInt();
            String str = null;
            Media check = null;
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter media's details: ");
                    scanner = new Scanner(System.in);
                    str = scanner.nextLine();
                    check = store.searchTitle(str);
                    if (check == null) {
                        System.out.println("This is not Title! Enter again!");
                        continue;
                    }
                    mediaDetailsMenu();
                    break;
                case 2:
                    System.out.println("Enter media's details: ");
                    scanner = new Scanner(System.in);
                    str = scanner.nextLine();
                    check = store.searchTitle(str);
                    if (check == null) {
                        System.out.println("This is not Title! Enter again!");
                        continue;
                    }
                    store.addMedia(check);
                    break;
                case 3:
                    System.out.println("Enter media's details: ");
                    scanner = new Scanner(System.in);
                    str = scanner.nextLine();
                    check = store.searchTitle(str);
                    if (check == null) {
                        System.out.println("This is not Title! Enter again!");
                        continue;
                    }
                    if (check instanceof DigitalVideoDisc ) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) check;
                        dvd.play();
                    } else if (check instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) check;
                        cd.play();
                    }
                    break;
                case 4:
                    anOrder.print();
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid choice! Choose again!");
            }
        }
    }


    public static void mediaDetailsMenu() {
        for(;;) {
            displayMediaDetailsMenu();
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter media's details: ");
                scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                anOrder.addMedia(check);
            } else if (choice == 2) {
                System.out.println("Enter media's details: ");
                scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                if (check instanceof DigitalVideoDisc ) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) check;
                    dvd.play();
                } else if (check instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) check;
                    cd.play();
                } else {
                    System.out.println("This is not DVD or CD!");
                }
            } else {
                System.out.println("Invaild! Choice again!");
            }
        }
    }

    public static void cartMenu() {
        for(;;) {
            displayCartMenu();
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                for(;;){
                    System.out.println("Filter by:");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.println("Choice: ");
                    Scanner filter = new Scanner(System.in);
                    int choice2 = scanner.nextInt();
                    if(choice2 == 1) {
                        System.out.println("Enter ID: ");
                        scanner = new Scanner(System.in);
                        int id = scanner.nextInt();
                        anOrder.filterById(id);
                        break;
                    } else if (choice2 == 2) {
                        System.out.println("Enter title: ");
                        scanner = new Scanner(System.in);
                        String title = scanner.nextLine();
                        anOrder.filterByTitle(title);
                        break;
                    } else {
                        System.out.println("Invaild! Choice again!");
                        continue;
                    }
                }
            } else if (choice == 2) {
                for(;;){
                    System.out.println("Sort by:");
                    System.out.println("1. Title");
                    System.out.println("2. Cost");
                    System.out.println("Choice: ");
                    Scanner sort = new Scanner(System.in);
                    int choice2 = scanner.nextInt();
                    if(choice2 == 1) {
                        anOrder.sortTitle();
                        break;
                    } else if (choice2 == 2) {
                        anOrder.sortCost();
                        break;
                    } else {
                        System.out.println("Invaild! Choice again!");
                        continue;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Enter media: ");
                scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                anOrder.removeMedia(anOrder.search(str));
            } else if (choice == 4) {
                System.out.println("Enter media's details: ");
                scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                if (check instanceof DigitalVideoDisc ) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) check;
                    dvd.play();
                } else if (check instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) check;
                    cd.play();
                }
            } else if (choice == 5) {
                System.out.println("An order is created!");
                anOrder.clear();
            } else {
                System.out.println("Invaild! Choice again!");
            }
        }
    }
}
