/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.CopiaCarritoFacadeLocal;
import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.CopiaCarrito;
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


public class RealizarVentaController implements Serializable{
    @Inject
    private pedidosTrabajadorController pedT;
    
    private Venta venta;
    private List<CopiaCarrito> copCarrito;
    
    @EJB
    private CopiaCarritoFacadeLocal CopCarritoEJB;
    
    @EJB
    private VentaFacadeLocal VentaEJB;
    
    
    @PostConstruct
    public void init(){
        venta=pedT.getPedido();
        copCarrito=CopCarritoEJB.findPorVenta(venta);
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<CopiaCarrito> getCopCarrito() {
        return copCarrito;
    }

    public void setCopCarrito(List<CopiaCarrito> copCarrito) {
        this.copCarrito = copCarrito;
    }
    
    public String ConfirmarVenta(){
        venta.setEstado("F");
        VentaEJB.edit(venta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Venta realizada con exito"));
        return "pedidosTrabajador.sw2";
        
    }
        public double mostrarPorcentaje(){
        if(venta.getDescuento()==null){
            return 0;
        }else{
            return venta.getDescuento().getPorcentaje();
        }
    }
}
