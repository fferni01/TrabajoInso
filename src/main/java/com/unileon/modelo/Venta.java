/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="venta")

public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdVenta;
    
    @Column(name="Fecha")
    @Temporal(TemporalType.DATE)
    private Date Fecha;
    
    @Column(name="Estado")
    private String Estado;
        
    @Column(name="Total")
    private double Total;
    
    @JoinColumn(name="NombreDescuento")
    @ManyToOne
    private Descuento Descuento;
        
    @JoinColumn(name="IdPersona")
    @ManyToOne
    private Persona Persona;


    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getEstadoCompleto(){
        switch(Estado){
            case "P":
                return "Pendiente";
            case "F":
                return "Entregado";
        }
        return null;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public Descuento getDescuento() {
        return Descuento;
    }

    public void setDescuento(Descuento Descuento) {
        this.Descuento = Descuento;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.IdVenta;
        hash = 47 * hash + Objects.hashCode(this.Fecha);
        hash = 47 * hash + Objects.hashCode(this.Estado);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.Total) ^ (Double.doubleToLongBits(this.Total) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.Descuento);
        hash = 47 * hash + Objects.hashCode(this.Persona);
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
        final Venta other = (Venta) obj;
        if (this.IdVenta != other.IdVenta) {
            return false;
        }
        if (Double.doubleToLongBits(this.Total) != Double.doubleToLongBits(other.Total)) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        if (!Objects.equals(this.Descuento, other.Descuento)) {
            return false;
        }
        if (!Objects.equals(this.Persona, other.Persona)) {
            return false;
        }
        return true;
    }



    
    
    
}
