package com.spring.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.apirest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
