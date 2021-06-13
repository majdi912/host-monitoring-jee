/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hosts.monitoring.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "technicien")
@NamedQueries({
    @NamedQuery(name = "Technicien.findAll", query = "SELECT t FROM Technicien t"),
    @NamedQuery(name = "Technicien.findById", query = "SELECT t FROM Technicien t WHERE t.id = :id"),
    @NamedQuery(name = "Technicien.findByNom", query = "SELECT t FROM Technicien t WHERE t.nom = :nom"),
    @NamedQuery(name = "Technicien.findByMatricule", query = "SELECT t FROM Technicien t WHERE t.matricule = :matricule"),
    @NamedQuery(name = "Technicien.findByMail", query = "SELECT t FROM Technicien t WHERE t.mail = :mail")})
public class Technicien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mail")
    private String mail;
    @OneToMany(mappedBy = "technicienId")
    private Collection<Panne> panneCollection;

    public Technicien() {
    }

    public Technicien(Integer id) {
        this.id = id;
    }

    public Technicien(Integer id, String nom, String matricule, String mail) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!(object instanceof Technicien)) {
            return false;
        }
        Technicien other = (Technicien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hosts.monitoring.Technicien[ id=" + id + " ]";
    }
    
}
