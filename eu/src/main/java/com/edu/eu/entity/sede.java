package com.edu.eu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sedes")
public class sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSede")
	private int id;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "estado")
	private boolean sedeDispo;

	public int getId() {
		return id;
	}

	public boolean isSedeDispo() {
		return sedeDispo;
	}

	public void setSedeDispo(boolean sedeDispo) {
		this.sedeDispo = sedeDispo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEstado() {
		return sedeDispo;
	}

	public void setEstado(boolean sedeDispo) {
		this.sedeDispo = sedeDispo;
	}
	
	
	
}
