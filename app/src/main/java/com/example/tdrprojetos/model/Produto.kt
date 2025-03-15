package com.example.tdrprojetos.model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Produto(
    val id: Int,
    val nome: String,
    var preco: Double,
    var estoque: Int
) {
    @Composable
    fun exibirDetalhes() {
        Text(text = "ID: $id | Nome: $nome | Preço: R$ $preco | Estoque: $estoque")
    }
}
