package com.edu.eu.service;

import java.util.List;

import com.edu.eu.entity.pedido;

public interface IpedidoService {

	List<pedido> addpedido(pedido pedido);
	pedido updatepedido(pedido pedido);
	
	List<pedido> listAll();
	pedido findIdpedido(int id);
	
}
