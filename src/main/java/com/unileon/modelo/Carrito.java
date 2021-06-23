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
@Table(name="carrito")

public class Carrito implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int IdCarrito;
    @JoinColumn(name="IdPersona")
    @ManyToOne
    private Persona Persona;
    @JoinColumn(name="IdProducto")
    @ManyToOne
    private Producto Producto;
    @Column(name="Cantidad")
    private int Cantidad;


    public int getIdCarrito() {
        return IdCarrito;
    }

    public void setIdCarrito(int IdCarrito) {
        this.IdCarrito = IdCarrito;
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


    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.IdCarrito;
        hash = 67 * hash + Objects.hashCode(this.Persona);
        hash = 67 * hash + Objects.hashCode(this.Producto);
        hash = 67 * hash + this.Cantidad;
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
        final Carrito other = (Carrito) obj;
        if (this.IdCarrito != other.IdCarrito) {
            return false;
        }
        if (this.Cantidad != other.Cantidad) {
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
