package hust.soict.itep.aims.media;

public class Track implements Playable {
    private String title;
    private int length;


    // Getters
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    // Constructor
    public Track(String title, int length) {
        super();
        this.title = title;
        this.length = length;
    }

    public Track() {
        // TODO Auto-generated constructor stub
    }
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
