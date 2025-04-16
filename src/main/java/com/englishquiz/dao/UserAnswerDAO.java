package com.englishquiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.englishquiz.model.User;
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
    
    public List<UserAnswer> findByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from UserAnswer ua "+
            // "INNER JOIN ua.user u "+
            //  "INNER JOIN ua.answer "+
             "WHERE ua.user = :user", UserAnswer.class)
                    .setParameter("user", user)
                    .list();
        }
    }
}
