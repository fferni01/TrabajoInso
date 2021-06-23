/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.CarritoFacadeLocal;
import com.unileon.EJB.CopiaCarritoFacadeLocal;
import com.unileon.EJB.PersonaFacadeLocal;
import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.Carrito;
import com.unileon.modelo.CopiaCarrito;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Producto;
import com.unileon.modelo.Usuario;
import com.unileon.modelo.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

public class cestaController implements Serializable{
    
    private List<Carrito> ProductosCarrito;
    private Usuario us;
    private Persona per;
    private double PrecioTotal;
    
    @EJB
    CarritoFacadeLocal CarritoEJB;
    @EJB
    CopiaCarritoFacadeLocal CopCarritoEJB;
    
    @EJB
    PersonaFacadeLocal PersonaEJB;
    
    @EJB
    VentaFacadeLocal VentaEJB;
    
    @EJB
    ProductoFacadeLocal ProductoEJB;
    
    @PostConstruct
    public void init(){
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        ProductosCarrito=CarritoEJB.findProductosPorUsuario(us);
        per = us.getPersona();
        
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public List<Carrito> getProductosCarrito() {
        return ProductosCarrito;
    }

    public void setProductosCarrito(List<Carrito> ProductosCarrito) {
        this.ProductosCarrito = ProductosCarrito;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    public void EliminarProductoCesta(Carrito c){
        CarritoEJB.remove(c);
        ProductosCarrito=CarritoEJB.findProductosPorUsuario(us);
    }
    
    public String calcularPrecioTotal(){
        PrecioTotal=0;
        
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            PrecioTotal=PrecioTotal+(ProductosCarrito.get(i).getProducto().getPrecio()*ProductosCarrito.get(i).getCantidad());
        }
        PrecioTotal=Math.round(PrecioTotal*100.0)/100.0;
        String resultado = String.valueOf(PrecioTotal);
        return resultado;
        
    }
    public void modificarCantidad(){
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            CarritoEJB.edit(ProductosCarrito.get(i));
        } 
        ProductosCarrito=CarritoEJB.findProductosPorUsuario(us);
    }
    
    private Producto p=new Producto();
    
    public String comprar(){
        if(faltaAlgunCampo()){
      if("".equals(per.getNombre())){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Es necesario introducir el nombre"));
      }
      if("".equals(per.getApellido1())){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Es necesario introducir el primer apellido"));
      }
      if("".equals(per.getDireccion())){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Es necesario introducir la direccion"));
      }
      if("".equals(per.getTarjeta())){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Es necesario introducir la tarjeta"));
      }
      if("".equals(per.getTelefono())){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Es necesario introducir el telefono"));
      }
        return null;
    }else if(comprobarCantidades()){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El producto "+p.getNombre()+" no tiene suficiente unidades en stock, Unidades en Stock: "+p.getCantidad()));
        return null;
    }else{
            CrearVenta();
            return "pedidos.sw2";
            
        }
    }

    private boolean faltaAlgunCampo() {
        if("".equals(per.getNombre()) || "".equals(per.getApellido1())|| "".equals(per.getDireccion()) || "".equals(per.getTarjeta()) || "".equals(per.getTelefono())){
            return true;
        }
        return false;
    }

    private void CrearVenta() {
        CambiarCantidadProducto();
        PersonaEJB.edit(per);
        
        Venta v =new Venta();
        v.setEstado("P");
        v.setTotal(PrecioTotal);
        Date Fecha = new Date();
        v.setFecha(Fecha);
        v.setPersona(per);
        VentaEJB.create(v);
       
        CopiarCarrito(v);
        
    }

    private void CambiarCantidadProducto() {
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            Producto p = new Producto();
            p=ProductosCarrito.get(i).getProducto();
            p.setCantidad(p.getCantidad()-ProductosCarrito.get(i).getCantidad());
            ProductoEJB.edit(p);
        }
    }

    private void CopiarCarrito(Venta v) {
            
        CopiaCarrito copia = new CopiaCarrito();
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            copia.setCantidad(ProductosCarrito.get(i).getCantidad());
            copia.setPersona(ProductosCarrito.get(i).getPersona());
            copia.setProducto(ProductosCarrito.get(i).getProducto());
            copia.setVenta(v);
            CopCarritoEJB.create(copia);
            CarritoEJB.remove(ProductosCarrito.get(i));
        }
    }

    private boolean comprobarCantidades() {
        for (int i = 0; i < ProductosCarrito.size(); i++) {
            Producto p = new Producto();
            p=ProductosCarrito.get(i).getProducto();           
            if((p.getCantidad()-ProductosCarrito.get(i).getCantidad())<0){
                this.p=p;
                return true;
            }
        }
        return false;
    }
}
