package com.colegio.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.api.dao.AnioDAO;
import com.colegio.api.entity.Anio;

@Service
public class AnioServiceImpl implements AnioService {

	@Autowired
	private AnioDAO anioDAO;
	
	@Override
	public List<Anio> findAll() {
		List<Anio> listUsers= anioDAO.findAll();
		return listUsers;
	}

	@Override
	public Anio findById(int id) {
		Anio anio = anioDAO.findById(id);
		return anio;
	}

	@Override
	public void save(Anio anio) {
		anioDAO.save(anio);

	}

	@Override
	public void deleteById(int id) {
		anioDAO.deleteById(id);
	}

}