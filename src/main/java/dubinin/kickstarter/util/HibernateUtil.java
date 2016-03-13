package dubinin.kickstarter.util;

import org.hibernate.SessionFactory;


/**
 * Created by Daniel on 01.03.2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try{
            //create the session factory from hibernate.cfg.xml
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){return sessionFactory;}
}
