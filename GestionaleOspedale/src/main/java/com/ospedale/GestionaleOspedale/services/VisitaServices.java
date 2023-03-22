package com.ospedale.GestionaleOspedale.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ospedale.GestionaleOspedale.models.Visita;
import com.ospedale.GestionaleOspedale.repository.VisitaRepository;
import com.ospedale.GestionaleOspedale.utils.GeneraStringaUnivoca;

@Service
public class VisitaServices {
	
	@Autowired
	private VisitaRepository repository;
		
	public boolean insert (Visita visit) {
		
		String univoca = GeneraStringaUnivoca.generaStringaUnivoca(10) + (int) (System.currentTimeMillis() / 25000);
		String segreta = GeneraStringaUnivoca.generaStringaUnivoca(10) + (int) (System.currentTimeMillis() / 300000);
		visit.setCodiceUnivoco(univoca);
		visit.setCodiceSegreto(segreta);
		
		return repository.insert(visit);
	}
	
	public Visita findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Visita> findAll(){
		return repository.findAll();
	}
	
	public boolean delete (Integer varId) {
		if(this.findById(varId) == null)
			return false;
		
		return repository.delete(varId);
	}
	
	public boolean update(Integer varId, Visita visit) {
		Visita visitaVecchia = this.findById(varId);
		if(visitaVecchia == null)
			return false;
		
		visit.setId(varId);
		visit.setCodiceUnivoco(visitaVecchia.getCodiceUnivoco());
		visit.setCodiceSegreto(visitaVecchia.getCodiceSegreto());
		return repository.update(visit);
	}
	
	
	public List<Visita> findByCF(String codiceFiscale){
		return repository.findByCF(codiceFiscale);
	}
	
	public List<Visita> findByData(Date data) {
		return repository.findByData(data);
	}
	
	public List<Visita> findByPeriod(Date start ,Date stop) {
		return repository.findByPeriod(start,stop);
	}
	
	public Visita findByCodes(String codUni,String codSeg) {
		return repository.findByCodes(codUni,codSeg);
	}
}
	

