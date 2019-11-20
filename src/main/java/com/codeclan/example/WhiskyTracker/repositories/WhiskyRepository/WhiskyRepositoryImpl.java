package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;


public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom  {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findByYear(int year){

        List<Whisky> foundWhiskies = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));

            foundWhiskies = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return foundWhiskies;
    }


    @Transactional
    public List<Whisky> findWhiskiesFromADistilleryOfASpecificAge(Long id, int age) {

        List<Whisky> foundWhiskies = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.id", id));
            cr.add(Restrictions.eq("age", age));

            foundWhiskies = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }

        return foundWhiskies;
    }

    @Transactional
    public List<Whisky> findWhiskiesFromParticularRegion(String region) {

        List<Whisky> foundWhiskies = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.region", region));

            foundWhiskies = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }

        return foundWhiskies;
    }


}

