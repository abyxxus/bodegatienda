package com.edu.bodegatienda.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM empleados e")
public class empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula")
	private int cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "rol")
	private String rol;
	
	@Column(name = "idsede")
	private int idsede;

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
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

	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Cedula [cedula =");
		builder.append(cedula);
		builder.append("Nombre [nombre =");
		builder.append(nombre);
		builder.append("Rol [rol =");
		builder.append(rol);
		builder.append("IdSede [idsede =");
		builder.append(idsede);
		return builder.toString();
		
		
	}


	
}
