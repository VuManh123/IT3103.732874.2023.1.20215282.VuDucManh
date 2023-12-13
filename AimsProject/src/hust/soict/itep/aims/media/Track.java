package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive! ");
        }
    }

    // 10.	Unique item in a list
    public boolean equals(Object x) {
        if(x instanceof Track) {
            Track tmp = (Track) x;
            return tmp.getTitle().toLowerCase().equals(this.title.toLowerCase()) && tmp.getLength()== this.length;
        }
        return false;
    }

}
