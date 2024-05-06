package DAO;

import DTO.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {
    private SessionFactory sessionFactory;

    public UserDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }

    // Method to get all users
    public List<UsersEntity> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from UsersEntity", UsersEntity.class).list();
        }
    }

    // Method to log up a user
    public void logupUser(UsersEntity user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }


    // Method to check if a user exists
    public boolean userExists(String usernameOrEmail) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from UsersEntity where username = :usernameOrEmail or email = :usernameOrEmail");
            query.setParameter("usernameOrEmail", usernameOrEmail);
            List<UsersEntity> users = query.list();
            return !users.isEmpty();
        }
    }

    // Method to get a user by username or email
    public UsersEntity getUserByUsernameOrEmail(String usernameOrEmail) {
        try (Session session = sessionFactory.openSession()) {
            Query<UsersEntity> query = session.createQuery("from UsersEntity where username = :usernameOrEmail or email = :usernameOrEmail", UsersEntity.class);
            query.setParameter("usernameOrEmail", usernameOrEmail);
            List<UsersEntity> users = query.list();
            if (!users.isEmpty()) {
                return users.get(0);
            }
        }
        return null;
    }

    // Method to change the password of a user
    public void changePassword(UsersEntity user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }
}