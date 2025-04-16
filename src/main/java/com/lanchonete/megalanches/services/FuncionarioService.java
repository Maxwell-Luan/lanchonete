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
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = funcionarioRepository.findById(id);
		return obj.get();
	}
}
