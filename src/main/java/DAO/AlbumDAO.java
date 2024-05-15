package DAO;

import DTO.AlbumsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AlbumDAO {
    private SessionFactory sessionFactory;

    public AlbumDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }

    public List<AlbumsEntity> getAllAlbums() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<AlbumsEntity> query = session.createQuery("from AlbumsEntity", AlbumsEntity.class);
            List<AlbumsEntity> albums = query.list();

            session.getTransaction().commit();

            return albums;
        }
    }

}
