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
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="menus")

public class Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int IdMenu;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name="Tipo")
    private String Tipo;
    @Column(name="Estado")
    private boolean Estado;
    @JoinColumn(name="idRol")
    @ManyToOne
    private Rol rol;
    @JoinColumn(name="IdMenu_Menu")
    @ManyToOne
    private Menu menu;
    @Column(name="url")
    private String Url;

    public int getIdMenu() {
        return IdMenu;
    }

    public void setIdMenu(int IdMenu) {
        this.IdMenu = IdMenu;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.IdMenu;
        hash = 89 * hash + Objects.hashCode(this.Nombre);
        hash = 89 * hash + Objects.hashCode(this.Tipo);
        hash = 89 * hash + (this.Estado ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.rol);
        hash = 89 * hash + Objects.hashCode(this.menu);
        hash = 89 * hash + Objects.hashCode(this.Url);
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
        final Menu other = (Menu) obj;
        if (this.IdMenu != other.IdMenu) {
            return false;
        }
        if (this.Estado != other.Estado) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Url, other.Url)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        return true;
    }
    
    
}
