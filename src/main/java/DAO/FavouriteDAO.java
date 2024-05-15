package DAO;

import DTO.FavoriteSong;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class FavouriteDAO {
    private SessionFactory sessionFactory;

    public FavouriteDAO() {
        sessionFactory = Connect.getSessionFactory();
    }


    public void addFavourite(int userId, int songId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "INSERT INTO FavoriteSong (userId, songId) VALUES (:userId, :songId)";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("songId", songId);

            query.executeUpdate();

            session.getTransaction().commit();

        }
    }


    public void removeFavourite(int userId, int songId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "DELETE FROM FavoriteSong WHERE userId = :userId AND songId = :songId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            query.setParameter("songId", songId);

            query.executeUpdate();

            session.getTransaction().commit();

        }
    }

    public List<FavoriteSong> getFavourites(int userId) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Query query = session.createQuery("from FavoriteSong where userId = :userId");
            query.setParameter("userId", userId);
            List<FavoriteSong> favoriteSongs = query.list();
            session.getTransaction().commit();

            return favoriteSongs;

        }
    }
}
