package com.carrenting.spring.repository;

import com.carrenting.spring.config.HibernateUtil;
import com.carrenting.spring.entity.Booking;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepository{
    @Override
    public List<Booking> selAllBooking() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Booking", Booking.class).list();
        }
    }

    @Override
    public Booking selBookingFromId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Booking where id = " + id, Booking.class).getSingleResult();
        }
    }

    @Override
    public void insBooking(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delBookingFromId(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Booking.class);
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
