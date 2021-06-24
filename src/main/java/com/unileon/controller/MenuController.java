/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;



import com.unileon.EJB.MenuFacadeLocal;
import com.unileon.modelo.Menu;
import com.unileon.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

/**
 *
 * @author Usuario
 */

@Named
@SessionScoped

public class MenuController implements Serializable{
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    private List<Menu> listaMenus = new ArrayList<>();
    private MenuModel menuModel;
    
    @PostConstruct
    public void init(){
        
        this.listaMenus();
        menuModel= new DefaultMenuModel();
        this.establecerPermisos();
        
    }

    public void establecerPermisos() {
        String contexto =FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        
        for(Menu m:listaMenus){
            if(m.getTipo().equals("S") && (m.getMenu()==null)){
                DefaultSubMenu  firstSubMenu =DefaultSubMenu.builder().label(m.getNombre()).build();
                for(Menu i:listaMenus){
                    Menu submenu =i;
                    if(submenu.getMenu()!=null){
                        if(submenu.getMenu().getIdMenu()==m.getIdMenu()){
                            DefaultMenuItem item=DefaultMenuItem.builder().value(i.getNombre()).url(contexto+i.getUrl()).build();
                            firstSubMenu.getElements().add(item);
                        }
                    }
                }
                menuModel.getElements().add(firstSubMenu);
            }
            else{
                if(m.getMenu()==null){
                    DefaultMenuItem item = DefaultMenuItem.builder().value(m.getNombre()).url(contexto+m.getUrl()).build();
                    menuModel.getElements().add(item);
                }
            }
        }
      /*  DefaultMenuItem  item = DefaultMenuItem.builder().value("Cerrar Sesion").command("#{menuController.destruirSesion()}").url("../../index.sw2").build();
        menuModel.getElements().add(item);*/
       
    }

    private void listaMenus() {
        Usuario us;
        
            us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            List<Menu> todo = menuEJB.findAll(); ;
            /*for (int i = 0; i < todo.size(); i++) {
                System.out.println(todo.get(i).getNombre());
            }*/
            
            for(int i=0;i<todo.size();i++){
                if(todo.get(i).getRol().getIdRol()==us.getRol().getIdRol()){
                    Menu m = todo.get(i);
                    listaMenus.add(m);   
                }
            }
            
            
        
    }
    
    public String destruirSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("com.unileon.controller.MenuController.destruirSesion()");
        return "../../index.softwareII";
    }
    
    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    
    
}
