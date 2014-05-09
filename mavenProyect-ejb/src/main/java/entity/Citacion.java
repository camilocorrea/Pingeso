/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camilo
 */
@Entity
@Table(name = "citacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citacion.findAll", query = "SELECT c FROM Citacion c"),
    @NamedQuery(name = "Citacion.findByIdCitacion", query = "SELECT c FROM Citacion c WHERE c.idCitacion = :idCitacion"),
    @NamedQuery(name = "Citacion.findByHoraCitacion", query = "SELECT c FROM Citacion c WHERE c.horaCitacion = :horaCitacion"),
    @NamedQuery(name = "Citacion.findByFecha", query = "SELECT c FROM Citacion c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Citacion.findByIndicacion", query = "SELECT c FROM Citacion c WHERE c.indicacion = :indicacion")})
public class Citacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_citacion")
    private Integer idCitacion;
    @Column(name = "hora_citacion")
    @Temporal(TemporalType.TIME)
    private Date horaCitacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(name = "indicacion")
    private String indicacion;
    @JoinColumn(name = "rut_medico", referencedColumnName = "rut_medico")
    @ManyToOne(optional = false)
    private Medico rutMedico;
    @JoinColumn(name = "rut_paciente", referencedColumnName = "rut_paciente")
    @ManyToOne(optional = false)
    private Paciente rutPaciente;

    public Citacion() {
    }

    public Citacion(Integer idCitacion) {
        this.idCitacion = idCitacion;
    }

    public Integer getIdCitacion() {
        return idCitacion;
    }

    public void setIdCitacion(Integer idCitacion) {
        this.idCitacion = idCitacion;
    }

    public Date getHoraCitacion() {
        return horaCitacion;
    }

    public void setHoraCitacion(Date horaCitacion) {
        this.horaCitacion = horaCitacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public Medico getRutMedico() {
        return rutMedico;
    }

    public void setRutMedico(Medico rutMedico) {
        this.rutMedico = rutMedico;
    }

    public Paciente getRutPaciente() {
        return rutPaciente;
    }

    public void setRutPaciente(Paciente rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCitacion != null ? idCitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citacion)) {
            return false;
        }
        Citacion other = (Citacion) object;
        if ((this.idCitacion == null && other.idCitacion != null) || (this.idCitacion != null && !this.idCitacion.equals(other.idCitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Citacion[ idCitacion=" + idCitacion + " ]";
    }
    
}
