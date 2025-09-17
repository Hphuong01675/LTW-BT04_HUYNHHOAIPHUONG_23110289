package controller;

import dao.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/Views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Lấy User đầy đủ từ DB, bao gồm image
        User user = userDAO.findByUsernameAndPassword(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user); // lưu đầy đủ thông tin
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("/Views/login.jsp").forward(req, resp);
        }
    }
}
