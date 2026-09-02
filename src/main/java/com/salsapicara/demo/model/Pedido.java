package com.salsapicara.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;
    private String telefono;
    private int cantidad;
    private double total;
private String codigoPostal;
 private int cantidadPaquetes;


    public Pedido(String nombre, String telefono, int cantidad,String codigoPostal, double total, int cantidadPaquetes) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cantidad = cantidad;
        this.codigoPostal = codigoPostal;
        this.total = total;
        this.cantidadPaquetes = cantidadPaquetes; 

    }

    public long getId() {
        return id;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public String getcodigoPostal() {
        return codigoPostal;
    }

    public void setcodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCantidadPaquetes() {
        return cantidadPaquetes;
    }

    public void setCantidadPaquetes(int cantidadPaquetes) {
        this.cantidadPaquetes = cantidadPaquetes;
    }




}
