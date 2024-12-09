package com.edu.bodegatienda.dao;

import java.util.List;

import com.edu.bodegatienda.entity.empleados;

public interface IempleadosDao {
	
	//declaracion de metodos
	List<empleados> guardarEmpleado(empleados empleado);
	empleados actualizarempleado(empleados empleado);
	
	//consultas
	List<empleados> listacompleta();
	empleados busquedaPorId(int id);
	empleados busquedaPorNombre(String nombre);

}
