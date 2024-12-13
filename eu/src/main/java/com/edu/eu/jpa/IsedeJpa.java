package com.edu.eu.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.eu.entity.sede;

public interface ISedeJpa extends JpaRepository<sede, Integer>{

	sede findBySedeDispo(boolean estado);
	
}
