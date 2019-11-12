package com.colegio.api.dao;

import java.util.List;

import com.colegio.api.entity.Anio;

public interface AnioDAO {
	public List<Anio> findAll();
	
	public Anio findById(int id);
	
	public void save(Anio user);
	
	public void deleteById(int id);
}
