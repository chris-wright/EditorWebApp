package com.autoinput.spring.service;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.objects.Nation;
 
@Component
public class AppService {
    @Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveContinent(Continent continent) {
        Session session = sessionFactory.getCurrentSession();
        session.save(continent);
    }

    @Transactional
    public void saveNation(Nation nation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(nation);
    }
}