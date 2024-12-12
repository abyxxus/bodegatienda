package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.empleado;

public interface IempleadoDao {

	List<empleado> guardarempleado(empleado empleado);
	empleado actualizarempleado(empleado empleado);

	List<empleado> listacompleta();
	empleado busquedaPorId(int id);
	
}
