/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.CarritoFacadeLocal;
import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.modelo.Carrito;
import com.unileon.modelo.Producto;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

public class PrincipalController implements Serializable{
    
    private List<Producto> Productos;
    private Producto Producto;
    private List<Carrito> Carritos;
    private Usuario usuario;
    private int cantidad;
    @EJB
    private ProductoFacadeLocal ProductoEJB;
    
    @EJB
    private CarritoFacadeLocal CarritoEJB;
    
    @PostConstruct
    public void init(){
        usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        Productos=ProductoEJB.findAll();
        Producto=new Producto();
        Producto.setTipo("X");           
        Carritos=CarritoEJB.findAll();
        cantidad=1;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void introducirProductoCarrito(){
        System.out.println("com.unileon.controller.cliente.PrincipalController.introducirProductoCarrito()");
        Carrito car = estaEnCarrito();
        if(car==null){
        car=new Carrito();
        car.setCantidad(cantidad);
        System.out.println("com.unileon.controller.cliente.PrincipalController.introducirProductoCarrito()");
        car.setPersona(usuario.getPersona());
        car.setProducto(Producto);
        
        CarritoEJB.create(car);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Introducido en el carrito"));
        }else{
            car.setCantidad(car.getCantidad()+cantidad);
            CarritoEJB.edit(car);
        }
        
    }

    private Carrito estaEnCarrito() {
        for (int i = 0; i < Carritos.size(); i++) {
            //System.out.println(Producto.getIdProducto()+" == "+Carritos.get(i).getProducto().getIdProducto()+ "&&"+Carritos.get(i).getPersona().getIdPersona()+" == "+ usuario.getPersona().getIdPersona());
            if(Producto.getIdProducto()==Carritos.get(i).getProducto().getIdProducto() && Carritos.get(i).getPersona().getIdPersona()==usuario.getPersona().getIdPersona()){
                return Carritos.get(i);
            }
        }
        return null;
    }
}
