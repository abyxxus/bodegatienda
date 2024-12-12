package com.edu.eu.dao;

import java.util.List;

import com.edu.eu.entity.pedido;

public interface IpedidoDao {

	List<pedido> guardarpedido(pedido pedido);
	pedido actualizarpedido(pedido pedido);

	List<pedido> listacompleta();
	pedido busquedaPorId(int id);
	
}
