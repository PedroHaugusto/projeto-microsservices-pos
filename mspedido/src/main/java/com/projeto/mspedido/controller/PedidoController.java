package com.projeto.mspedido.controller;

import com.projeto.mspedido.model.Pedido;
import com.projeto.mspedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(com.projeto.mspedido.model.StatusPedido.CRIADO);
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
