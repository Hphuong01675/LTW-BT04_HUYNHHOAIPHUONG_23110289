package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import dao.UserDAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@WebServlet("/profile")
@MultipartConfig
public class ProfileController extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("/Views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");

        if (fullname != null) user.setFullname(fullname);
        if (phone != null) user.setPhone(phone);

        Part filePart = req.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream is = filePart.getInputStream();
                 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                user.setImageBlob(baos.toByteArray());
            }
        }

        userDAO.update(user);

        // Update session Base64
        if (user.getImageBlob() != null) {
            String base64 = Base64.getEncoder().encodeToString(user.getImageBlob());
            session.setAttribute("loggedUserImageBase64", base64);
        }

        session.setAttribute("loggedUser", user);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
