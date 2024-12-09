package com.edu.bodegatienda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.bodegatienda.entity.empleados;
import com.edu.bodegatienda.jpa.IempleadosJpa;

@Repository
public class empleadosDao implements IempleadosDao{

	@Autowired
	IempleadosJpa jpa;
	
	@Override
	public List<empleados> guardarEmpleado(empleados empleado) {
		// TODO Auto-generated method stub
		jpa.save(empleado);
		return listacompleta();
	}

	@Override
	public empleados actualizarempleado(empleados empleado) {
		// TODO Auto-generated method stub
		return jpa.save(empleado);
	}

	@Override
	public List<empleados> listacompleta() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public empleados busquedaPorId(int id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).orElse(null);
	}

	@Override
	public empleados busquedaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return jpa.findByEmpName(nombre);
	}

}
