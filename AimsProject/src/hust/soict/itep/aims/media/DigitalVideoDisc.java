package hust.soict.itep.aims.media;

import hust.soict.itep.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Khai báo các thuộc tính của lớp DigitalVideoDisc
    private String director;
    private int length;

    // Phần 1: Generate getter (Phương thức truy xuất giá trị)
    // Phương thức getter cho director (truy xuất đạo diễn)
    public String getDirector() { return director; }

    // Phương thức getter cho length (truy xuất độ dài)
    public int getLength() { return length; }

    // Phần 2: Generate setter (Phương thức thiết lập giá trị)
    // Phương thức setter cho director (thiết lập đạo diễn)
    public void setDirector(String director) { this.director = director; }

    // Phương thức setter cho length (thiết lập độ dài)
    public void setLength(int length) { this.length = length; }


    // Phần 3: Generate constructor (Hàm tạo)
    // Hàm tạo có tham số để khởi tạo đối tượng chỉ với tên
    public DigitalVideoDisc(String title) {
        super(); // Gọi constructor của lớp cha (Object)
        this.title = title;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại và giá trị
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại, đạo diễn và giá trị
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại, đạo diễn, độ dài và giá trị
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Lab 03
    // Write a toString() method for the DigitalVideoDisc class.
    public String toString() {
        return "DVD" + " - " + title + " - " + category + " - " + director + " - " + length + " : " + cost + " $";
    }

    // Lab 04
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
