package com.edu.eu.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "cliente.findAll", query = "SELECT s FROM cliente s")
public class cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula")
	private int cedula;
	
	@Column(name = "celular")
	private int celular;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
