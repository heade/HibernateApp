package dubinin.kickstarter.service;

/**
 * Created by daniel on 3/6/16.
 */
public interface ObjectDuilder<T, U> {
    U build(T object);
}

