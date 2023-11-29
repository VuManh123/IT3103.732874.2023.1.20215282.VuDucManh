package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    public MediaComparatorByTitleCost() {
        // TODO Auto-generated constructor stub
    }

    public int compare(Media o1, Media o2) {
        // TODO Auto-generated method stub
        if(o1.getTitle().compareTo(o2.getTitle()) > 0) {
            return 1;
        } else if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
            return -1;
        } else if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
            if (o1.getCost() < o2.getCost()) {
                return 1;
            } else if (o1.getCost() > o2.getCost()) {
                return -1;
            } else if (o1.getCost() == o2.getCost()){
                return 0;
            }
        }
        return 0;
    }

}
