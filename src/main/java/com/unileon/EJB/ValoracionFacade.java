/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Producto;
import com.unileon.modelo.Valoracion;
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
public class ValoracionFacade extends AbstractFacade<Valoracion> implements ValoracionFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionFacade() {
        super(Valoracion.class);
    }
     public List<Valoracion> findValoracionesPorProducto(Producto product){
        String consultaJPQL = "FROM Valoracion v WHERE v.Producto=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", product);
        List<Valoracion> resultado = query.getResultList();
        return resultado;
     }
}
