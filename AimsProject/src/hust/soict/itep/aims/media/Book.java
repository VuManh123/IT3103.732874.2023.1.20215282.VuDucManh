package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Book extends Media{
    private static final String AUTHOR_ALREADY_ADDED_MESSAGE = "Tác giả này đã được thêm trước đó!";
    private static final String AUTHOR_ADDED_MESSAGE = "Tác giả %s đã được thêm";
    private static final String AUTHOR_REMOVED_MESSAGE = "Tác giả %s đã bị xóa!";
    private static final String AUTHOR_NOT_EXIST_MESSAGE = "Tác giả này không tồn tại!";
    private List<String> authors = new ArrayList<>();

    // Check các trường rỗng, giá nhỏ hơn 0
    public Book(int id, String title, String category, float cost, List<String> authors)
            throws NullPointerException, IllegalArgumentException {
        if (Objects.requireNonNull(title).isBlank()) {
            throw new NullPointerException("Title field is empty!");
        }
        if (Objects.requireNonNull(category).isBlank()) {
            throw new NullPointerException("Category field is empty!");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative!");
        }
        if (authors == null || authors.isEmpty()) {
            throw new NullPointerException("Authors field is empty!");
        }
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = new ArrayList<>(authors);
    }

    // TODO: Thêm các phương thức getter, setter nếu cần thiết
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        for (String name : this.authors) {
            if (Objects.equals(name.toLowerCase(), authorName.toLowerCase())) {
                System.out.println(AUTHOR_ALREADY_ADDED_MESSAGE);
                return;
            }
        }
        this.authors.add(authorName);
        System.out.println(String.format(AUTHOR_ADDED_MESSAGE, authorName));
    }

    public void removeAuthor(String authorName) {
        for (Iterator<String> iterator = this.authors.iterator(); iterator.hasNext(); ) {
            String tmp = iterator.next();
            if (tmp.equalsIgnoreCase(authorName)) {
                iterator.remove();
                System.out.println(String.format(AUTHOR_REMOVED_MESSAGE, authorName));
                return;
            }
        }
        System.out.println(AUTHOR_NOT_EXIST_MESSAGE);
    }

    // ToString() Method
    public String toString() {
        return "Book ID: " + this.id + " Title: " + this.title + " Author: " + this.authors + " Category: " + this.category + " Cost: " + this.cost + "$";
    }
}

