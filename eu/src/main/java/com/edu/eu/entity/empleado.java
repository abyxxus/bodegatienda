package com.edu.eu.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
@NamedQuery(name = "empleado.findAll", query = "SELECT e FROM empleado e")
public class empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula")
	private int cedula;
	
	@Column(name = "idsede")
	private int idsede;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "rol")
	private String rol;

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
}
