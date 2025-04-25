package com.lanchonete.megalanches.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lanchonete.megalanches.entities.Funcionario;
import com.lanchonete.megalanches.entities.Pedido;
import com.lanchonete.megalanches.entities.Produto;
import com.lanchonete.megalanches.entities.ProdutoPedido;
import com.lanchonete.megalanches.entities.enums.StatusPedido;
import com.lanchonete.megalanches.repositories.FuncionarioRepository;
import com.lanchonete.megalanches.repositories.PedidoRepository;
import com.lanchonete.megalanches.repositories.ProdutoPedidoRepository;
import com.lanchonete.megalanches.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoPedidoRepository produtoPedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Funcionario func1 = new Funcionario(null, "Chefão Emerson", 50.00);
		Funcionario func2 = new Funcionario(null, "Luan Teste", 50.00);
		Funcionario func3 = new Funcionario(null, "Felipe", 50.00);
		Funcionario func4 = new Funcionario(null, "Magnus", 50.00);
		Funcionario func5 = new Funcionario(null, "Adriana", 50.00);
		Funcionario func6 = new Funcionario(null, "Adriana Rodrigues", 50.00);
		Funcionario func7 = new Funcionario(null, "Andréia", 50.00);
		Funcionario func8 = new Funcionario(null, "Débora", 50.00);
		Funcionario func9 = new Funcionario(null, "Erzita", 50.00);
		Funcionario func10 = new Funcionario(null, "Eduardo", 50.00);
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
		
		Produto prod1 = new Produto(null, "Coxinha", 5.50, "www.imagem/coxinha.com");
		Produto prod2 = new Produto(null, "Pastel Assado", 5.00, "www.imagem/pastel_assado.com");
		Produto prod3 = new Produto(null, "Quibe", 3.50, "www.imagem/quibe.com");
		Produto prod4 = new Produto(null, "Empada", 4.50, "www.imagem/empada.com");
		Produto prod5 = new Produto(null, "Enrolado de Salsicha", 4.00, "www.imagem/enrolado_de_salsicha.com");
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		Pedido ped1 = new Pedido(null, StatusPedido.PAGO, Instant.parse("2025-04-01T12:54:07Z"), func20);
		Pedido ped2 = new Pedido(null, StatusPedido.PENDENTE, Instant.parse("2025-04-15T18:37:09Z"), func4);
		Pedido ped3 = new Pedido(null, StatusPedido.CANCELADO, Instant.parse("2025-04-05T10:21:04Z"), func7);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		
		ProdutoPedido pp1 = new ProdutoPedido(ped1, prod2, 1, prod2.getPreco());
		ProdutoPedido pp2 = new ProdutoPedido(ped1, prod1, 1, prod1.getPreco());
		ProdutoPedido pp3 = new ProdutoPedido(ped2, prod3, 4, prod3.getPreco());
		ProdutoPedido pp4 = new ProdutoPedido(ped3, prod1, 2, prod1.getPreco());
		ProdutoPedido pp5 = new ProdutoPedido(ped3, prod4, 5, prod4.getPreco());
		ProdutoPedido pp6 = new ProdutoPedido(ped3, prod5, 3, prod5.getPreco());
		
		produtoPedidoRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4, pp5, pp6));
	}

}
