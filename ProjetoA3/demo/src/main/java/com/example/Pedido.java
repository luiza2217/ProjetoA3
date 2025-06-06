package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    
private int id_pedido;
private BigDecimal total_pedido;
private String status;
private LocalDate data;
private int id_usuario;

  public Pedido(int id_pedido, BigDecimal total_pedido, String status, LocalDate data, int id_usuario){

    this.id_pedido = id_pedido;
    this.total_pedido = total_pedido;
    this.status = status;
    this.data = data;
    this.id_usuario = id_usuario;

  
   

    }


public int getId_pedido() {
    return id_pedido;
}
public void setId_pedido(int id_pedido) {
    this.id_pedido = id_pedido;
}
public BigDecimal getTotal_pedido() {
    return total_pedido;
}
public void setTotal_pedido(BigDecimal total_pedido) {
    this.total_pedido = total_pedido;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public LocalDate getData() {
    return data;
}
public void setData(LocalDate data) {
    this.data = data;
}
public int getId_usuario() {
    return id_usuario;
}
public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
}


@Override
public String toString() {
    return "ID: " + id_pedido + ", Total: " + total_pedido + ", Status: " + status +
           ", Data: " + data + ", Usuário ID: " + id_usuario;
}



}

