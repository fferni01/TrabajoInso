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
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="valoraciones")
        
public class Valoracion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdValoracion;
    
    @Column(name="Valoracion")
    private int Valoracion;

    public int getIdValoracion() {
        return IdValoracion;
    }

    public void setIdValoracion(int IdValoracion) {
        this.IdValoracion = IdValoracion;
    }

    public int getValoracion() {
        return Valoracion;
    }

    public void setValoracion(int Valoracion) {
        this.Valoracion = Valoracion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.IdValoracion;
        hash = 23 * hash + this.Valoracion;
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
        final Valoracion other = (Valoracion) obj;
        if (this.IdValoracion != other.IdValoracion) {
            return false;
        }
        if (this.Valoracion != other.Valoracion) {
            return false;
        }
        return true;
    }

  
    
}
