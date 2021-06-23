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
@Table(name="productos")
        
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int IdProducto;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="ImagenUrl")
    private String ImagenUrl;
    
    @Column(name="Marca")
    private String Marca;
    
    @Column(name="Descripcion")
    private String Descripcion;
    
    @Column(name="Cantidad")
    private int Cantidad;
    
    @Column(name="Tipo")
    private String Tipo;
    
    @Column(name="Precio")
    private double Precio;
    
    @JoinColumn(name="IdValoracion")
    @ManyToOne
    private Valoracion Valoracion;

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getImagenUrl() {
        return ImagenUrl;
    }

    public void setImagenUrl(String ImagenUrl) {
        this.ImagenUrl = ImagenUrl;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public Valoracion getValoracion() {
        return Valoracion;
    }

    public void setValoracion(Valoracion Valoracion) {
        this.Valoracion = Valoracion;
    }

    public String getTipoEscrito() {
        switch(Tipo){
            case "Z":
                return "Zapatillas";
            case "C":
                return "camiseta";
            case "CM":
                return "Camisa";
            case "S":
                return "Sudadera";
            case "P":
                return "Pantalón";
            default:
                return "X";
        }

    } 
    public String getInventoryStatus(){
        if(Cantidad==0){
            return "Fuera de Stock";
        }
        else if(Cantidad<3){
            return "Poco Stock";
        }else{
            return "En Stock";
        }
    }
        public String getInventoryStatusCss(){
        if(Cantidad==0){
            return "out-of-stock";
        }
        else if(Cantidad<3){
            return "low-stock";
        }else{
            return "in-stock";
        }
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.IdProducto;
        hash = 83 * hash + Objects.hashCode(this.Nombre);
        hash = 83 * hash + Objects.hashCode(this.ImagenUrl);
        hash = 83 * hash + Objects.hashCode(this.Marca);
        hash = 83 * hash + Objects.hashCode(this.Descripcion);
        hash = 83 * hash + this.Cantidad;
        hash = 83 * hash + Objects.hashCode(this.Tipo);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.Precio) ^ (Double.doubleToLongBits(this.Precio) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.Valoracion);
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
        final Producto other = (Producto) obj;
        if (this.IdProducto != other.IdProducto) {
            return false;
        }
        if (this.Cantidad != other.Cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.Precio) != Double.doubleToLongBits(other.Precio)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.ImagenUrl, other.ImagenUrl)) {
            return false;
        }
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        if (!Objects.equals(this.Descripcion, other.Descripcion)) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Valoracion, other.Valoracion)) {
            return false;
        }
        return true;
    }

   
    
    
}
