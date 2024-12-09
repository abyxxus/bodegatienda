package com.edu.bodegatienda.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.bodegatienda.entity.empleados;

public interface IempleadosJpa extends JpaRepository<empleados, Integer> {

	empleados findByEmpName(String empName);
	
}
