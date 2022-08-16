package com.spring.apirest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.apirest.model.Produto;
import com.spring.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping(value = "/produtos")
	public ResponseEntity<List<Produto>> finAll() {
		return ResponseEntity.ok(service.finAll());
	}

	@GetMapping(value = "/produto/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping(value = "/produto")
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		Produto obj = service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/produto/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/produto/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
		return ResponseEntity.ok(service.update(id, produto));
	}
}
