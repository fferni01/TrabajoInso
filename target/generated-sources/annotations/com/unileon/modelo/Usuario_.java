package com.unileon.modelo;

import com.unileon.modelo.Persona;
import com.unileon.modelo.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-22T14:46:29")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> User;
    public static volatile SingularAttribute<Usuario, Persona> persona;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, String> Password;

}