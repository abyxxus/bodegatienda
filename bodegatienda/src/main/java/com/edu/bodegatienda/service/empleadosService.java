package com.edu.bodegatienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bodegatienda.dao.IempleadosDao;
import com.edu.bodegatienda.entity.empleados;

@Service
public class empleadosService implements IempleadosService {

	@Autowired
	IempleadosDao dao;
	
	@Override
	public List<empleados> addEmpleado(empleados empleado) {
		// TODO Auto-generated method stub
		return dao.guardarEmpleado(empleado);
	}

	@Override
	public empleados upEmpleado(empleados empleado) {
		// TODO Auto-generated method stub
		int cedula = empleado.getCedula();
		
		if(!findIdEmpleado(cedula).equals(null)) {
			return dao.actualizarempleado(empleado);
		}
		
		return null;
	}

	@Override
	public List<empleados> listAll() {
		// TODO Auto-generated method stub
		return dao.listacompleta();
	}

	@Override
	public empleados findIdEmpleado(int id) {
		// TODO Auto-generated method stub
		return dao.busquedaPorId(id);
	}

	@Override
	public empleados findNombreEmpleado(String nombre) {
		// TODO Auto-generated method stub
		return dao.busquedaPorNombre(nombre);
	}

}
