package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IempleadoDao;
import com.edu.eu.entity.empleado;

@Service
public class empleadoService implements IempleadoService{

	@Autowired
	IempleadoDao dao;
	
	@Override
	public List<empleado> addempleado(empleado empleado) {
		return dao.guardarempleado(empleado);
	}

	@Override
	public empleado updateempleado(empleado empleado) {
		int id_empleado = empleado.getCedula();
		
		if(!findIdempleado(id_empleado).equals(null)) {
			
			return dao.actualizarempleado(empleado);
			
		}
		
		return null;
	}

	@Override
	public List<empleado> listAll() {
		return dao.listacompleta();
	}

	@Override
	public empleado findIdempleado(int id) {
		return dao.busquedaPorId(id);
	}

}
