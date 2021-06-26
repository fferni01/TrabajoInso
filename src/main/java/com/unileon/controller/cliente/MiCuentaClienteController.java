/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.cliente;

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
public class MiCuentaClienteController implements Serializable{
    private String Genero;
    private Usuario usuario;
    private Persona persona;
    private String Password;
    
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
        return Genero;
    }

    public void setGenero(String Genero) {
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public void modificar(){
        try{
            persona.setSexo(Genero);
            PersonaEJB.edit(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Datos personales modificados correctamente"));
        }catch(Exception e){
            
        }
    }
     public void modificarNombreUsuario(){
        try{
            if(usuario.getUser().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario no puede estar vacío"));
            }else{
                if(exite()){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario ya existe"));
                }else{
                UsuarioEJB.edit(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de usuario modificado correctamente"));
                }
            }
        }catch(Exception e){
            
        }
    }
         public void modificarContraseniaUsuario(){
        try{
            usuario.setPassword(Password);
            UsuarioEJB.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Contraseña modificada correctamente"));
        }catch(Exception e){
            
        }
    }

    private boolean exite() {
        List<Usuario> Usuarios =UsuarioEJB.findAll();
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getUser().equalsIgnoreCase(usuario.getUser())) {
                return true;
            }
        }
        return false;
    }
}
