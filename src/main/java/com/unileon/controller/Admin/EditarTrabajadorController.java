/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Admin;

import com.unileon.EJB.PersonaFacadeLocal;
import com.unileon.modelo.Persona;
import java.io.Serializable;
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

public class EditarTrabajadorController implements Serializable{
    
    @Inject
    private ListarTrabajadorController listTrabajCon;
    
    @EJB
    private PersonaFacadeLocal PersonasEJB;
    
    private Persona persona;
    
    @PostConstruct
    public void init(){
        persona = listTrabajCon.getUsuario().getPersona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String modificar(){
        PersonasEJB.edit(persona);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Modificacion realizada con exito"));
        return "listarTrabajador.sw2";
    }
}
