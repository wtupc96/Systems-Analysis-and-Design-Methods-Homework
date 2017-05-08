package backEnd.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by wtupc96 on 2017/5/7.
 */
public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(2131);
        userEntity.setUsername("haha");
        userEntity.setPassword("12");

        session.save(userEntity);
        transaction.commit();

    }
}
