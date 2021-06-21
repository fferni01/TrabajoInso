package com.unileon.modelo;

import com.unileon.modelo.Menu;
import com.unileon.modelo.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-21T20:53:13")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> Nombre;
    public static volatile SingularAttribute<Menu, String> Tipo;
    public static volatile SingularAttribute<Menu, Menu> menu;
    public static volatile SingularAttribute<Menu, Integer> IdMenu;
    public static volatile SingularAttribute<Menu, Rol> rol;
    public static volatile SingularAttribute<Menu, String> Url;
    public static volatile SingularAttribute<Menu, Boolean> Estado;

}