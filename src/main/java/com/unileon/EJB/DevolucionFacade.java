/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Devolucion;
import com.unileon.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class DevolucionFacade extends AbstractFacade<Devolucion> implements DevolucionFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevolucionFacade() {
        super(Devolucion.class);
    }
    
    @Override
    public List<Devolucion> findPorPersona(Persona persona){
       
        String consultaJPQL = "FROM Devolucion d WHERE d.Persona=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", persona);
        List<Devolucion> resultado = query.getResultList();
        return resultado;
        
    }
    @Override
    public List<Devolucion> findPendientes(){
        String consultaJPQL = "FROM Devolucion d WHERE d.Estado=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", "P");
        List<Devolucion> resultado = query.getResultList();
        return resultado;
    }
}
