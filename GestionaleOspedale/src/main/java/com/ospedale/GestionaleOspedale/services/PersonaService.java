package com.ospedale.GestionaleOspedale.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.ospedale.GestionaleOspedale.dto.PersonaDto;
import com.ospedale.GestionaleOspedale.mapper.Mapper;
import com.ospedale.GestionaleOspedale.models.Persona;
import com.ospedale.GestionaleOspedale.repository.PersonaRepository;


public class PersonaService {
	
	@Autowired
	private PersonaRepository repository;
	@Autowired
	private Mapper mapper;
	
	public Persona findBycodiceFiscale(String cf) {
		return repository.findByCodiceFiscale(cf);
	}
}
