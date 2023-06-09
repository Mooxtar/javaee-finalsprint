package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.Blog;
import techorda.bitlab.kz.db.Category;
import techorda.bitlab.kz.db.DBConnection;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = DBConnection.getCategories();
        ArrayList<Blog> blogs = DBConnection.getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
