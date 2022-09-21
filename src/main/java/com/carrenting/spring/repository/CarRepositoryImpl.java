package com.carrenting.spring.repository;

import com.carrenting.spring.config.HibernateUtil;
import com.carrenting.spring.entity.Car;
import com.carrenting.spring.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository{
    @Override
    public List<Car> selAllCar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car", Car.class).list();
        }
    }

    @Override
    public Car selCarFromId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car where id = " + id, Car.class).getSingleResult();
        }
    }

    @Override
    public Car selCarFromLicensePlate(String licensePlate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car where license_plate = '" + licensePlate + "'", Car.class).getSingleResult();
        }
    }

    @Override
    public void insCar(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delCarFromId(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Car.class);
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
