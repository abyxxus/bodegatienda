package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.bhp;

public interface IbhpDao {
	
	List<bhp> guardarbhp(bhp bhp);
	bhp actualizarbhp(bhp bhp);

	List<bhp> listacompleta();
	bhp busquedaPorId(int id);

}
