package DAO;

import DTO.PlaylistSongsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlaylistSongsDAO {
    private SessionFactory sessionFactory;

    public PlaylistSongsDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }

    public List<PlaylistSongsEntity> getAllPlaylistSongs() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<PlaylistSongsEntity> playlistSongs = session.createQuery("from PlaylistSongsEntity where playlistId = 1").list();
        session.getTransaction().commit();
        session.close();
        return playlistSongs;
    }
}
