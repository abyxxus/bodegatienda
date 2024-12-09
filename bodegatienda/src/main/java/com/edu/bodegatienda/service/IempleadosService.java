package com.edu.bodegatienda.service;

import java.util.List;

import com.edu.bodegatienda.entity.empleados;

public interface IempleadosService {

	//declaracion de metodos
	List<empleados> addEmpleado(empleados empleado);
	empleados upEmpleado(empleados empleado);
	
	//consultas
	List<empleados> listAll();
	empleados findIdEmpleado(int id);
	empleados findNombreEmpleado(String nombre);
	
}
