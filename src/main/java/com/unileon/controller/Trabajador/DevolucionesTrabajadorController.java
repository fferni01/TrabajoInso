/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.DevolucionFacadeLocal;
import com.unileon.modelo.Devolucion;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@ViewScoped
public class DevolucionesTrabajadorController implements Serializable{
    private List<Devolucion> devoluciones;
    private Devolucion devolucion;
    @EJB
    DevolucionFacadeLocal DevolucionEJB;
    
    @PostConstruct
    public void init(){
        devoluciones= DevolucionEJB.findPendientes();
    }

    public List<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }
    
    public void aceptarDevolucion(){
        devolucion.setEstado("F");
        DevolucionEJB.edit(devolucion);
        devoluciones= DevolucionEJB.findPendientes();
    }
}
