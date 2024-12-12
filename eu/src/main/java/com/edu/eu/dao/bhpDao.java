package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.bhp;
import com.edu.eu.jpa.IbhpJpa;

@Repository
public class bhpDao implements IbhpDao{

	@Autowired
	IbhpJpa jpa;
	
	@Override
	public List<bhp> guardarbhp(bhp bhp) {
		jpa.save(bhp);
		return listacompleta();
	}

	@Override
	public bhp actualizarbhp(bhp bhp) {
		return jpa.save(bhp);
	}

	@Override
	public List<bhp> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public bhp busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

} 
