package com.colegio.api.service;

import java.util.List;

import com.colegio.api.entity.Anio;

public interface AnioService {
	
	public List<Anio> findAll();

	public Anio findById(int id);
	
	public void save(Anio anio);
	
	public void deleteById(int id);
}