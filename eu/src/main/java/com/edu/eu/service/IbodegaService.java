package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.bodega;

public interface IbodegaService {

	List<bodega> addbodega(bodega bodega);
	bodega updatebodega(bodega bodega);
	
	List<bodega> listAll();
	bodega findIdbodega(int id);
	
}
