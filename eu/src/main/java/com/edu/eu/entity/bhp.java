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
@Table(name = "bodegashasproductos")
@NamedQuery(name = "bodegashasproducto.findAll", query = "SELECT s FROM bodegashasproducto s")
public class bhp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "idbodega")
	private int idbodega;
	
	@Column(name = "idproducto")
	private int idproducto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdbodega() {
		return idbodega;
	}

	public void setIdbodega(int idbodega) {
		this.idbodega = idbodega;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	
	

}
