package com.treinamento.javaspring.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Pedidos {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String endereco;

	private LocalDateTime dataPedido;

	private String status;

	@ManyToMany
	@Fetch(FetchMode.SELECT)
	private Set<Produtos> produtos;
}
