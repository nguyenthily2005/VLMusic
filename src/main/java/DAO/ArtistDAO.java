package DAO;

import DTO.ArtistsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ArtistDAO {
    private SessionFactory sessionFactory;

    public ArtistDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }

    public List<ArtistsEntity> getAllArtists() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ArtistsEntity> artists = session.createQuery("from ArtistsEntity").list();
        session.getTransaction().commit();
        session.close();
        return artists;
    }
}
