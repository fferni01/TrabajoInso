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
@Table(name="copiacarrito")

public class CopiaCarrito implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int IdCopCarrito;
    @JoinColumn(name="IdPersona")
    @ManyToOne
    private Persona Persona;
    @JoinColumn(name="IdProducto")
    @ManyToOne
    private Producto Producto;
    @JoinColumn(name="IdVenta")
    @ManyToOne
    private Venta Venta;
    @Column(name="Cantidad")
    private int Cantidad;


    public int getIdCopCarrito() {
        return IdCopCarrito;
    }

    public void setIdCopCarrito(int IdCopCarrito) {
        this.IdCopCarrito = IdCopCarrito;
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

    public Venta getVenta() {
        return Venta;
    }

    public void setVenta(Venta Venta) {
        this.Venta = Venta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.IdCopCarrito;
        hash = 17 * hash + Objects.hashCode(this.Persona);
        hash = 17 * hash + Objects.hashCode(this.Producto);
        hash = 17 * hash + Objects.hashCode(this.Venta);
        hash = 17 * hash + this.Cantidad;
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
        final CopiaCarrito other = (CopiaCarrito) obj;
        if (this.IdCopCarrito != other.IdCopCarrito) {
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
        if (!Objects.equals(this.Venta, other.Venta)) {
            return false;
        }
        return true;
    }



}
