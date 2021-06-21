/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Carrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface CarritoFacadeLocal {

    void create(Carrito carrito);

    void edit(Carrito carrito);

    void remove(Carrito carrito);

    Carrito find(Object id);

    List<Carrito> findAll();

    List<Carrito> findRange(int[] range);

    int count();
    
}
