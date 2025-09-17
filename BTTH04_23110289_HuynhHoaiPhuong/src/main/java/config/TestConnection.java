package config;

import model.User;
import jakarta.persistence.EntityManager;

public class TestConnection {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            System.out.println("✅ Kết nối thành công!");

            // Optional: thử thêm 1 user để test
            em.getTransaction().begin();
            User u = new User();
            u.setUsername("testuser");
            u.setPassword("123");
            u.setFullname("Test User");
            u.setPhone("0123456789");
            em.persist(u);
            em.getTransaction().commit();
            System.out.println("✅ Thêm User test thành công!");

        } catch (Exception e) {
            System.out.println("❌ Kết nối thất bại: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
            JPAUtil.close();
        }
    }
}
