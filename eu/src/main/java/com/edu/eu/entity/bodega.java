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
@Table(name = "bodegas")
@NamedQuery(name = "bodega.findAll", query = "SELECT s FROM bodega s")
public class bodega implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbodega")
	private int idbodega;
	
	@Column(name = "idsede")
	private int idsede;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name = "direccion")
	private String direccion;

	public int getIdbodega() {
		return idbodega;
	}

	public void setIdbodega(int idbodega) {
		this.idbodega = idbodega;
	}

	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
