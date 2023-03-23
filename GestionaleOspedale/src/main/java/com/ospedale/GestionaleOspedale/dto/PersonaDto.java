package com.ospedale.GestionaleOspedale.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class PersonaDto {
	
	private String cognome;
	private String codiceFiscale;
	
	@JsonBackReference
	private List<VisitaDto> visite;
	
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public List<VisitaDto> getVisite() {
		return visite;
	}
	public void setVisite(List<VisitaDto> visite) {
		this.visite = visite;
	}
}
