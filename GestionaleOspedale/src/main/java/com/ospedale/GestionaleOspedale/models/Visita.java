package com.ospedale.GestionaleOspedale.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Visite_mediche")
public class Visita {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitaID")
	private Integer Id;
	@Column
	private String nominativo;
	@Column
	private String codiceFiscale;
	@Column
	private String codiceUnivoco;
	@Column
	private String codiceSegreto;
	@Column
	private String esito;
	@Column
	private Date dataVisita;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer visitaID) {
		this.Id = visitaID;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
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
	
}
