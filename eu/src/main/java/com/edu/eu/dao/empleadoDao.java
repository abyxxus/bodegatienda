package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.empleado;
import com.edu.eu.jpa.IempleadoJpa;


@Repository
public class empleadoDao implements IempleadoDao{

	@Autowired
	IempleadoJpa jpa;
	
	@Override
	public List<empleado> guardarempleado(empleado empleado) {
		jpa.save(empleado);
		return listacompleta();
	}

	@Override
	public empleado actualizarempleado(empleado empleado) {
		return jpa.save(empleado);
	}

	@Override
	public List<empleado> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public empleado busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

}
