package com.ospedale.GestionaleOspedale.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ospedale.GestionaleOspedale.mapper.Mapper;
import com.ospedale.GestionaleOspedale.models.Visita;
import com.ospedale.GestionaleOspedale.repository.VisitaRepository;
import com.ospedale.GestionaleOspedale.utils.GeneraStringaUnivoca;

@Service
public class VisitaService {
	
	@Autowired
	private VisitaRepository repository;
	@Autowired
	private Mapper mapper;
		
	public boolean insert (Visita visit) {
		
		String univoca = GeneraStringaUnivoca.generaStringaUnivoca(10) + (int) (System.currentTimeMillis() / 25000);
		String segreta = GeneraStringaUnivoca.generaStringaUnivoca(10) + (int) (System.currentTimeMillis() / 300000);
		visit.setCodiceUnivoco(univoca);
		visit.setCodiceSegreto(segreta);
		
		return repository.save(visit) != null ? true : false ;
	}
	
	public Visita findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Visita> findAll(){
		return repository.findAll();
	}
	
	public boolean delete (Integer varId) {
		Visita temp = this.findById(varId);
		if(temp == null)
			return false;
		
		try {
			repository.delete(temp);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean update(Integer varId, Visita visit) {
		Visita visitaVecchia = this.findById(varId);
		if(visitaVecchia == null)
			return false;
		
		visit.setId(varId);
		visit.setCodiceUnivoco(visitaVecchia.getCodiceUnivoco());
		visit.setCodiceSegreto(visitaVecchia.getCodiceSegreto());
		return repository.save(visit) != null ? true : false ;
	}
	
	
	public List<Visita> findByData(Date data) {
		return repository.findByDataVisita(data);
	}
	
	public List<Visita> findByPeriod(Date start ,Date stop) {
		return repository.findByDataVisitaBetween(start,stop);
	}
	
	public Visita findByCodes(String codUni,String codSeg) {
		return repository.findByCodiceUnivocoAndCodiceSegreto(codUni,codSeg).orElse(null);
	}
}
	

