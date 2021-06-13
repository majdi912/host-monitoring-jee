/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hosts.monitoring.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author majdi
 */
@Entity
@Table(name = "host")
@NamedQueries({
    @NamedQuery(name = "Host.findAll", query = "SELECT h FROM Host h"),
    @NamedQuery(name = "Host.findById", query = "SELECT h FROM Host h WHERE h.id = :id"),
    @NamedQuery(name = "Host.findByIp", query = "SELECT h FROM Host h WHERE h.ip = :ip"),
    @NamedQuery(name = "Host.findByMac", query = "SELECT h FROM Host h WHERE h.mac = :mac"),
    @NamedQuery(name = "Host.findByNom", query = "SELECT h FROM Host h WHERE h.nom = :nom"),
    @NamedQuery(name = "Host.findByLocation", query = "SELECT h FROM Host h WHERE h.location = :location"),
    @NamedQuery(name = "Host.findByStatus", query = "SELECT h FROM Host h WHERE h.status = :status")})
public class Host implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mac")
    private String mac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hostId")
    private Collection<Panne> panneCollection;

    public Host() {
    }

    public Host(Integer id) {
        this.id = id;
    }

    public Host(Integer id, String ip, String mac, String nom, String location, String status) {
        this.id = id;
        this.ip = ip;
        this.mac = mac;
        this.nom = nom;
        this.location = location;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Panne> getPanneCollection() {
        return panneCollection;
    }

    public void setPanneCollection(Collection<Panne> panneCollection) {
        this.panneCollection = panneCollection;
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
        if (!(object instanceof Host)) {
            return false;
        }
        Host other = (Host) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hosts.monitoring.Host[ id=" + id + " ]";
    }
    
}
