package com.unileon.modelo;

import com.unileon.modelo.Persona;
import com.unileon.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-24T00:24:46")
@StaticMetamodel(Devolucion.class)
public class Devolucion_ { 

    public static volatile SingularAttribute<Devolucion, Persona> Persona;
    public static volatile SingularAttribute<Devolucion, Integer> Cantidad;
    public static volatile SingularAttribute<Devolucion, Producto> Producto;
    public static volatile SingularAttribute<Devolucion, Integer> IdDevolucion;
    public static volatile SingularAttribute<Devolucion, String> Estado;

}