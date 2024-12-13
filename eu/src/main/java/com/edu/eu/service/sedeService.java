package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.ISedeDao;
import com.edu.eu.entity.sede;

@Service
public class sedeService implements ISedeService{

	@Autowired
	ISedeDao dao;
	
	@Override
	public List<sede> addSede(sede sede) {
		return dao.guardarsede(sede);
	}

	@Override
	public sede upsede(sede sede) {
		
		int id = sede.getId();
		
		if (!findIdSede(id).equals(null)) {
			return dao.actualizarsede(sede);
		}
		
		return null;
	}

	@Override
	public List<sede> lisAll() {
		return dao.listacompleta();
	}

	@Override
	public sede findIdSede(int id) {
		return dao.busquedaPorId(id);
	}

	@Override
	public sede findEstadoSede(boolean estado) {
		return dao.busquedaPorDisponibilidad(estado);
	}

}
