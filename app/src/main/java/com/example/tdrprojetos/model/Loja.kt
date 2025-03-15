package com.example.tdrprojetos.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Loja (
    private val produtosDisponiveis: MutableList<Produto> = mutableListOf()
    ){

    fun adicionarProduto(produto: Produto) {
        produtosDisponiveis.add(produto)
    }

    @Composable
    fun listarProdutos() {
        Text(text = "Produtos disponíveis na loja:")
        produtosDisponiveis.forEach {
            it.exibirDetalhes()
        }
    }

    @Composable
    fun finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras) {
        carrinho.itens.forEach { (produto, quantidade) ->
            if (produto.estoque < quantidade) {
                Column {
                    Row {
                        Text(text = "Estoque insuficiente para o produto ${produto.nome}")
                    }
                }
                return
            }
        }

        val totalCompra = carrinho.calcularTotal()
        if (totalCompra > cliente.saldo) {
            Text(text = "Saldo insuficiente")
            return
        }

        cliente.saldo -= totalCompra
        carrinho.itens.forEach { (produto, quantidade) ->
            produto.estoque -= quantidade
        }
        Text(text = "Compra realizada com sucesso! Saldo restante: R$${cliente.saldo}")
    }

}