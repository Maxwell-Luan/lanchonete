package com.lanchonete.megalanches.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Pedido;
import com.lanchonete.megalanches.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Pedido update(Long id, Pedido obj) {
		Pedido ped = repository.getReferenceById(id);
		atualizarDados(ped, obj);
		return repository.save(ped);
	}
	
	public void atualizarDados(Pedido ped, Pedido obj){
		ped.setData(obj.getData());
		ped.setStatusPedido(obj.getStatusPedido());
	}
}
