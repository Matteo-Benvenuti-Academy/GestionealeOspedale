package com.ospedale.GestionaleOspedale.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ospedale.GestionaleOspedale.models.Visita;
import com.ospedale.GestionaleOspedale.services.VisitaServices;

@RestController
@RequestMapping("ospedale")
public class VisitaController {
	
	
	@Autowired
	private VisitaServices service;
	
	
	@PostMapping
	public boolean insert (@RequestBody Visita objVis) {
		return service.insert(objVis);
	}
	
	@GetMapping("/{varId}")
	public Visita findById(@PathVariable Integer varId) {
		if(varId == null || varId <0)
			return null;
		
		return service.findById(varId);
	}
	
	@GetMapping
	public List<Visita> findAll(){
		return service.findAll();
	}
	
	@DeleteMapping("/{varId}")
	public boolean delete (@PathVariable Integer varId) {
		if(varId == null || varId < 0)
			return false;
		
		return service.delete(varId);
	}
	
	@PutMapping("/{varId}")
	public boolean update (@PathVariable Integer varId, @RequestBody Visita objVis) {
		if(varId == null || varId < 0)
			return false;
		
		return service.update(varId, objVis);
	}
	
	@GetMapping("/cf/{cf}")
	public List<Visita> findByCF(@PathVariable String cf){
		return service.findByCF(cf);
	}
	
	@GetMapping("/date/{data}")
	public List<Visita> findByData(@PathVariable Date data) {
		return service.findByData(data);
	}
	
	@GetMapping("/date/{start}/{stop}")
	public List<Visita> findByPeriod(@PathVariable Date start , @PathVariable Date stop) {
		return service.findByPeriod(start,stop);
	}
	
	@GetMapping("/codes/{codUni}/{codSeg}")
	public Visita findByCodes(@PathVariable String codUni, @PathVariable String codSeg) {
		return service.findByCodes(codUni,codSeg);
	}
}
