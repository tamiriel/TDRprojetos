package com.example.tdrprojetos.model

import androidx.collection.mutableLongListOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CarrinhoDeCompras {
    val produtosLista = mutableLongListOf()
    val itens = mutableMapOf<Produto, Int>()

    @Composable
    fun adicionarProduto(produto: Produto, quantidade: Int) {
        if (produto.estoque >= quantidade) {
            itens[produto] = itens.getOrDefault(produto, 0) + quantidade
            produto.estoque -= quantidade
            Text(text = "${quantidade}x ${produto.nome} adicionado ao carrinho.")
        } else {
            Text(text = "Estoque insuficiente para ${produto.nome}")
        }
    }

    @Composable
    fun removerProduto(produto: Produto) {
        if (itens.containsKey(produto)) {
            itens.remove(produto)
            Text(text = "${produto.nome} removido do carrinho")
        } else {
            Text(text = "${produto.nome} não está no carrinho")
        }
    }

    @Composable
    fun exibirCarrinho() {
        if (itens.isEmpty()) {
            Text(text = "O carrinho está vazio")
        } else {
            Column {
                Row { Text(text = "Itens no carrinho:") }
                itens.forEach { (produto, quantidade) ->
                    Row{ Text(text = "$quantidade x ${produto.nome} - R$${produto.preco * quantidade}")}
                }
            }


        }
    }

    fun calcularTotal(): Double {
        return itens.entries.sumOf { (produto, quantidade) -> produto.preco * quantidade }
    }
}