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
@Table(name = "productos")
@NamedQuery(name = "producto.findAll", query = "SELECT p FROM producto p")
public class producto  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private int idproducto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "preciounitario")
	private float preciounitario;

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(float preciounitario) {
		this.preciounitario = preciounitario;
	}
	
	

}
