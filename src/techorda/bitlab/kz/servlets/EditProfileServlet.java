package techorda.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import techorda.bitlab.kz.db.DBConnection;
import techorda.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/edit-profile")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("user_id"));
        User user = DBConnection.getUser(Math.toIntExact((id)));
        request.setAttribute("user", user);
        request.getRequestDispatcher("editprofile.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("user_id"));
        User user = DBConnection.getUser(Math.toIntExact((id)));
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        user.setPassword(password);
        user.setFullName(fullName);
        DBConnection.saveUser(user);
        request.getSession().removeAttribute("currentUser");
        request.getSession().setAttribute("currentUser", user);
        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }
}
