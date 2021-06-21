/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Admin;

import com.unileon.EJB.UsuarioFacadeLocal;
import com.unileon.modelo.Usuario;
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

public class ListarTrabajadorController implements Serializable{
    List<Usuario> Usuarios;
    Usuario usuario;
    
    @EJB
    UsuarioFacadeLocal UsuariosEJB;
    
    @PostConstruct
    public void init(){
        Usuarios =UsuariosEJB.findAllUsuarios("T");
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void establecerTrabajador(Usuario us){
        this.usuario=us;
        System.out.println(usuario.getPersona().getNombre());
    }
}
