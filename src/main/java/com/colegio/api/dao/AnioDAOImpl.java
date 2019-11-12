package com.colegio.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.colegio.api.entity.Anio;

@Repository
public class AnioDAOImpl implements AnioDAO{
    
	@Autowired
    private EntityManager entityManager;

    @Override
    public List<Anio> findAll(){
    	Session currentSession = entityManager.unwrap(Session.class);
    	
    	Query<Anio> theQuery = currentSession.createQuery("FROM wp_anio", Anio.class);
        List<Anio> anios = theQuery.list();
        System.out.println(anios);
        return anios;
    }

    @Override
    public Anio findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        Anio anios = currentSession.get(Anio.class, id);
        return anios;
    }

    @Override
    public void save(Anio anio){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(anio);
    }

    @Override
    public void deleteById(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Anio> theQuery = currentSession.createQuery("delete from wp_anio where idAnio=:idAnio", Anio.class);
        theQuery.setParameter("idAnio", id);
        theQuery.executeUpdate();
    }
}