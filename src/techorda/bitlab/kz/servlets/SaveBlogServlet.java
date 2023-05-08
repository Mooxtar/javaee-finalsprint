package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.Blog;
import techorda.bitlab.kz.db.Category;
import techorda.bitlab.kz.db.DBConnection;
import techorda.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/saveblog")
public class SaveBlogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirect = "/login";
        request.setCharacterEncoding("utf8");
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {

            redirect = "/";
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int id = Integer.parseInt(request.getParameter("blog_id"));
            int category = Integer.parseInt(request.getParameter("category"));

            Category category1 = DBConnection.getCategory(category);

            Blog blog = DBConnection.getBlog(id);
            if (blog != null) {
                blog.setTitle(title);
                blog.setContent(content);
                blog.setCategory(category1);
                DBConnection.saveBlog(blog);
                redirect = "/readblog?id=" + id;
            }
        }

        response.sendRedirect(redirect);

    }
}
