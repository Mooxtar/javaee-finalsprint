package techorda.bitlab.kz.db;

import java.sql.Timestamp;

public class Blog {
    private int id;
    private Timestamp post_date;
    private Category category;
    private String title;
    private String content;

    public Blog(){}

    public Blog(int id, Timestamp post_date, Category category, String title, String content) {
        this.id = id;
        this.post_date = post_date;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
