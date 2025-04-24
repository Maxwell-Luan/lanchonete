package com.lanchonete.megalanches.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Produto;
import com.lanchonete.megalanches.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
	
	public Produto insert(Produto obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Produto update(Long id, Produto obj) {
		Produto prod = repository.getReferenceById(id);
		atualizarDados(prod, obj);
		return repository.save(prod);
	}
	
	public void atualizarDados(Produto prod, Produto obj) {
		prod.setDescricao(obj.getDescricao());
		prod.setImgUrl(obj.getImgUrl());
		prod.setPreco(obj.getPreco());
	}
}
