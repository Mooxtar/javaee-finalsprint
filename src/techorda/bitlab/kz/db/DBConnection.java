package techorda.bitlab.kz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/techorda_db",
                    "root",
                    "root");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User getUser(String email){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(int id) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getLong("id"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            else user = null;
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return user;

    }

    public static boolean addUser(User user){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users(email, password, full_name) " +
                    "VALUES (?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());

            rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM news_categories ORDER BY name ASC");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                categories.add(category);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    public static Category getCategory(int id) {
        Category category = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM news_categories WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    public static boolean addBlog(Blog blog){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (post_date, category_id, title, content)" +
                    "VALUES (NOW(), ?, ?, ?)");

            statement.setInt(1, blog.getCategory().getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContent());

            rows = statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Blog> getAllBlogs(){
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +

                    "SELECT b.id, b.title, b.content, b.post_date, b.category_id, c.id, c.name " +

                    "FROM news b " +

                    "INNER JOIN news_categories c ON c.id = b.category_id " +

                    "ORDER BY b.post_date DESC ");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Blog blog = new Blog();

                blog.setId(resultSet.getInt("id"));

                blog.setTitle(resultSet.getString("title"));

                blog.setContent(resultSet.getString("content"));

                blog.setPost_date(resultSet.getTimestamp("post_date"));

                Category category = new Category();

                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));

                blog.setCategory(category);

                blogs.add(blog);

            }

            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return blogs;
    }

    public static Blog getBlog(int id){
        Blog blog = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +

                    "SELECT b.id, b.title, b.content, b.post_date, b.category_id, c.id, c.name " +

                    "FROM news b " +

                    "INNER JOIN news_categories c ON c.id = b.category_id " +

                    "WHERE b.id = ?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                blog = new Blog();
                blog.setId(resultSet.getInt("id"));
                blog.setTitle(resultSet.getString("title"));

                blog.setContent(resultSet.getString("content"));

                blog.setPost_date(resultSet.getTimestamp("post_date"));
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                blog.setCategory(category);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }

    public static boolean addComment(Comment comment){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO comments (comment, post_date, user_id, blog_id) " +

                    "VALUES (?, NOW(), ?, ?)");



            statement.setLong(2, comment.getUser().getId());

            statement.setInt(3, comment.getBlog().getId());

            statement.setString(1, comment.getComment());



            rows = statement.executeUpdate();

            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Comment> getAllComments(int blogId){

        ArrayList<Comment> comments = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "SELECT c.id, c.user_id, c.comment, c.blog_id, u.full_name, u.email, c.post_date " +

                    "FROM comments c " +

                    "INNER JOIN users u ON c.user_id = u.id " +

                    "WHERE c.blog_id = ? " +

                    "ORDER BY c.post_date DESC");

            statement.setLong(1, blogId);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){



                Comment comment = new Comment();

                comment.setId(resultSet.getInt("id"));

                comment.setComment(resultSet.getString("comment"));

                comment.setPost_date(resultSet.getTimestamp("post_date"));



                User user = new User();

                user.setId(resultSet.getLong("user_id"));

                user.setFullName(resultSet.getString("full_name"));

                user.setEmail(resultSet.getString("email"));

                comment.setUser(user);

                Blog blog = new Blog();

                blog.setId(resultSet.getInt("blog_id"));

                comment.setBlog(blog);

                comments.add(comment);

            }

            statement.close();



        }catch (Exception e){

            e.printStackTrace();

        }

        return comments;

    }

    public static void saveBlog(Blog blog){
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news SET title = ?, category_id = ?, content = ?" +
                    "WHERE id = ?");

            statement.setString(1, blog.getTitle());
            statement.setInt(2, blog.getCategory().getId());
            statement.setString(3, blog.getContent());
            statement.setLong(4, blog.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBlog(int id) {
        try{

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM news WHERE id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUser(User user){
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET password = ?, full_name = ?" +
                    "WHERE id = ?");

            statement.setString(1, user.getPassword());
            statement.setString(2, user.getFullName());
            statement.setLong(3, user.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



