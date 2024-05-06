package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SongDAO {
    private SessionFactory sessionFactory;

    public SongDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int updateSongTitle(int songId, String newTitle) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "update SongsEntity set title = :newTitle where songId = :songId";
            Query query = session.createQuery(hql);
            query.setParameter("newTitle", newTitle);
            query.setParameter("songId", songId);

            int result = query.executeUpdate();

            session.getTransaction().commit();

            return result;
        }
    }
}