package DAO;

import DTO.SongsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SongDAO {

    private SessionFactory sessionFactory;

    public SongDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }


    public List<SongsEntity> getAllSongs() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<SongsEntity> query = session.createQuery( "from SongsEntity", SongsEntity.class);
            List<SongsEntity> songs = query.list();

            session.getTransaction().commit();

            return songs;
        }
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