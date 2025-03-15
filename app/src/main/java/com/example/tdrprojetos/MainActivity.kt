package com.example.tdrprojetos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.provider.FontsContractCompat.Columns
import com.example.tdrprojetos.model.*
import com.example.tdrprojetos.ui.theme.TDRprojetosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            TDRprojetosTheme{
                Column {
                    // Criando produtos
                    val produto1 = Produto(1, "Notebook", 4500.0, 5)
                    val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)

                    // Criando cliente
                    val cliente = Cliente(1, "Ana", 5000.0)

                    // Criando carrinho e loja
                    val carrinho = CarrinhoDeCompras()

                    // Criando a loja com a lista de produtos
                    val loja = Loja(mutableListOf(produto1, produto2))


                    Row { Text(text = "") }
                    Row { Text(text = "") }
                    Row { Text(text = "") }
                    Row {carrinho.adicionarProduto(produto1, 1)}
                    Row {carrinho.adicionarProduto(produto2, 2)}
                    Row {carrinho.exibirCarrinho()}
                    Row { loja.finalizarCompra(cliente, carrinho)}
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TDRprojetosTheme() {
        Greeting("Android")
    }
}
