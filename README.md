# Sistema de Loja Virtual em Kotlin

Este é um sistema de loja virtual desenvolvido em Kotlin, utilizando conceitos de Orientação a Objetos (POO). O sistema permite que os clientes comprem produtos, adicionem itens ao carrinho de compras e finalizem a compra com pagamento.

## Funcionalidades

- **Produto**: Cada produto tem um identificador único, nome, preço e quantidade em estoque.
- **Cliente**: O cliente tem um identificador, nome e saldo disponível para compras. O cliente pode adicionar saldo para continuar comprando.
- **Carrinho de Compras**: O carrinho permite adicionar e remover produtos, exibir os itens e calcular o total da compra.
- **Loja**: A loja contém uma lista de produtos disponíveis e permite que o cliente finalize a compra, atualizando o estoque.

## Classes e Métodos

### 1. **Classe Produto**
Cada produto possui os seguintes atributos e métodos:
- `id` (Int): Identificador único do produto.
- `nome` (String): Nome do produto.
- `preco` (Double): Preço do produto.
- `estoque` (Int): Quantidade disponível do produto.
  
Método:
- `exibirDetalhes()`: Exibe as informações do produto (id, nome, preço, estoque).

### 2. **Classe Cliente**
Cada cliente possui os seguintes atributos e métodos:
- `id` (Int): Identificador único do cliente.
- `nome` (String): Nome do cliente.
- `saldo` (Double): Saldo disponível para compras.
  
Método:
- `adicionarSaldo(valor: Double)`: Permite recarregar o saldo do cliente.

### 3. **Classe CarrinhoDeCompras**
O carrinho possui os seguintes atributos e métodos:
- Contém uma lista de produtos adicionados pelo cliente.
  
Métodos:
- `adicionarProduto(produto: Produto, quantidade: Int)`: Adiciona um produto ao carrinho com a quantidade especificada.
- `removerProduto(produto: Produto)`: Remove um produto do carrinho.
- `exibirCarrinho()`: Exibe os itens presentes no carrinho.
- `calcularTotal()`: Calcula o total da compra no carrinho.

### 4. **Classe Loja**
A loja contém os seguintes atributos e métodos:
- Uma lista de produtos disponíveis para venda.
  
Métodos:
- `listarProdutos()`: Exibe os produtos disponíveis na loja.
- `finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras)`: Finaliza a compra do cliente, atualizando o estoque e verificando se o cliente tem saldo suficiente.

## Regras de Negócio

- O cliente só pode comprar se tiver saldo suficiente.
- Se um produto não estiver no estoque, não pode ser comprado.
- Ao finalizar a compra, o estoque dos produtos será atualizado de acordo com a quantidade comprada.
