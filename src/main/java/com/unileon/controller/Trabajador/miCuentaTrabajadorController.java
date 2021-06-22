/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.PersonaFacadeLocal;
import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Usuario;
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

public class miCuentaTrabajadorController implements Serializable{
    private String Genero;
    private Usuario usuario;
    private Persona persona;
    
    @EJB
    private UsuarioFacadeLocal UsuarioEJB;
    @EJB
    private PersonaFacadeLocal PersonaEJB;
    
    @PostConstruct
    public void init(){
        usuario= (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        persona=usuario.getPersona();
        Genero=persona.getSexo();
    }

    public String getGenero() {
        return this.Genero;
    }

    public void setGeneros(String Genero) {
        this.Genero = Genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void modificar(){
        try{
            persona.setSexo(Genero);
            PersonaEJB.edit(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Se ha modificado correctamente"));
        }catch(Exception e){
            
        }
    }
}
