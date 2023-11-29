package hust.soict.itep.aims.media;

import java.util.Comparator;

public class Media {
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
    public Media() {
        // TODO Auto-generated constructor stub
    }

    // 10.	Unique item in a list
    public boolean equals(Object x) {
        try {
            if(x instanceof Media) {
                Media tmp = (Media) x;
                return tmp.getTitle().toLowerCase().equals(title.toLowerCase());
            }
        } catch (ClassCastException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("The class used for comparing is null!");
        }

        return false;
    }
    public String toString() {
        return "ID: " + this.id + " Title: " + this.title + " Category: " + this.category + " Cost: " + this.cost + "$";
    }
}
