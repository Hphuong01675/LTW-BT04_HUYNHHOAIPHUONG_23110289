package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import config.JPAUtil;

import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 15     // 15MB
)
public class UploadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        Part filePart = request.getPart("imageFile"); // input type="file" name="imageFile"

        byte[] imageData = null;
        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream is = filePart.getInputStream()) {
                imageData = is.readAllBytes();
            }
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            User user = new User();
            user.setUsername(username);
            user.setPassword("123"); // mật khẩu mặc định
            user.setFullname(username);
            user.setImageBlob(imageData); // mới: lưu BLOB vào DB

            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new ServletException("Upload thất bại", e);
        } finally {
            em.close();
        }

        response.getWriter().println("✅ Upload thành công cho user: " + username);
    }
}
