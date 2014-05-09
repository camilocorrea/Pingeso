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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByRutPaciente", query = "SELECT p FROM Paciente p WHERE p.rutPaciente = :rutPaciente"),
    @NamedQuery(name = "Paciente.findByNombrePaciente", query = "SELECT p FROM Paciente p WHERE p.nombrePaciente = :nombrePaciente"),
    @NamedQuery(name = "Paciente.findByApellidoPaciente", query = "SELECT p FROM Paciente p WHERE p.apellidoPaciente = :apellidoPaciente"),
    @NamedQuery(name = "Paciente.findByDomicilioPaciente", query = "SELECT p FROM Paciente p WHERE p.domicilioPaciente = :domicilioPaciente"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByCiudadPaciente", query = "SELECT p FROM Paciente p WHERE p.ciudadPaciente = :ciudadPaciente")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rut_paciente")
    private String rutPaciente;
    @Size(max = 100)
    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    @Size(max = 100)
    @Column(name = "apellido_paciente")
    private String apellidoPaciente;
    @Size(max = 100)
    @Column(name = "domicilio_paciente")
    private String domicilioPaciente;
    @Size(max = 100)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Size(max = 100)
    @Column(name = "ciudad_paciente")
    private String ciudadPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutPaciente")
    private List<Citacion> citacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutPaciente")
    private List<Ficha> fichaList;

    public Paciente() {
    }

    public Paciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    public String getRutPaciente() {
        return rutPaciente;
    }

    public void setRutPaciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getDomicilioPaciente() {
        return domicilioPaciente;
    }

    public void setDomicilioPaciente(String domicilioPaciente) {
        this.domicilioPaciente = domicilioPaciente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadPaciente() {
        return ciudadPaciente;
    }

    public void setCiudadPaciente(String ciudadPaciente) {
        this.ciudadPaciente = ciudadPaciente;
    }

    @XmlTransient
    public List<Citacion> getCitacionList() {
        return citacionList;
    }

    public void setCitacionList(List<Citacion> citacionList) {
        this.citacionList = citacionList;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutPaciente != null ? rutPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.rutPaciente == null && other.rutPaciente != null) || (this.rutPaciente != null && !this.rutPaciente.equals(other.rutPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paciente[ rutPaciente=" + rutPaciente + " ]";
    }
    
}
