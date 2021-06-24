/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.CopiaCarritoFacadeLocal;
import com.unileon.EJB.DevolucionFacadeLocal;
import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.CopiaCarrito;
import com.unileon.modelo.Devolucion;
import com.unileon.modelo.Persona;
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
public class VerPedidoFinalizadoController implements Serializable{
    
    @Inject
    PedidosController pedCont;
    
     private Venta venta;
     private List<CopiaCarrito> Productos;
     private CopiaCarrito ProductoCarrito;
     private int CantidadDevover;
     private Persona persona;
     @EJB
     VentaFacadeLocal VentaEJB;
     @EJB
     CopiaCarritoFacadeLocal CopCarritoEJB;
     @EJB
     DevolucionFacadeLocal DevolucionEJB;
     @PostConstruct
     public void init(){
         Usuario us = us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         persona=us.getPersona();
         venta=pedCont.getVenta();
         Productos=CopCarritoEJB.findPorVenta(venta);
         CantidadDevover=1;
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
        return Productos;
    }

    public void setProductos(List<CopiaCarrito> Productos) {
        this.Productos = Productos;
    }

    public int getCantidadDevover() {
        return CantidadDevover;
    }

    public void setCantidadDevover(int CantidadDevover) {
        this.CantidadDevover = CantidadDevover;
    }
    public String devolver(){
        Devolucion D =new Devolucion();
        D.setEstado("P");
        D.setCantidad(CantidadDevover);
        D.setPersona(persona);
        D.setProducto(ProductoCarrito.getProducto());
        DevolucionEJB.create(D);
        double totalConDescuento=0;
        if(ProductoCarrito.getCantidad()==CantidadDevover){
            if(venta.getDescuento()!=null){
            totalConDescuento=ProductoCarrito.getProducto().getPrecio()*venta.getDescuento().getPorcentaje()/100;
            totalConDescuento=ProductoCarrito.getProducto().getPrecio()-totalConDescuento;
            venta.setTotal(Math.round((venta.getTotal()-totalConDescuento)*100.0)/100.0);
            }else{
                venta.setTotal(Math.round((venta.getTotal()-(ProductoCarrito.getProducto().getPrecio()))*100.0)/100.0);
            }
            VentaEJB.edit(venta);
            CopCarritoEJB.remove(ProductoCarrito);
        }else{
            if(venta.getDescuento()!=null){
                totalConDescuento=ProductoCarrito.getProducto().getPrecio()*venta.getDescuento().getPorcentaje()/100;
                totalConDescuento=ProductoCarrito.getProducto().getPrecio()-totalConDescuento;
                venta.setTotal(Math.round((venta.getTotal()-totalConDescuento)*100.0)/100.0);
            }else{
                venta.setTotal(Math.round((venta.getTotal()-(ProductoCarrito.getProducto().getPrecio()))*100.0)/100.0);
            } 
            VentaEJB.edit(venta);
            ProductoCarrito.setCantidad(ProductoCarrito.getCantidad()-CantidadDevover);
            CopCarritoEJB.edit(ProductoCarrito);
        }
        if(venta.getTotal()<=0){
            VentaEJB.remove(venta);
            return "pedidos.sw2";
        }
        Productos=CopCarritoEJB.findPorVenta(venta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Peticion de devolucion realizada"));
        return null;
        
    }
        public double mostrarPorcentaje(){
        if(venta.getDescuento()==null){
            return 0;
        }else{
            return venta.getDescuento().getPorcentaje();
        }
    }
}
