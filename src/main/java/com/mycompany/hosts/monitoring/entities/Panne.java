/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hosts.monitoring.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author majdi
 */
@Entity
@Table(name = "panne")
@NamedQueries({
    @NamedQuery(name = "Panne.findAll", query = "SELECT p FROM Panne p"),
    @NamedQuery(name = "Panne.findById", query = "SELECT p FROM Panne p WHERE p.id = :id"),
    @NamedQuery(name = "Panne.findByDatePanne", query = "SELECT p FROM Panne p WHERE p.datePanne = :datePanne"),
    @NamedQuery(name = "Panne.findByDateReparation", query = "SELECT p FROM Panne p WHERE p.dateReparation = :dateReparation"),
    @NamedQuery(name = "Panne.findByType", query = "SELECT p FROM Panne p WHERE p.type = :type"),
    @NamedQuery(name = "Panne.findByDescription", query = "SELECT p FROM Panne p WHERE p.description = :description")})
public class Panne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_panne")
    @Temporal(TemporalType.DATE)
    private Date datePanne;
    @Column(name = "date_reparation")
    @Temporal(TemporalType.DATE)
    private Date dateReparation;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Host hostId;
    @JoinColumn(name = "technicien_id", referencedColumnName = "id")
    @ManyToOne
    private Technicien technicienId;

    public Panne() {
    }

    public Panne(Integer id) {
        this.id = id;
    }

    public Panne(Integer id, Date datePanne) {
        this.id = id;
        this.datePanne = datePanne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePanne() {
        return datePanne;
    }

    public void setDatePanne(Date datePanne) {
        this.datePanne = datePanne;
    }

    public Date getDateReparation() {
        return dateReparation;
    }

    public void setDateReparation(Date dateReparation) {
        this.dateReparation = dateReparation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Host getHostId() {
        return hostId;
    }

    public void setHostId(Host hostId) {
        this.hostId = hostId;
    }

    public Technicien getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(Technicien technicienId) {
        this.technicienId = technicienId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panne)) {
            return false;
        }
        Panne other = (Panne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hosts.monitoring.Panne[ id=" + id + " ]";
    }
    
}
