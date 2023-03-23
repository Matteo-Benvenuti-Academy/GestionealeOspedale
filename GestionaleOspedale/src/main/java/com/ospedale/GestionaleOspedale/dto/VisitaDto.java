package com.ospedale.GestionaleOspedale.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ospedale.GestionaleOspedale.models.Persona;

public class VisitaDto {

	
	private String codiceUnivoco;
	
	private String codiceSegreto;
	
	private String esito;
	
	private Date dataVisita;
	
	@JsonManagedReference
	private Persona paziente;

	
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

	public String getCodiceSegreto() {
		return codiceSegreto;
	}

	public void setCodiceSegreto(String codiceSegreto) {
		this.codiceSegreto = codiceSegreto;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Persona getPaziente() {
		return paziente;
	}

	public void setPaziente(Persona paziente) {
		this.paziente = paziente;
	}
}
