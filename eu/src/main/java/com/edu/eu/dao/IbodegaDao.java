package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.bodega;

public interface IbodegaDao {
	
	List<bodega> guardarbodega(bodega bodega);
	bodega actualizarbodega(bodega bodega);

	List<bodega> listacompleta();
	bodega busquedaPorId(int id);


}
