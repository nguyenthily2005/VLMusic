package DAO;

import DTO.SongsEntity;
import DTO.UsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connect {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(SongsEntity.class);
            configuration.addAnnotatedClass(UsersEntity.class);
            configuration.addAnnotatedClass(FavouriteDAO.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}