package hust.soict.itep.aims.media;

public class Disc extends Media{
    // 2 Thuoc tinh
    protected int length;
    protected String director;

    // Getters
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    // Constructor
    public Disc(int length, String director) {
        super();
        this.length = length;
        this.director = director;
    }

    public Disc() {
        // TODO Auto-generated constructor stub
    }
}
