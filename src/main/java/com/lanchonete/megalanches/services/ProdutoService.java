package com.lanchonete.megalanches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Produto;
import com.lanchonete.megalanches.repositories.ProdutoRepository;
import com.lanchonete.megalanches.services.exceptions.DatabaseException;
import com.lanchonete.megalanches.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Produto insert(Produto obj) {
		try {
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Produto update(Long id, Produto obj) {
		try {
			Produto prod = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			atualizarDados(prod, obj);
			return repository.save(prod);
		} catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}

	}

	public void atualizarDados(Produto prod, Produto obj) {
		prod.setNome(obj.getNome());
		prod.setImgUrl(obj.getImgUrl());
		prod.setPreco(obj.getPreco());
	}
}
