package com.example;

public class Item_Pedido {
    
private int id_item_pedido;
private int id_produto;
private int id_pedido;
private int quantidade;


public Item_Pedido(int id_item_pedido, int id_produto, int id_pedido, int quantidade){

 this.id_item_pedido = id_item_pedido;
 this.id_produto = id_produto; 
 this.id_pedido = id_pedido;
 this.quantidade = quantidade;

}

public int getId_item_pedido() {
    return id_item_pedido;
}

public void setId_item_pedido(int id_item_pedido) {
    this.id_item_pedido = id_item_pedido;
}

public int getId_produto() {
    return id_produto;
}
public void setId_produto(int id_produto) {
    this.id_produto = id_produto;
}
public int getId_pedido() {
    return id_pedido;
}
public void setId_Pedido(int id_pedido) {
    this.id_pedido = id_pedido;
}
public int getQuantidade() {
    return quantidade;
}
public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
}


@Override
public String toString() {
    return "ID: " + id_item_pedido + ", Produto ID: " + id_produto + ", Pedido ID: " + id_pedido +
           ", Quantidade: " + quantidade;
}



}
