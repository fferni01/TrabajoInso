/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Producto;
import com.unileon.modelo.Valoracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ValoracionFacadeLocal {

    void create(Valoracion valoracion);

    void edit(Valoracion valoracion);

    void remove(Valoracion valoracion);

    Valoracion find(Object id);

    List<Valoracion> findAll();

    List<Valoracion> findRange(int[] range);

    int count();

    public List<Valoracion> findValoracionesPorProducto(Producto product);
    
}
