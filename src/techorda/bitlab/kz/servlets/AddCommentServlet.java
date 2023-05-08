package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.Blog;
import techorda.bitlab.kz.db.Comment;
import techorda.bitlab.kz.db.DBConnection;
import techorda.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/addcomment")

public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/login";
        request.setCharacterEncoding("utf8");
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {

            String commentText = request.getParameter("comment");

            int blogId = Integer.parseInt(request.getParameter("blog_id"));

            Blog blog = DBConnection.getBlog(blogId);

            if(blog!=null){

                Comment comment = new Comment();

                comment.setComment(commentText);

                comment.setUser(currentUser);

                comment.setBlog(blog);

                if(DBConnection.addComment(comment)){

                    redirect = "/readblog?id="+blogId;

                }

            }

        }

        response.sendRedirect(redirect);
    }
}
