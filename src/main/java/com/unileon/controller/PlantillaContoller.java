/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.unileon.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named
@ViewScoped
public class PlantillaContoller implements Serializable{
    
    public void verificarYMostrar() throws IOException{
        Usuario us=new Usuario();
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        if(us==null){
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.sw2");
        }
        
    }
}
