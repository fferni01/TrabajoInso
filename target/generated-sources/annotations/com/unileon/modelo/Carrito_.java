package com.unileon.modelo;

import com.unileon.modelo.Persona;
import com.unileon.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-24T00:24:46")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, Persona> Persona;
    public static volatile SingularAttribute<Carrito, Producto> Producto;
    public static volatile SingularAttribute<Carrito, Integer> Cantidad;
    public static volatile SingularAttribute<Carrito, Integer> IdCarrito;

}