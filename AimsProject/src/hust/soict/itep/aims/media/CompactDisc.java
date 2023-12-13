package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

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
    public CompactDisc(int i, String director, String title, String category, float v, String artist) {
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
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                }catch(PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive! ");
        }
    }
}
