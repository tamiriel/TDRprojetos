package com.example.tdrprojetos.model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Cliente(
    val id: Int,
    val nome: String,
    var saldo: Double
) {
    @Composable
    fun adicionarSaldo(valor: Double) {
        if (valor > 0) {
            saldo += valor
            Text(text = "$nome adicionou R$ $valor à sua conta")
        } else {
            Text(text = "O valor a ser adicionado deve ser maior que 0")
        }
    }
}
