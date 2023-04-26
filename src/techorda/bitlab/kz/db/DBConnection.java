package techorda.bitlab.kz.db;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DBConnection {

    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/techorda_db", "root", "root");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items");


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int id = resultSet.getInt("id");
                Item item = new Item((long)id, name, description, price);
                items.add(item);
                System.out.println(name + " " + description);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public static void addItem(Item item) {
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into items (name, description, price) " +
                    "values (?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String mail) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users where email = ?");
            statement.setString(1, mail);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getLong("id"));
            }
            else user = null;
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return user;

    }

}
