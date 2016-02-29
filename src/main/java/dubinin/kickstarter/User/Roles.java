package dubinin.kickstarter.User;

import java.io.Serializable;

/**
 * Created by Daniel on 29.02.2016.
 */
public enum Roles implements Serializable {

    ROLE_USER(1, "user"),
    ROLE_ADMIN(2, "admin"),
    ROLE_CLIENT(3, "client");

    private final int key;
    private final String role;

    Roles(int key, String role) {
        this.key = key;
        this.role = role;

    }


    public String getRole() {
        return role;
    }

}



