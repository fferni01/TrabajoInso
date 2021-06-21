/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.CopiaCarrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface CopiaCarritoFacadeLocal {

    void create(CopiaCarrito copiaCarrito);

    void edit(CopiaCarrito copiaCarrito);

    void remove(CopiaCarrito copiaCarrito);

    CopiaCarrito find(Object id);

    List<CopiaCarrito> findAll();

    List<CopiaCarrito> findRange(int[] range);

    int count();
    
}
