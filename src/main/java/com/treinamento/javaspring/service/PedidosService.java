package com.treinamento.javaspring.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.javaspring.models.Pedidos;
import com.treinamento.javaspring.models.Produtos;
import com.treinamento.javaspring.repository.PedidosRepository;
import com.treinamento.javaspring.repository.ProdutosRepository;

@Service
public class PedidosService {

    @Autowired
	private PedidosRepository repository;

	@Autowired
	private ProdutosRepository produtoRepository;

	public Pedidos save(Pedidos pedido) {
		Set<Produtos> produtos = new HashSet<>();

		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus("Seu Pedido Está Sendo Preparado");

		// Garantir que os produtos existem
		pedido.getProdutos().forEach(produto -> {
			Produtos produtoEncontrado = produtoRepository.findById(produto.getId())
				.orElseThrow(() -> new RuntimeException("Produto não encontrado: " + produto.getId()));
			produtos.add(produtoEncontrado);
		});

		pedido.setProdutos(produtos);

		return repository.save(pedido);
	}

	public Pedidos findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Pedidos> findAll() {
		return repository.findAll();
	}

}
