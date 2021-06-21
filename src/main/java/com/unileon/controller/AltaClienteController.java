/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.PersonaFacadeLocal;
import com.unileon.EJB.RolFacadeLocal;
import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Persona;
import com.unileon.modelo.Rol;
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
public class AltaClienteController implements Serializable{
    
    private Usuario usuario;
    private Persona persona;
    private Rol rol;
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private RolFacadeLocal RolEJB;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
        rol = new Rol();
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public void crearPersona(){
        personaEJB.create(persona);
    }

    public void altaCliente(){
        try{
            if(!existeUsuario()){
            crearPersona();
             Rol tiporol = RolEJB.buscarRol("C");
            usuario.setPersona(persona);
            usuario.setRol(tiporol);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha registrado correctamente"));
            }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre de Usuario ya existe"));
            }       
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    private boolean existeUsuario() {
        List<Usuario> Usuarios =usuarioEJB.findAll();
        
        for (int i = 0; i < Usuarios.size(); i++) {
            if(usuario.getUser().equalsIgnoreCase(Usuarios.get(i).getUser())){
                return true;
            }
        }
        return false;
    }
}
