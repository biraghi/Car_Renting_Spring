package com.carrenting.spring.repository;

import com.carrenting.spring.entity.User;
import com.carrenting.spring.config.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Override
    public List<User> selAllUser() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public User selUserFromId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where id = "+id, User.class).getSingleResult();
        }
    }

    @Override
    public User selUserFromUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where username = '" + username + "'", User.class).getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void insUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delUserFromId(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("id", id));
            session.delete(cr.uniqueResult());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
