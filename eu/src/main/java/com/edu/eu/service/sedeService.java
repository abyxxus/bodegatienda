package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IsedeDao;
import com.edu.eu.entity.sede;

@Service
public class sedeService implements IsedeService{

	@Autowired
	IsedeDao dao;
	
	@Override
	public List<sede> addsede(sede sede) {
		return dao.guardarsede(sede);
	}

	@Override
	public sede updatesede(sede sede) {
		
		int id_Sede = sede.getIdSede();
		
		if(!findIdsede(id_Sede).equals(null)) {
			
			return dao.actualizarsede(sede);
			
		}
		
		return null;
	}

	@Override
	public List<sede> listAll() {
		return dao.listacompleta();
	}

	@Override
	public sede findIdsede(int id_sede) {
		return dao.busquedaPorId(id_sede);
	}

}
