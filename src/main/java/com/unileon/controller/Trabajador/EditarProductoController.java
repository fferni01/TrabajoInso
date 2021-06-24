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
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@ViewScoped

public class EditarProductoController implements Serializable{

@Inject
private ListarProductosController ListPro;

private Producto producto;

@EJB
private ProductoFacadeLocal ProductoEJB;

@PostConstruct
public void init(){
    producto=ListPro.getProducto();
    
}

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String modificar(){
        ProductoEJB.edit(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Modificacion realizada con exito"));
        return "listarProductos.sw2";
    }
}
