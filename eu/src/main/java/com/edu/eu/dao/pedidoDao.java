package com.edu.eu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.eu.entity.pedido;
import com.edu.eu.jpa.IpedidoJpa;

@Repository
public class pedidoDao implements IpedidoDao{

	@Autowired
	IpedidoJpa jpa;
	
	@Override
	public List<pedido> guardarpedido(pedido pedido) {
		jpa.save(pedido);
		return listacompleta();
	}

	@Override
	public pedido actualizarpedido(pedido pedido) {
		return jpa.save(pedido);
	}

	@Override
	public List<pedido> listacompleta() {
		return jpa.findAll();
	}

	@Override
	public pedido busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

}
