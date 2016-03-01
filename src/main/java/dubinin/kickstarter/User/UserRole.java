package dubinin.kickstarter.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Daniel on 01.03.2016.
 */

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name", unique = true)
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    public UserRole(){
        this.role = Roles.ROLE_USER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof UserRole)) return false;
        UserRole uRole = (UserRole) obj;
        return role == uRole.role;
    }

    @Override
    public String toString() {
        return role.name();
    }
}
