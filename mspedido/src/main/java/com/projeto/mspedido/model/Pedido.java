package com.projeto.mspedido.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;

    @ElementCollection
    private List<Long> idProdutos;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public List<Long> getIdProdutos() { return idProdutos; }
    public void setIdProdutos(List<Long> idProdutos) { this.idProdutos = idProdutos; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }
}
