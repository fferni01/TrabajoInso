/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.VentaFacadeLocal;
import com.unileon.modelo.Venta;
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
public class pedidosTrabajadorController implements Serializable{
    List<Venta> Pedidos;
    Venta Pedido;
    
    @EJB
    VentaFacadeLocal VentaEJB;
    
    @PostConstruct
    public void init(){
        Pedidos=VentaEJB.findAllPendientes();
    }

    public List<Venta> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(List<Venta> Pedidos) {
        this.Pedidos = Pedidos;
    }

    public Venta getPedido() {
        return Pedido;
    }

    public void setPedido(Venta Pedido) {
        this.Pedido = Pedido;
    }
    public double mostrarPorcentaje(){
        if(Pedido.getDescuento()==null){
            return 0;
        }else{
            return Pedido.getDescuento().getPorcentaje();
        }
    }
}
