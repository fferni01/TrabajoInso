/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Usuario
 */

@Entity
@Table(name="personas")


public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Apellido1")
    private String Apellido1;
    
    @Column(name="Apellido2")
    private String Apellido2;
    
    @Column(name="Sexo")
    private String Sexo;
    
    @Column(name="FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date FechaNacimiento;
    
    @Column(name="Telefono")
    private String Telefono;
    
    @Column(name="Tarjeta")
    private String Tarjeta;
   
    @Column(name="DNI")
    private String DNI;
    
    @Column(name="Direccion")
    private String Direccion;
    
    @Column(name="CodigoPostal")
    private String CodigoPostal;
    @Column(name="Ciudad")
    private String Ciudad;
    @Column(name="Pais")
    private String Pais;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTarjeta() {
        return Tarjeta;
    }

    public void setTarjeta(String Tarjeta) {
        this.Tarjeta = Tarjeta;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idPersona;
        hash = 97 * hash + Objects.hashCode(this.Nombre);
        hash = 97 * hash + Objects.hashCode(this.Apellido1);
        hash = 97 * hash + Objects.hashCode(this.Apellido2);
        hash = 97 * hash + Objects.hashCode(this.Sexo);
        hash = 97 * hash + Objects.hashCode(this.FechaNacimiento);
        hash = 97 * hash + Objects.hashCode(this.Telefono);
        hash = 97 * hash + Objects.hashCode(this.Tarjeta);
        hash = 97 * hash + Objects.hashCode(this.DNI);
        hash = 97 * hash + Objects.hashCode(this.Direccion);
        hash = 97 * hash + Objects.hashCode(this.CodigoPostal);
        hash = 97 * hash + Objects.hashCode(this.Ciudad);
        hash = 97 * hash + Objects.hashCode(this.Pais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellido1, other.Apellido1)) {
            return false;
        }
        if (!Objects.equals(this.Apellido2, other.Apellido2)) {
            return false;
        }
        if (!Objects.equals(this.Sexo, other.Sexo)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.Tarjeta, other.Tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        if (!Objects.equals(this.CodigoPostal, other.CodigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.Ciudad, other.Ciudad)) {
            return false;
        }
        if (!Objects.equals(this.Pais, other.Pais)) {
            return false;
        }
        if (!Objects.equals(this.FechaNacimiento, other.FechaNacimiento)) {
            return false;
        }
        return true;
    }

   

    
    
}
