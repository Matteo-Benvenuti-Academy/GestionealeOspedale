package com.ospedale.GestionaleOspedale.repository;



import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ospedale.GestionaleOspedale.models.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer>{
	
	Optional<Visita> findByCodiceUnivocoAndCodiceSegreto(String codiceUnivoco,String codiceSegreto);
	
	List<Visita> findByDataVisita(Date datavisita);
	
	List<Visita> findByDataVisitaBetween(Date start , Date end);

}