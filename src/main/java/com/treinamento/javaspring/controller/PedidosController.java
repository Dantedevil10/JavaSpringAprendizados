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

import com.treinamento.javaspring.models.Pedidos;
import com.treinamento.javaspring.service.PedidosService;

@RestController
@RequestMapping("/pedido")
public class PedidosController {

    @Autowired
	private PedidosService service;

	@PostMapping("/save")
	public ResponseEntity<Pedidos> salvaPedido(@RequestBody Pedidos pedido) {

		pedido = service.save(pedido);

		return ResponseEntity.ok().body(pedido);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedidos> buscaPedido(@PathVariable Long id) {

		Pedidos pedido = service.findById(id);

		return ResponseEntity.ok().body(pedido);

	}

	@GetMapping("/busca-todos")
	public ResponseEntity<List<Pedidos>> buscaTodosPedidos() {

		List<Pedidos> pedidos = service.findAll();

		return ResponseEntity.ok().body(pedidos);

	}

}
