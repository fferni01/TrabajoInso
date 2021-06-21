/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     public Usuario consultarUsuario(Usuario us){
        Usuario usDevuelto = new Usuario();
         
        String consultaJPQL = "FROM Usuario u WHERE u.User=:param1 and u.Password=:param2";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", us.getUser());
        query.setParameter("param2", us.getPassword());
        List<Usuario> resultado = query.getResultList();
        if(!resultado.isEmpty())
        System.out.println("Usuario: "+resultado.get(0).getUser()+" Contraseña: "+resultado.get(0).getPassword());
        if(resultado.isEmpty()){
            usDevuelto=null;
        }else{
            usDevuelto=resultado.get(0);
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usDevuelto);
        return(usDevuelto);
     }
     
     public List<Usuario> findAllUsuarios(String tipo){
         
         
        String consultaJPQL = "FROM Usuario u WHERE u.rol.TipoUsuario=:param1";
        Query query = em.createQuery(consultaJPQL);
        query.setParameter("param1", tipo);
        List<Usuario> resultado = query.getResultList();

        return(resultado);
     }
}
