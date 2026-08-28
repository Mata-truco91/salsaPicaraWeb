package com.salsapicara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salsapicara.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}