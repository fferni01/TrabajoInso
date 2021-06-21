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
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */

@Named
@ViewScoped
public class EliminarTrabajadorController implements Serializable{
    List<Usuario> Usuarios;
    Usuario usuario;
    
    @EJB
    UsuarioFacadeLocal UsuariosEJB;
    
    @PostConstruct
    public void init(){
        Usuarios =UsuariosEJB.findAllUsuarios("T");
        usuario=new Usuario();
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
    }
    public void eliminarTra(){
        UsuariosEJB.remove(usuario);
        Usuarios=UsuariosEJB.findAllUsuarios("T");
    }
}
