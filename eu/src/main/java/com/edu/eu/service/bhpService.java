package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IbhpDao;
import com.edu.eu.entity.bhp;

@Service
public class bhpService implements IbhpService{

	@Autowired
	IbhpDao dao;
	
	@Override
	public List<bhp> addbhp(bhp bhp) {
		return dao.guardarbhp(bhp);
	}

	@Override
	public bhp updatebhp(bhp bhp) {
		int id_bhp = bhp.getId();
		
		if(!findIdbhp(id_bhp).equals(null)) {
			
			return dao.actualizarbhp(bhp);
			
		}
		
		return null;
	}

	@Override
	public List<bhp> listAll() {
		return dao.listacompleta();
	}

	@Override
	public bhp findIdbhp(int id) {
		return dao.busquedaPorId(id);
	}

}
