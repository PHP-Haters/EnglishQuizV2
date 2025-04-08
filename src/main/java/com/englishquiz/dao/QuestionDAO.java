package com.englishquiz.dao;

import com.englishquiz.model.Level;
import com.englishquiz.model.Question;
import com.englishquiz.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QuestionDAO {

    public void save(Question question) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(question);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Question> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question", Question.class).list();
        }
    }

    public List<Question> findByLevel(Level level) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question where level = :level", Question.class)
                    .setParameter("level", level)
                    .list();
        }
    }
}
