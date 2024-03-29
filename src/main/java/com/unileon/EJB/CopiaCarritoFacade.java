/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.CopiaCarrito;
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
public class CopiaCarritoFacade extends AbstractFacade<CopiaCarrito> implements CopiaCarritoFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CopiaCarritoFacade() {
        super(CopiaCarrito.class);
    }
    public List<CopiaCarrito> findPorVenta(Venta venta){
        String consultaJPQL = "FROM CopiaCarrito c WHERE c.Venta=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", venta);
        List<CopiaCarrito> resultado = query.getResultList();
        return resultado;
    }
}
