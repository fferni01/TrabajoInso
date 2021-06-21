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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */

@Entity
@Table(name="descuentos")

public class Descuento implements Serializable{
    
    @Id
    private String NombreDescuento;
    @Column(name="Porcentaje")
    private double Porcentaje;

    public String getNombreDescuento() {
        return NombreDescuento;
    }

    public void setNombreDescuento(String NombreDescuento) {
        this.NombreDescuento = NombreDescuento;
    }

    public double getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(double Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.NombreDescuento);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.Porcentaje) ^ (Double.doubleToLongBits(this.Porcentaje) >>> 32));
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
        final Descuento other = (Descuento) obj;
        if (Double.doubleToLongBits(this.Porcentaje) != Double.doubleToLongBits(other.Porcentaje)) {
            return false;
        }
        if (!Objects.equals(this.NombreDescuento, other.NombreDescuento)) {
            return false;
        }
        return true;
    }





    
}
