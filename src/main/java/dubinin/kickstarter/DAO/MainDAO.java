package dubinin.kickstarter.DAO;

import org.hibernate.Session;

/**
 * Created by daniel on 3/7/16.
 */
public interface MainDAO {

    Session getSession();
    <E> E merge(E entity);
    <E> void persist(E entity);
    <E> E findEntity(Class<E> entity, Object id);
    <E> void remove(E entity);

}
