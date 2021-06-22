/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.modelo.Producto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@ViewScoped

public class crearProductoController implements Serializable{
    Producto producto;
    
    @EJB
    ProductoFacadeLocal ProductoEJB;
    
    @PostConstruct
    public void init(){
        producto= new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public String crearProducto(){
        try {
            ProductoEJB.create(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto creado con exito"));
        } catch (Exception e) {
        }
        return "listarProductos.sw2";
    }
}
