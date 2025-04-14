package com.englishquiz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.englishquiz.model.UserAnswer;
import com.englishquiz.util.HibernateUtil;

public class UserAnswerDAO {
    public void save(UserAnswer userAnswer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(userAnswer);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
