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
    
    @JoinColumn(name="IdVenta")
    @ManyToOne
    private Venta Venta;

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

    public Venta getVenta() {
        return Venta;
    }

    public void setVenta(Venta Venta) {
        this.Venta = Venta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.IdDevolucion;
        hash = 61 * hash + Objects.hashCode(this.Estado);
        hash = 61 * hash + Objects.hashCode(this.Venta);
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
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.Venta, other.Venta)) {
            return false;
        }
        return true;
    }
    
    
}
