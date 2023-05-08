package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.Blog;
import techorda.bitlab.kz.db.Category;
import techorda.bitlab.kz.db.Comment;
import techorda.bitlab.kz.db.DBConnection;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readblog")

public class BlogDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = DBConnection.getBlog(id);
        request.setAttribute("blog", blog);
        ArrayList<Category> categories = DBConnection.getCategories();
        request.setAttribute("categories", categories);
        if(blog != null){
            ArrayList<Comment> comments = DBConnection.getAllComments(blog.getId());
            request.setAttribute("comments", comments);
        }
        request.getRequestDispatcher("blogdetails.jsp").forward(request, response);
    }
}
