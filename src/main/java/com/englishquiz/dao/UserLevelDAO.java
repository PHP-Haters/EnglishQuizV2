package com.englishquiz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
    
}
