package com.produtos.apirest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repositories.ProdutoRepository;

@Configuration
public class TesteConfig implements CommandLineRunner {
	@Autowired
	ProdutoRepository repo;

	@Override
	public void run(String... args) throws Exception {

		Produto p1 = new Produto(null, "Panela", 15.50, 25);
		Produto p2 = new Produto(null, "Balde", 5.50, 15);
		Produto p3 = new Produto(null, "Frigideira", 30.00, 21);
		Produto p4 = new Produto(null, "Copo", 3.50, 12);
		
		repo.saveAll(Arrays.asList(p1,p2,p3,p4));
	}

}
