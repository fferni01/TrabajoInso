/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller.Trabajador;

import com.unileon.EJB.DescuentoFacadeLocal;
import com.unileon.modelo.Descuento;
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
public class DescuentoTrabajadorController implements Serializable{
     
    Descuento Descuento;
    List<Descuento> Descuentos;
    String accion;
    
    @EJB
    DescuentoFacadeLocal DescuentoEJB;
    
    @PostConstruct
    public void init(){
        Descuentos=DescuentoEJB.findAll();
        Descuento=new Descuento();
        accion="";
    }

    public Descuento getDescuento() {
        return Descuento;
    }

    public void setDescuento(Descuento Descuento) {
        this.Descuento = Descuento;
    }

    public List<Descuento> getDescuentos() {
        return Descuentos;
    }

    public void setDescuentos(List<Descuento> Descuentos) {
        this.Descuentos = Descuentos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    public void insertarDescuento(){
        try{
            if(existe()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El codigo de descuento ya existe"));
            }else{
                if(Descuento.getPorcentaje()<100){
                    if(Descuento.getNombreDescuento().equals("")){
                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre del descuento estaba vacio"));
                    }else{
                        this.DescuentoEJB.create(Descuento);
                        Descuentos=DescuentoEJB.findAll();
                    }
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El porcentaje tiene que ser menor de 100%"));
                }
            Descuento=new Descuento();
            }
        }catch(Exception e){
            
        }
        
    }
    
    public void modificarDescuento(){
        try{
            if(existe()){
                if(Descuento.getPorcentaje()<100){
                     if(Descuento.getNombreDescuento().equals("")){
                         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre del descuento estaba vacio"));
                    }else{
                        this.DescuentoEJB.edit(Descuento);
                        
                    }                   
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El porcentaje tiene que ser menor de 100%"));
                    }
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El codigo introducido no exite"));
            }
        }catch(Exception e){
            
        }
        Descuentos=DescuentoEJB.findAll();
        Descuento=new Descuento();
    }
        
    public void eliminarDescuento(){
        try{
            if(existe()){
                    this.DescuentoEJB.remove(Descuento);
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El codigo introducido no exite"));
            }
        }catch(Exception e){
            
        }
        Descuentos=DescuentoEJB.findAll();
        Descuento=new Descuento();
    }
    
    public void establecerDescuentoModificar(Descuento d){
        this.Descuento=d;
        this.accion="M";
    }
    
    public void establecerDescuentoEliminar(Descuento d){
        this.Descuento=d;
        this.accion="E";
    }
    
    public void resetDescuento(){
        Descuento= new Descuento();
    }

    private boolean existe() {
        for (int i = 0; i < Descuentos.size(); i++) {
          if(Descuento.getNombreDescuento().equals(Descuentos.get(i).getNombreDescuento())){
              return true;
          }
        }
        return false;
    }
}
