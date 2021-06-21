/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;


import com.unileon.EJB.DescuentoFacadeLocal;
import com.unileon.modelo.Descuento;
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
public class CrearDescuentoController implements Serializable{
    
    private Descuento Descuento;
            
    @EJB
    private DescuentoFacadeLocal DescuentosEJB;
    
    @PostConstruct
    public void init(){
        Descuento=new Descuento();
        
    }
    
    public void insertarDescuento(){
        DescuentosEJB.create(Descuento);
    }

    public Descuento getDescuento() {
        return Descuento;
    }

    public void setDescuento(Descuento Descuento) {
        this.Descuento = Descuento;
    }
    
    
}
