/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.CarritoFacadeLocal;
import com.unileon.EJB.ProductoFacadeLocal;
import com.unileon.EJB.ValoracionFacadeLocal;
import com.unileon.modelo.Carrito;
import com.unileon.modelo.Producto;
import com.unileon.modelo.Usuario;
import com.unileon.modelo.Valoracion;
import java.io.Serializable;
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

public class MostrarZapatillasController implements Serializable{
    private List<Producto> Productos;
    private Producto Producto;
    private List<Carrito> Carritos;
    private Usuario usuario;
    private int cantidad;
    private List<Valoracion> valoraciones;
    private int valoracion;
    @EJB
    private ProductoFacadeLocal ProductoEJB;
    
    @EJB
    private CarritoFacadeLocal CarritoEJB;
    
    @EJB 
    private ValoracionFacadeLocal valoracionEJB;
    @PostConstruct
    public void init(){
        usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        Productos=ProductoEJB.findPorTipo("Z");
        Producto=new Producto();
        Producto.setTipo("X");           
        Carritos=CarritoEJB.findAll();
        cantidad=1;
        valoraciones=valoracionEJB.findAll();
        
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

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

  
    
    
    public void introducirProductoCarrito(){
        
        Carrito car = estaEnCarrito();
        if(car==null){
        car=new Carrito();
        car.setCantidad(cantidad);
        car.setPersona(usuario.getPersona());
        car.setProducto(Producto);
        CarritoEJB.create(car);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Introducido en el carrito"));
        Carritos=CarritoEJB.findAll();
        }else{
            if((car.getCantidad()+cantidad)>Producto.getCantidad()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cantidad que intentas meter en el carrito supera el stock"));
            }else{
            car.setCantidad(car.getCantidad()+cantidad);
            CarritoEJB.edit(car);
            Carritos=CarritoEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Introducido en el carrito"));
            }
        }
        
    }

    private Carrito estaEnCarrito() {
        for (int i = 0; i < Carritos.size(); i++) {
            System.out.println(Producto.getIdProducto()+" == "+Carritos.get(i).getProducto().getIdProducto()+ "&&"+Carritos.get(i).getPersona().getIdPersona()+" == "+ usuario.getPersona().getIdPersona());
            if(Producto.getIdProducto()==Carritos.get(i).getProducto().getIdProducto() && Carritos.get(i).getPersona().getIdPersona()==usuario.getPersona().getIdPersona()){
                return Carritos.get(i);
            }
        }
        return null;
    }
    
    public void editarValoracion(Producto product){
        
        if(haRealizadoLaValoracionDeEsteProducto(product)){
        
            Valoracion v=recivirValoracionRealizada(product);
            v.setValoracion(product.getTotalValoracion());
            valoracionEJB.edit(v);
            List<Valoracion> listaValoraciones=valoracionEJB.findValoracionesPorProducto(product);
            double media =0;
            for (int i = 0; i < listaValoraciones.size(); i++) {
                media=media+(double)listaValoraciones.get(i).getValoracion();
            }
            media=media/listaValoraciones.size();
            int totalValoracion=(int) Math.round(media);
            product.setTotalValoracion(totalValoracion);
            ProductoEJB.edit(product);
            Productos=ProductoEJB.findPorTipo("Z");
        
        }else{
            Valoracion v= new Valoracion();
            v.setProducto(product);
            v.setValoracion(product.getTotalValoracion());
            v.setPersona(usuario.getPersona());
            valoracionEJB.create(v);

            List<Valoracion> listaValoraciones=valoracionEJB.findValoracionesPorProducto(product);
            double media =0;
            for (int i = 0; i < listaValoraciones.size(); i++) {
                media=media+(double)listaValoraciones.get(i).getValoracion();
            }
            media=media/listaValoraciones.size();
            int totalValoracion=(int) Math.round(media);
            product.setTotalValoracion(totalValoracion);
            ProductoEJB.edit(product);
            Productos=ProductoEJB.findPorTipo("Z");
        }
    }
   

    private boolean haRealizadoLaValoracionDeEsteProducto(Producto p) {
        List<Valoracion> listaValoraciones=valoracionEJB.findValoracionesPorProducto(p);
        int idPersona =usuario.getPersona().getIdPersona();
        for (int i = 0; i < listaValoraciones.size(); i++) {
            if(listaValoraciones.get(i).getPersona().getIdPersona()==idPersona){
                return true;
            }
        }
        return false;
    }

    private Valoracion recivirValoracionRealizada(Producto p) {
        List<Valoracion> listaValoraciones=valoracionEJB.findValoracionesPorProducto(p);
        Valoracion v=new Valoracion();
        for (int i = 0; i < listaValoraciones.size(); i++) {
            if(listaValoraciones.get(i).getPersona().getIdPersona()==usuario.getPersona().getIdPersona()){
               v=listaValoraciones.get(i);
            }
        }
        return v;
    }

}
