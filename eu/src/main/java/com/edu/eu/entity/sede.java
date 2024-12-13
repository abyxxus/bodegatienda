package com.edu.eu.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@Entity
@Table(name = "sedes")
@NamedQuery(name = "sede.findAll", query = "SELECT s FROM sede s")
public class sede implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sede")
	private int id_sede;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "estado")
	private boolean estado;

	
	public int getIdSede() {
		return id_sede;
	}

	public void setIdSede(int idSede) {
		this.id_sede = idSede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
