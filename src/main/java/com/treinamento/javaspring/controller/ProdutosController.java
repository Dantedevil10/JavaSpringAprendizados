package com.treinamento.javaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.treinamento.javaspring.models.Produtos;
import com.treinamento.javaspring.service.ProdutosService;

@RestController
@RequestMapping("/produto")
public class ProdutosController {
	
	@Autowired
	private ProdutosService service;
	
	@PostMapping("/save")
	public ResponseEntity<Produtos> criarProduto(@RequestBody Produtos produto){
		return ResponseEntity.ok(service.save(produto));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Produtos>> pegarTodos(){
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> pegarId(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
}
