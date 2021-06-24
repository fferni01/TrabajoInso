/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Carrito;
import com.unileon.modelo.Usuario;
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
public class CarritoFacade extends AbstractFacade<Carrito> implements CarritoFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarritoFacade() {
        super(Carrito.class);
    }
    @Override
     public List<Carrito> findProductosPorUsuario(Usuario us){
         
        String consultaJPQL = "FROM Carrito c WHERE c.Persona.idPersona=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", us.getPersona().getIdPersona());
        List<Carrito> resultado = query.getResultList();
        return resultado;
     }
    
}
