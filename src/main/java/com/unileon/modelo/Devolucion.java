/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="devolucion")
public class Devolucion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdDevolucion;
    
    @Column(name="Estado")
    private String Estado;
    
    @Column(name="Cantidad")
    private int Cantidad;
    
    @JoinColumn(name="IdPersona")
    @ManyToOne
    private Persona Persona;
    
    @JoinColumn(name="IdProducto")
    @ManyToOne
    private Producto Producto;

    public int getIdDevolucion() {
        return IdDevolucion;
    }

    public void setIdDevolucion(int IdDevolucion) {
        this.IdDevolucion = IdDevolucion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.IdDevolucion;
        hash = 47 * hash + Objects.hashCode(this.Estado);
        hash = 47 * hash + this.Cantidad;
        hash = 47 * hash + Objects.hashCode(this.Persona);
        hash = 47 * hash + Objects.hashCode(this.Producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Devolucion other = (Devolucion) obj;
        if (this.IdDevolucion != other.IdDevolucion) {
            return false;
        }
        if (this.Cantidad != other.Cantidad) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.Persona, other.Persona)) {
            return false;
        }
        if (!Objects.equals(this.Producto, other.Producto)) {
            return false;
        }
        return true;
    }
    
    

    
    
}
