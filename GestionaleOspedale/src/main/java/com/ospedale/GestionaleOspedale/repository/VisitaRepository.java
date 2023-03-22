package com.ospedale.GestionaleOspedale.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ospedale.GestionaleOspedale.models.Visita;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

@Repository
public class VisitaRepository implements IDao<Visita>{
	
	@Autowired
	private EntityManager em;

	private Session getSessione() {
		return em.unwrap(Session.class);
	}
	
	@Override
	@Transactional
	public boolean insert(Visita t) {
		Session sessione = this.getSessione(); 
		
		try {
			sessione.save(t);
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}

		if(t.getId() == null)
			return false;
		
		return true;
	}

	@Override
	@Transactional
	public List<Visita> findAll() {
		Session sessione = this.getSessione();

		List<Visita> elenco = new ArrayList<Visita>();
		
		try {
			elenco = sessione.createQuery("FROM Visita").list();
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return elenco;
	}

	@Override
	@Transactional
	public Visita findById(Integer id) {
		Session sessione = this.getSessione();

		Visita temp = null;
		
		try {
			temp = sessione.get(Visita.class, id);
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return temp;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		Session sessione = this.getSessione();

		boolean risultato = false;
		
		try {
			Visita temp = sessione.get(Visita.class, id);
			sessione.delete(temp);
			
			risultato = true;
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return risultato;
	}

	@Override
	@Transactional
	public boolean update(Visita t) {
		Session sessione = this.getSessione();

		boolean risultato = false;
		
		try {
			sessione.update(t);
			
			risultato = true;
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return risultato;
	}
	
	
	@Transactional
	public List<Visita> findByCF(String codiceFiscale) {
		Session sessione = this.getSessione();

		List<Visita> elenco = new ArrayList<Visita>();
		
		try {
			Query q = sessione.createQuery("FROM Visita WHERE codiceFiscale = :c");
			q.setParameter("c", codiceFiscale);
			
			elenco = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return elenco;
	}
	
	@Transactional
	public List<Visita> findByData(Date data) {
		Session sessione = this.getSessione();

		List<Visita> elenco = new ArrayList<Visita>();
		
		try {
			Query q = sessione.createQuery("FROM Visita WHERE dataVisita = :d");
			q.setParameter("d", data);
			
			elenco = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return elenco;
	}
	
	@Transactional
	public List<Visita> findByPeriod(Date start ,Date stop) {
		Session sessione = this.getSessione();

		List<Visita> elenco = new ArrayList<Visita>();
		
		try {
			Query q = sessione.createQuery("FROM Visita WHERE dataVisita BETWEEN :start AND :end");
			q.setParameter("start", start);
			q.setParameter("end", stop);
			elenco = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return elenco;
	}
	
	@Transactional
	public Visita findByCodes(String codUni,String codSeg) {
		Session sessione = this.getSessione();

		Visita temp = null;
		
		try {
			Query query = sessione.createQuery("from Visita WHERE codiceUnivoco = :codUni AND codiceSegreto = :codSeg");
	        query.setParameter("codUni", codUni);
	        query.setParameter("codSeg", codSeg);
	        temp= (Visita) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return temp;
	}
	
}
