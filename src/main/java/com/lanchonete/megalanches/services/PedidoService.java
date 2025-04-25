package com.lanchonete.megalanches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Funcionario;
import com.lanchonete.megalanches.entities.Pedido;
import com.lanchonete.megalanches.entities.Produto;
import com.lanchonete.megalanches.entities.ProdutoPedido;
import com.lanchonete.megalanches.repositories.FuncionarioRepository;
import com.lanchonete.megalanches.repositories.PedidoRepository;
import com.lanchonete.megalanches.services.exceptions.DatabaseException;
import com.lanchonete.megalanches.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private FuncionarioRepository funcRepository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		Funcionario func = funcRepository.findById(obj.getFuncionario().getId()).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
		try {
			obj.setFuncionario(func);
			atualizarSaldo(func, obj);
			
			for(ProdutoPedido pp : obj.getItens()) {
				Produto produto = pp.getProduto();
				if(produto.getId() == null) {
					throw new IllegalArgumentException("O id do produto não pode ser nulo");
				}
				pp.setPedido(obj);
			}
			return repository.save(obj);
		} catch(NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
		
	}
	
	public void atualizarSaldo(Funcionario func, Pedido obj) {
		double novoSaldo = func.getSaldo() - obj.getTotal();
		func.setSaldo(novoSaldo);
		funcRepository.save(func);
		
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
