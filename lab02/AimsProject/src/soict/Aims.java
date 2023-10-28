package soict;

public class Aims {
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95F);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95F);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99F);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
