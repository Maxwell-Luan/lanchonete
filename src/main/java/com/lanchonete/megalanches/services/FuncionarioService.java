package com.lanchonete.megalanches.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Funcionario;
import com.lanchonete.megalanches.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Funcionario insert(Funcionario obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Funcionario update(Long id, Funcionario obj) {
		Funcionario func = repository.getReferenceById(id);
		atualizarDados(func, obj);
		return repository.save(func);
	}
	
	public void atualizarDados(Funcionario func, Funcionario obj) {
		func.setNome(obj.getNome());
		func.setSaldo(obj.getSaldo());
	}
	
}
