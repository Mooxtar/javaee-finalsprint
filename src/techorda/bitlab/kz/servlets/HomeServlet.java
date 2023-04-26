package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.DBConnection;
import techorda.bitlab.kz.db.Item;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList <Item> items = DBConnection.getAllItems();
        for (Item item : items) System.out.println(item);
        request.setAttribute("tovary", items);

        request.getRequestDispatcher("/shop.jsp").forward(request, response);
    }
    public void doPost(HttpServlet request, HttpServlet response) throws ServletException, IOException {

    }
}