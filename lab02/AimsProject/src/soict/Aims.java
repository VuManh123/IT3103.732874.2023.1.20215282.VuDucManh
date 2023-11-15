package soict;
public class Aims {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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

        // Lab03: Check method overloading:
        // Example using addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
        DigitalVideoDisc[] dvdArray = new DigitalVideoDisc[3];
        dvdArray[0] = new DigitalVideoDisc("Movie 1", "Category 1", "Director 1", 120, 19.99f);
        dvdArray[1] = new DigitalVideoDisc("Movie 2", "Category 2", "Director 2", 150, 24.99f);
        dvdArray[2] = new DigitalVideoDisc("Movie 3", "Category 1", "Director 3", 110, 17.99f);

        anOrder.addDigitalVideoDisc(dvdArray);

        // Example using addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Movie A", "Category 2", "Director A", 130, 21.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Movie B", "Category 3", "Director B", 140, 22.99f);

        anOrder.addDigitalVideoDisc(dvd4, dvd5);

        anOrder.print();
    }
}
