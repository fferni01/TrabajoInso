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
@Table(name="roles")

public class Rol implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRol;
    @Column(name="TipoUsuario")
    private String TipoUsuario;
    @Column(name="Descripcion")
    private String Descripcion;

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IdRol;
        hash = 97 * hash + Objects.hashCode(this.TipoUsuario);
        hash = 97 * hash + Objects.hashCode(this.Descripcion);
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
        final Rol other = (Rol) obj;
        if (this.IdRol != other.IdRol) {
            return false;
        }
        if (!Objects.equals(this.TipoUsuario, other.TipoUsuario)) {
            return false;
        }
        if (!Objects.equals(this.Descripcion, other.Descripcion)) {
            return false;
        }
        return true;
    }
    
    
    
}
