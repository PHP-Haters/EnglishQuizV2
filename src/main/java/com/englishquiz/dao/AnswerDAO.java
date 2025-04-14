package com.englishquiz.dao;

import com.englishquiz.model.Question;
import com.englishquiz.model.Answer;
import com.englishquiz.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnswerDAO {

    public void save(Answer answer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(answer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Answer> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer", Answer.class).list();
        }
    }

    public List<Answer> findByQuestion(Question question) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer where question = :question", Answer.class)
                    .setParameter("question", question)
                    .list();
        }
    }

    public Answer findAnswerWith(String decision, Question question) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer where question = :question AND content LIKE '"+decision+"%'", Answer.class)
                    .setParameter("question", question)
                    .uniqueResult();
        }
    }
}
