/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Admin;

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
public class CambiarContraseñaAdminController implements Serializable{
    private Usuario usuario;
    private String ContraseñaAntigua="";
    private String ContraseñaNueva="";
    @EJB
    private UsuarioFacadeLocal UsuarioEJB;

    @PostConstruct
    public void init(){
        usuario =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContraseñaAntigua() {
        return ContraseñaAntigua;
    }

    public void setContraseñaAntigua(String ContraseñaAntigua) {
        this.ContraseñaAntigua = ContraseñaAntigua;
    }

    public String getContraseñaNueva() {
        return ContraseñaNueva;
    }

    public void setContraseñaNueva(String ContraseñaNueva) {
        this.ContraseñaNueva = ContraseñaNueva;
    }
    
    public void cambiarContraseña(){
        System.out.println(ContraseñaAntigua);
        System.out.println(usuario.getPassword());
         
        if(this.ContraseñaAntigua.equals(this.usuario.getPassword())){
            this.usuario.setPassword(this.ContraseñaNueva);
            this.UsuarioEJB.edit(this.usuario);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Contraseña Cambiada"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La contraseña Antigua no coincide"));
        }
        
    }
}
