package com.englishquiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.englishquiz.model.User;
import com.englishquiz.model.UserLevel;
import com.englishquiz.util.HibernateUtil;

public class UserLevelDAO {
        public void save(UserLevel userLevel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(userLevel);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<UserLevel> findByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from UserLevel ul "+
             "WHERE ul.user = :user", UserLevel.class)
                    .setParameter("user", user)
                    .list();
        }
    }
    
}
