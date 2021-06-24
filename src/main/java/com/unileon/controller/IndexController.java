/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
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
public class IndexController implements Serializable {
    private Usuario usuario;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String verificarUsuario(){
        Usuario nuevo;
       
        nuevo = usuarioEJB.consultarUsuario(usuario);
        if(nuevo == null)
            System.out.println("privado/error.xhtml"); 
        else
            System.out.println("correcto.xhtml"); 
        //return "index";
       if(nuevo == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrecta"));
            //return "index.sw2";
       }        
       else{
            return "privado/"+buscarRol(nuevo);
       }
        return null;
        
    }
    private String buscarRol(Usuario nuevo) {
        switch(nuevo.getRol().getIdRol()){
            case 1:
                return "Trabajador/pedidosTrabajador.sw2?faces-redirect=true";
            case 2:
                return "Cliente/principal.sw2?faces-redirect=true";
            case 3:
                return "Admin/listarTrabajador.sw2?faces-redirect=true";
            default:
                return "";
        }
    }
}
