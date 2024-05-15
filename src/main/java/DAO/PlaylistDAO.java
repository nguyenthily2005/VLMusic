package DAO;

import DTO.PlaylistSongsEntity;
import DTO.PlaylistsEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PlaylistDAO {
    private SessionFactory sessionFactory;

    public PlaylistDAO() {
        this.sessionFactory = Connect.getSessionFactory();
    }

    public void createPlaylist(int userId, String playlistName) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "INSERT INTO PlaylistsEntity (userId, title) VALUES (:userId, :playlistName)";
            Query query = session.createQuery(hql);
            query.executeUpdate();

            session.getTransaction().commit();
        }
    }

    public void addSongToPlaylist(int playlistId, int songId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "INSERT INTO PlaylistSongsEntity (playlistId, songId) VALUES (:playlistId, :songId)";
            Query query = session.createQuery(hql);
            query.setParameter("playlistId", playlistId);
            query.setParameter("songId", songId);

            query.executeUpdate();

            session.getTransaction().commit();
        }
    }

    public void removePlaylist(int playlistId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = "DELETE FROM PlaylistsEntity WHERE playlistId = :playlistId";
            Query query = session.createQuery(hql);
            query.setParameter("playlistId", playlistId);

            query.executeUpdate();

            session.getTransaction().commit();
        }
    }

    public List<PlaylistsEntity> getPlaylists(int userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from PlaylistsEntity where userId = :userId");
            query.setParameter("userId", userId);
            List<PlaylistsEntity> playlists = query.list();

            session.getTransaction().commit();

            return playlists;
        }
    }

    public List<PlaylistSongsEntity> getPlaylistSongs(int playlistId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from PlaylistSongsEntity where playlistId = :playlistId");
            query.setParameter("playlistId", playlistId);
            List<PlaylistSongsEntity> playlists = query.list();

            session.getTransaction().commit();

            return playlists;
        }
    }
}
