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
@Table(name="valoraciones")
        
public class Valoracion implements Serializable{
    //IdProducto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdValoracion;
    
    @Column(name="Valoracion")
    private int Valoracion;

    @JoinColumn(name="IdProducto")
    @ManyToOne
    private Producto Producto;
    
    @JoinColumn(name="IdPersona")
    @ManyToOne
    private Persona Persona;
    
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

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.IdValoracion;
        hash = 31 * hash + this.Valoracion;
        hash = 31 * hash + Objects.hashCode(this.Producto);
        hash = 31 * hash + Objects.hashCode(this.Persona);
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
        if (!Objects.equals(this.Producto, other.Producto)) {
            return false;
        }
        if (!Objects.equals(this.Persona, other.Persona)) {
            return false;
        }
        return true;
    }

 
   

    

    

  
    
}
