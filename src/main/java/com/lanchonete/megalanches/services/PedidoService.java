package com.lanchonete.megalanches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Pedido;
import com.lanchonete.megalanches.repositories.PedidoRepository;
import com.lanchonete.megalanches.services.exceptions.DatabaseException;
import com.lanchonete.megalanches.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Pedido insert(Pedido obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			Pedido pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			pedido.getItens().clear();
			repository.save(pedido);
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Pedido update(Long id, Pedido obj) {
		try {
			Pedido ped = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			atualizarDados(ped, obj);
			return repository.save(ped);
		} catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
	}

	public void atualizarDados(Pedido ped, Pedido obj) {
		ped.setData(obj.getData());
		ped.setStatusPedido(obj.getStatusPedido());
	}
}
