package com.unileon.modelo;

import com.unileon.modelo.Persona;
import com.unileon.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-21T20:53:13")
@StaticMetamodel(CopiaCarrito.class)
public class CopiaCarrito_ { 

    public static volatile SingularAttribute<CopiaCarrito, Integer> IdCopCarrito;
    public static volatile SingularAttribute<CopiaCarrito, Persona> Persona;
    public static volatile SingularAttribute<CopiaCarrito, Producto> Producto;
    public static volatile SingularAttribute<CopiaCarrito, Integer> Cantidad;
    public static volatile SingularAttribute<CopiaCarrito, Double> Precio;

}