package com.colegio.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tb_anio")

public class Anio {
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name="nom_anio")
    private String nom_anio;
    
    @Column(name="est_anio")
    private String est_anio;
    
    public Anio(){

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_anio() {
		return nom_anio;
	}

	public void setNom_anio(String nom_anio) {
		this.nom_anio = nom_anio;
	}
    
}
	