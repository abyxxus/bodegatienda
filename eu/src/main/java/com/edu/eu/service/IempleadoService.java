package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.empleado;

public interface IempleadoService {

	List<empleado> addempleado(empleado empleado);
	empleado updateempleado(empleado empleado);
	
	List<empleado> listAll();
	empleado findIdempleado(int id);
	
}
