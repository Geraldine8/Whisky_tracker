package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findByRegion(String region){

        List<Distillery> foundDistilleries = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));

            foundDistilleries = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return foundDistilleries;


    }

    @Transactional
    public List<Distillery> findByWhiskiesAge(int age){

        List<Distillery> foundDistilleries = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("age", age));

            foundDistilleries = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return foundDistilleries;


    }



}
