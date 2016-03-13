package dubinin.kickstarter.DAO;

import dubinin.kickstarter.entity.Roles;
import dubinin.kickstarter.entity.UserRole;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by daniel on 3/8/16.
 */
public class UserRoleService {

    @Autowired
    private MainDAO mainDAO;

    @Transactional(readOnly = true)
    public UserRole read(Roles role){
        return (UserRole) mainDAO.getSession().createCriteria(UserRole.class)
                .add(Restrictions.eq("role", role))
                .uniqueResult();
    }
}
