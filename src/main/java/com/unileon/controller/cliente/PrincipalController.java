/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.modelo.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@RequestScoped

public class PrincipalController implements Serializable{
    
    private List<Producto> Productos;
    private Producto Producto;
    
    @EJB
    private ProductoFacadeLocal ProductoEJB;
    
    @PostConstruct
    public void init(){
        Productos=ProductoEJB.findAll();
        Producto=new Producto();
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> Productos) {
        this.Productos = Productos;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }
    
    
}
