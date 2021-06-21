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
       if(nuevo == null)
            return "error.sw2?faces-redirect=true";
        else
            return "privado/"+buscarRol(nuevo)+"/principal.sw2?faces-redirect=true";
        
        
    }
    private String buscarRol(Usuario nuevo) {
        switch(nuevo.getRol().getIdRol()){
            case 1:
                return "Trabajador";
            case 2:
                return "Cliente";
            case 3:
                return "Admin";
            default:
                return "";
        }
    }
}
