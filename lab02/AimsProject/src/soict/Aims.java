package soict;

public class Aims {
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        // Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng đĩa DVD mới và thêm chúng vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95F);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95F);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99F);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng giá trị của giỏ hàng
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Loại bỏ một đĩa DVD khỏi giỏ hàng và in tổng giá trị còn lại
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
