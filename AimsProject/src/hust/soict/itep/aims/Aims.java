package hust.soict.itep.aims;
import java.util.Scanner;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.screen.CartScreen;
import hust.soict.itep.aims.screen.StoreScreen;
import hust.soict.itep.aims.store.Store;

public class Aims {
    static Cart anOrder = new Cart();
    static Store store = new Store();

    public static void main(String[] args) throws PlayerException {
        System.out.println("Enter media's details: ");
        Scanner keyboard = new Scanner(System.in);
        String str = keyboard.nextLine();
        Media check = store.searchTitle(str);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",  "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        CompactDisc cd = new CompactDisc(52, "Pop", "Doi Bo", "Lu Tien", 17.04f, "Truc Nhan");
        Track track1 = new Track("Duong", 17);
        Track track2 = new Track("Hust", 22);
        cd.addTrack(track1);
        cd.addTrack(track2);
        store.addMedia(cd);

        Book book1 = new Book("Cho toi mot ve di tuoi tho", "Comic", 20.25f);
        Book book2 = new Book("Toi thay hoa vang tren co xanh", "Action", 17.04f);
        book1.addAuthor("Nguyen Ngoc Anh");
        book2.addAuthor("Nguyen Ngoc Anh");
        store.addMedia(book1);
        store.addMedia(book2);
        showMenu();
        try {
            if (check instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) check;
                dvd.play();
            } else if (check instanceof CompactDisc) {
                CompactDisc c = (CompactDisc) check;
                c.play();
            }
        } catch (PlayerException e) {
            System.err.println("Error playing media: " + e.getMessage());

        }
    }

    public static void showMenu() throws PlayerException {
        for (;;) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            System.out.println("Choice: ");
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                new StoreScreen(store, anOrder);
                storeMenu();
            } else if (choice == 2) {
                mediaDetailsMenu();
            } else if (choice == 3) {
                anOrder.print();
                //new CartScreen(anOrder, store);
                cartMenu();
            } else {
                System.out.println("Invaild! Choice again!");
            }
        }
    }

    public static void storeMenu() throws PlayerException {
        for (;;) {
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
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                mediaDetailsMenu();
            } else if (choice == 2) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                store.addMedia(check);
            } else if (choice == 3) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
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
            } else if (choice == 4) {
                anOrder.print();
                cartMenu();
            } else {
                System.out.println("Invaild! Choice again!");
            }
        }
    }


    public static void mediaDetailsMenu() throws PlayerException {
        for(;;) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            System.out.println("Choice: ");
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
                Media check = store.searchTitle(str);
                if (check == null) {
                    System.out.println("This is not Title! Enter again!");
                    continue;
                }
                anOrder.addMedia(check);
            } else if (choice == 2) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
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

    public static void cartMenu() throws PlayerException {
        for(;;) {
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
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                for(;;){
                    System.out.println("Filter by:");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.println("Choice: ");
                    Scanner filter = new Scanner(System.in);
                    int choice2 = keyboard.nextInt();
                    if(choice2 == 1) {
                        System.out.println("Enter ID: ");
                        keyboard = new Scanner(System.in);
                        int id = keyboard.nextInt();
                        anOrder.filterById(id);
                        break;
                    } else if (choice2 == 2) {
                        System.out.println("Enter title: ");
                        keyboard = new Scanner(System.in);
                        String title = keyboard.nextLine();
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
                    int choice2 = keyboard.nextInt();
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
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
                anOrder.removeMedia(anOrder.search(str));
            } else if (choice == 4) {
                System.out.println("Enter media's details: ");
                keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
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
