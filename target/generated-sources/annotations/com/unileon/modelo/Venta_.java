package com.unileon.modelo;

import com.unileon.modelo.Descuento;
import com.unileon.modelo.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-24T00:24:46")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> Fecha;
    public static volatile SingularAttribute<Venta, Persona> Persona;
    public static volatile SingularAttribute<Venta, Integer> IdVenta;
    public static volatile SingularAttribute<Venta, Double> Total;
    public static volatile SingularAttribute<Venta, Descuento> Descuento;
    public static volatile SingularAttribute<Venta, String> Estado;

}