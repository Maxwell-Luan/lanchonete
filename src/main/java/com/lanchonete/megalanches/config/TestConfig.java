package com.lanchonete.megalanches.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lanchonete.megalanches.entities.Funcionario;
import com.lanchonete.megalanches.repositories.FuncionarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Funcionario func1 = new Funcionario(null, "Chefão Emerson", 20.00);
		Funcionario func2 = new Funcionario(null, "Luan Teste", -2.00);
		Funcionario func3 = new Funcionario(null, "Felipe", 15.50);
		Funcionario func4 = new Funcionario(null, "Magnus", 32.40);
		Funcionario func5 = new Funcionario(null, "Adriana", 0.00);
		Funcionario func6 = new Funcionario(null, "Adriana Rodrigues", 0.00);
		Funcionario func7 = new Funcionario(null, "Andréia", 0.00);
		Funcionario func8 = new Funcionario(null, "Débora", 0.00);
		Funcionario func9 = new Funcionario(null, "Erzita", 0.00);
		Funcionario func10 = new Funcionario(null, "Eduardo", 0.00);
		Funcionario func11 = new Funcionario(null, "Eliza", 0.00);
		Funcionario func12 = new Funcionario(null, "Euzi", 0.00);
		Funcionario func13 = new Funcionario(null, "Élia", 0.00);
		Funcionario func14 = new Funcionario(null, "Elisangela", 0.00);
		Funcionario func15 = new Funcionario(null, "Franciele", 0.00);
		Funcionario func16 = new Funcionario(null, "Gabriel", 0.00);
		Funcionario func17 = new Funcionario(null, "Graça", 0.00);
		Funcionario func18 = new Funcionario(null, "Gustavo", 0.00);
		Funcionario func19 = new Funcionario(null, "Jaqueline", 0.00);
		Funcionario func20 = new Funcionario(null, "Laura", 0.00);
		Funcionario func21 = new Funcionario(null, "Larissa", 0.00);
		Funcionario func22 = new Funcionario(null, "Luciele", 0.00);
		Funcionario func23 = new Funcionario(null, "Luciana", 0.00);
		Funcionario func24 = new Funcionario(null, "Mariane", 0.00);
		Funcionario func25 = new Funcionario(null, "Mary", 0.00);
		Funcionario func26 = new Funcionario(null, "Micaele", 0.00);
		Funcionario func27 = new Funcionario(null, "Michele", 0.00);
		Funcionario func28 = new Funcionario(null, "Rafa", 0.00);
		Funcionario func29 = new Funcionario(null, "Raquel", 0.00);
		Funcionario func30 = new Funcionario(null, "Renata", 0.00);
		Funcionario func31 = new Funcionario(null, "Roberta", 0.00);
		Funcionario func32 = new Funcionario(null, "Roni", 0.00);
		Funcionario func33 = new Funcionario(null, "Sandro", 0.00);
		Funcionario func34 = new Funcionario(null, "Taís", 0.00);
		Funcionario func35 = new Funcionario(null, "Valéria", 0.00);

		funcionarioRepository.saveAll(
				Arrays.asList(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12,
						func13, func14, func15, func16, func17, func18, func19, func20, func21, func22, func23, func24,
						func25, func26, func27, func28, func29, func30, func31, func32, func33, func34, func35));
	}

}
