package DAO;

import DTO.SongsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Connect {
    public static void main(String[] args) {
        Session session = null;
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(SongsEntity.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            List<SongsEntity> songsEntities = session.createQuery("select c from SongsEntity c", SongsEntity.class).list();

            for (SongsEntity song : songsEntities) {
                System.out.println("Song ID: " + song.getSongId());
                System.out.println("Song Name: " + song.getTitle());
                // Print other properties of the song...
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
