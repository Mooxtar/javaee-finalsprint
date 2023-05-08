package techorda.bitlab.kz.db;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private String comment;
    private Timestamp post_date;
    private User user;
    private Blog blog;

    public Comment(){
    }

    public Comment(int id, String comment, Timestamp post_date, User user, Blog blog) {
        this.id = id;
        this.comment = comment;
        this.post_date = post_date;
        this.user = user;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
