package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.bhp;

public interface IbhpService {

	List<bhp> addbhp(bhp bhp);
	bhp updatebhp(bhp bhp);
	
	List<bhp> listAll();
	bhp findIdbhp(int id);
	
}
