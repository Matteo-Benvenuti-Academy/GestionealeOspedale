package com.ospedale.GestionaleOspedale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ospedale.GestionaleOspedale.models.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer>{
	
}
