package com.ospedale.GestionaleOspedale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ospedale.GestionaleOspedale.models.Persona;
import com.ospedale.GestionaleOspedale.models.Visita;

public interface PersonaRepository  extends JpaRepository<Visita, Integer>{
	
	Persona findByCodiceFiscale(String cf);
}
