package soict;

public class DigitalVideoDisc {
    // Khai báo các thuộc tính của lớp DigitalVideoDisc
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int ID;

    // Phần 1: Generate getter (Phương thức truy xuất giá trị)

    // Phương thức getter cho title (truy xuất tên)
    public String getTitle() { return title; }

    // Phương thức getter cho category (truy xuất thể loại)
    public String getCategory() { return category; }

    // Phương thức getter cho director (truy xuất đạo diễn)
    public String getDirector() { return director; }

    // Phương thức getter cho length (truy xuất độ dài)
    public int getLength() { return length; }

    // Phương thức getter cho cost (truy xuất giá trị)
    public float getCost() { return cost; }

    // Phần 2: Generate setter (Phương thức thiết lập giá trị)

    // Phương thức setter cho title (thiết lập tên)
    public void setTitle(String title) { this.title = title; }

    // Phương thức setter cho category (thiết lập thể loại)
    public void setCategory(String category) { this.category = category; }

    // Phương thức setter cho director (thiết lập đạo diễn)
    public void setDirector(String director) { this.director = director; }

    // Phương thức setter cho length (thiết lập độ dài)
    public void setLength(int length) { this.length = length; }

    // Phương thức setter cho cost (thiết lập giá trị)
    public void setCost(float cost) { this.cost = cost; }

    // Phần 3: Generate constructor (Hàm tạo)
    // Hàm tạo có tham số để khởi tạo đối tượng chỉ với tên
    public DigitalVideoDisc(String title) {
        super(); // Gọi constructor của lớp cha (Object)
        this.title = title;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại và giá trị
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại, đạo diễn và giá trị
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Hàm tạo có tham số để khởi tạo đối tượng với tên, thể loại, đạo diễn, độ dài và giá trị
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
}
