package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.sede;

public interface IsedeService {
	
	List<sede> addsede(sede sede);
	sede updatesede(sede sede);
	
	List<sede> listAll();
	sede findIdsede(int id);
	
}
