/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByRutMedico", query = "SELECT m FROM Medico m WHERE m.rutMedico = :rutMedico"),
    @NamedQuery(name = "Medico.findByNombreMedico", query = "SELECT m FROM Medico m WHERE m.nombreMedico = :nombreMedico"),
    @NamedQuery(name = "Medico.findByApellidoMedico", query = "SELECT m FROM Medico m WHERE m.apellidoMedico = :apellidoMedico")})
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rut_medico")
    private String rutMedico;
    @Size(max = 100)
    @Column(name = "nombre_medico")
    private String nombreMedico;
    @Size(max = 100)
    @Column(name = "apellido_medico")
    private String apellidoMedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutMedico")
    private List<Citacion> citacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutMedico")
    private List<Receta> recetaList;

    public Medico() {
    }

    public Medico(String rutMedico) {
        this.rutMedico = rutMedico;
    }

    public String getRutMedico() {
        return rutMedico;
    }

    public void setRutMedico(String rutMedico) {
        this.rutMedico = rutMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidoMedico() {
        return apellidoMedico;
    }

    public void setApellidoMedico(String apellidoMedico) {
        this.apellidoMedico = apellidoMedico;
    }

    @XmlTransient
    public List<Citacion> getCitacionList() {
        return citacionList;
    }

    public void setCitacionList(List<Citacion> citacionList) {
        this.citacionList = citacionList;
    }

    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutMedico != null ? rutMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.rutMedico == null && other.rutMedico != null) || (this.rutMedico != null && !this.rutMedico.equals(other.rutMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medico[ rutMedico=" + rutMedico + " ]";
    }
    
}
