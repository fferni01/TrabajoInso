/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;


import com.unileon.modelo.Persona;
import com.unileon.modelo.Venta;
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
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    @Override
    public List<Venta> findVentaPorPersona(Persona persona){
        String consultaJPQL = "FROM Venta v WHERE v.Persona.idPersona=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1",persona.getIdPersona());
        List<Venta> resultado = query.getResultList();
        return resultado;
    }
    
    public List<Venta> findAllPendientes(){
        String consultaJPQL = "FROM Venta v WHERE v.Estado=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", "P");
        List<Venta> resultado = query.getResultList();
        return resultado;
    }
}
