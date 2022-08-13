package com.spring.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.apirest.model.Produto;
import com.spring.apirest.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<Produto> finAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}

	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Produto update(Long id, Produto produto) {
		produto.setId(id);
		return repository.save(produto);
	}
}
