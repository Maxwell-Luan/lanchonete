package com.lanchonete.megalanches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lanchonete.megalanches.entities.Funcionario;
import com.lanchonete.megalanches.repositories.FuncionarioRepository;
import com.lanchonete.megalanches.services.exceptions.DatabaseException;
import com.lanchonete.megalanches.services.exceptions.ResourceNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Funcionario insert(Funcionario obj) {
		return repository.save(obj);
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
	
	public Funcionario update(Long id, Funcionario obj) {
		try {
			Funcionario func = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			atualizarDados(func, obj);
			return repository.save(func);
		} catch(NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
	
	}
	
	public void atualizarDados(Funcionario func, Funcionario obj) {
		func.setNome(obj.getNome());
		func.setSaldo(obj.getSaldo());
	}
	
}
