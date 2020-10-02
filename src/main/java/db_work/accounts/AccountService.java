package db_work.accounts;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AccountService {
    private Session session;

    public AccountService(Session session) {
        this.session = session;
    }

    public UserProfile getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq("login", name)).uniqueResult();
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UserProfile(name, password));
    }
}
