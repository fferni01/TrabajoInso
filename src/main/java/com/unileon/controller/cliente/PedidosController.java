/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.Usuario;
import com.unileon.modelo.Venta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@RequestScoped
public class PedidosController {
    
    private List<Venta>Ventas;
    private Venta venta;
    @EJB
    private VentaFacadeLocal VentaEJB;
    
    @PostConstruct
    public void init(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        Ventas=VentaEJB.findVentaPorPersona(us.getPersona());
    }

    public List<Venta> getVentas() {
        return Ventas;
    }

    public void setVentas(List<Venta> Ventas) {
        this.Ventas = Ventas;
    }
    public void establecerVenta(Venta v){
        this.venta=v;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
}
