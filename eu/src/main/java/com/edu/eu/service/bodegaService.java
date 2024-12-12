package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IbodegaDao;
import com.edu.eu.entity.bodega;

@Service
public class bodegaService implements IbodegaService{
	
	@Autowired
	IbodegaDao dao;

	@Override
	public List<bodega> addbodega(bodega bodega) {
		return dao.guardarbodega(bodega);
	}

	@Override
	public bodega updatebodega(bodega bodega) {
		int id_bodega = bodega.getIdbodega();
		
		if(!findIdbodega(id_bodega).equals(null)) {
			
			return dao.actualizarbodega(bodega);
			
		}
		
		return null;
	}

	@Override
	public List<bodega> listAll() {
		return dao.listacompleta();
	}

	@Override
	public bodega findIdbodega(int id) {
		return dao.busquedaPorId(id);
	}

}
