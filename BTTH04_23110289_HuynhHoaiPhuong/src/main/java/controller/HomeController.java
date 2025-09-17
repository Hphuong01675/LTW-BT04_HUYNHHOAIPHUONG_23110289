package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import model.User;
import dao.UserDAO;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Chuyển Blob image sang Base64
        if (user.getImageBlob() != null) {
            String base64 = Base64.getEncoder().encodeToString(user.getImageBlob());
            session.setAttribute("loggedUserImageBase64", base64);
        }

        req.getRequestDispatcher("/Views/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
