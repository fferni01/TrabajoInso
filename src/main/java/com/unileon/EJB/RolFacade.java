/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    public Rol buscarRol(String eleccion){
        Rol rol = null;
        List<Rol>listaroles = findAll();
            for(int i=0;i<listaroles.size();i++){
                if(listaroles.get(i).getTipoUsuario().equals(eleccion))
                    rol=listaroles.get(i);
            }
        return rol;
    }
    
}
