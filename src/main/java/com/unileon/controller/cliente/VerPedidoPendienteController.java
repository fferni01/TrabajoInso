/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.CopiaCarritoFacadeLocal;
import com.unileon.EJB.DevolucionFacadeLocal;
import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.CopiaCarrito;
import com.unileon.modelo.Devolucion;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Producto;
import com.unileon.modelo.Usuario;
import com.unileon.modelo.Venta;
import java.io.Serializable;
import java.util.List;
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

public class VerPedidoPendienteController implements Serializable{
     @Inject
    PedidosController pedCont;
    
     private Venta venta;
     private List<CopiaCarrito> ProductosCarrito;
     private CopiaCarrito ProductoCarrito;
     private List<Producto> ListaProductos;
     
     private Persona persona;
     @EJB
     VentaFacadeLocal VentaEJB;
     @EJB
     CopiaCarritoFacadeLocal CopCarritoEJB;
     @EJB
     ProductoFacadeLocal ProductoEJB;
 
     @PostConstruct
     public void init(){
         Usuario us = us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         persona=us.getPersona();
         venta=pedCont.getVenta();
         ProductosCarrito=CopCarritoEJB.findPorVenta(venta);
         ListaProductos=ProductoEJB.findAll();
     }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public CopiaCarrito getProductoCarrito() {
        return ProductoCarrito;
    }

    public void setProductoCarrito(CopiaCarrito ProductoCarrito) {
        this.ProductoCarrito = ProductoCarrito;
    }


    public List<CopiaCarrito> getProductos() {
        return ProductosCarrito;
    }

    public void setProductos(List<CopiaCarrito> Productos) {
        this.ProductosCarrito = Productos;
    }

 
    public String cancelarPedido(){
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pedido Cancelado"));
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            for (int j = 0; j < ListaProductos.size(); j++) {
                if(ProductosCarrito.get(i).getProducto().getIdProducto()==ListaProductos.get(j).getIdProducto()){
                    ListaProductos.get(j).setCantidad(ListaProductos.get(j).getCantidad()+ProductosCarrito.get(i).getCantidad());
                    Producto p = ListaProductos.get(j);
                    ProductoEJB.edit(p);
                }
            }
        }
        
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            CopCarritoEJB.remove(ProductosCarrito.get(i));
        }
        
        VentaEJB.remove(venta);
        
        return "pedidos.sw2";
        
        
    }
    
    public double mostrarPorcentaje(){
        if(venta.getDescuento()==null){
            return 0;
        }else{
            return venta.getDescuento().getPorcentaje();
        }
    }
}
