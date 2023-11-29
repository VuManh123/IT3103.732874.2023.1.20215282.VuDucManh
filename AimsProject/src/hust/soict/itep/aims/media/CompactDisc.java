package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }


    public CompactDisc(String title, String category, float cost, String artist, String director) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.artist = artist;
        this.director = director;
    }
    public CompactDisc() {
        // TODO Auto-generated constructor stub
    }

    public int getLength(){
        int s=0;
        for(Track t: this.tracks)
        {
            s+= t.getLength();
        }
        return s;
    }
    public boolean addTrack(Track newTrack) {
        for(Track t: this.tracks)
            if(newTrack.getTitle().equals(t.getTitle())) {
                System.out.println("This track existed!");
                return false;
            }
        this.tracks.add(newTrack);
        return true;
    }

    public boolean removeTrack(Track removedTrack) {
        Iterator<Track> itr = this.tracks.iterator();
        while(itr.hasNext())
        {
            Track tmp = itr.next();
            if(tmp.getTitle().equals(removedTrack.getTitle())) {
                itr.remove();
                System.out.println("Track: "+ removedTrack.getTitle()+ " has been removed");
                return true;
            }
        }
        System.out.println("This track doesn't exist!");
        return false;
    }
    public void play() {
        // TODO Auto-generated method stub
        for (int i = 0; i < tracks.size(); i++) {
            tracks.get(i).play();
        }
    }
}
