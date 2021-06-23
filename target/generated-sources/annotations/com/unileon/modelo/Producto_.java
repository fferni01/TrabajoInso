package com.unileon.modelo;

import com.unileon.modelo.Valoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-24T00:24:46")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> Nombre;
    public static volatile SingularAttribute<Producto, String> Tipo;
    public static volatile SingularAttribute<Producto, String> Marca;
    public static volatile SingularAttribute<Producto, Integer> Cantidad;
    public static volatile SingularAttribute<Producto, Valoracion> Valoracion;
    public static volatile SingularAttribute<Producto, Integer> IdProducto;
    public static volatile SingularAttribute<Producto, String> ImagenUrl;
    public static volatile SingularAttribute<Producto, String> Descripcion;
    public static volatile SingularAttribute<Producto, Double> Precio;

}