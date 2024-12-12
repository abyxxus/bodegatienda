package com.edu.eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eu.dao.IpedidoDao;
import com.edu.eu.entity.pedido;

@Service
public class pedidoService implements IpedidoService{

	@Autowired
	IpedidoDao dao;
	
	@Override
	public List<pedido> addpedido(pedido pedido) {
		return dao.guardarpedido(pedido);
	}

	@Override
	public pedido updatepedido(pedido pedido) {
		int id_pedido = pedido.getIdpedido();
		
		if(!findIdpedido(id_pedido).equals(null)) {
			
			return dao.actualizarpedido(pedido);
			
		}
		
		return null;
	}

	@Override
	public List<pedido> listAll() {
		return dao.listacompleta();
	}

	@Override
	public pedido findIdpedido(int id) {
		return dao.busquedaPorId(id);
	}

}
