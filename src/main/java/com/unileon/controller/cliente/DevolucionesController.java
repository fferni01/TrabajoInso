/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

import com.unileon.EJB.DevolucionFacadeLocal;
import com.unileon.modelo.Devolucion;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@ViewScoped
public class DevolucionesController implements Serializable{
    private List<Devolucion> devoluciones;
    private Persona persona;
    @EJB
    DevolucionFacadeLocal DevolucionEJB;
    
    @PostConstruct
    public void init(){
        Usuario us = us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        persona = us.getPersona();
        devoluciones= DevolucionEJB.findPorPersona(persona);
    }

    public List<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
