package hust.soict.itep.aims.media;

import java.util.Comparator;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        super();
        this.title = title;
    }

    public Media(String title, String category) {
        super();
        this.title = title;
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Media otherMedia = (Media) obj;

        // Check for null titles to avoid NullPointerException
        if (title == null && otherMedia.title != null) {
            return false;
        } else if (!title.equals(otherMedia.title)) {
            return false;
        }
        return true;
    }
    public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
            if (type == "title") {
                if (this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                    return true;
                }
            } else if (type == "id") {
                if(Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
