/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ay.isystem.models.EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "vendors")
@NamedQueries({
    @NamedQuery(name = "Vendors.findAll", query = "SELECT v FROM Vendors v"),
    @NamedQuery(name = "Vendors.findById", query = "SELECT v FROM Vendors v WHERE v.id = :id"),
    @NamedQuery(name = "Vendors.findByName", query = "SELECT v FROM Vendors v WHERE v.name = :name"),
    @NamedQuery(name = "Vendors.findByType", query = "SELECT v FROM Vendors v WHERE v.type = :type"),
    @NamedQuery(name = "Vendors.findByOpeningBalance", query = "SELECT v FROM Vendors v WHERE v.openingBalance = :openingBalance"),
    @NamedQuery(name = "Vendors.findByCurrentBalance", query = "SELECT v FROM Vendors v WHERE v.currentBalance = :currentBalance"),
    @NamedQuery(name = "Vendors.findByAddress", query = "SELECT v FROM Vendors v WHERE v.address = :address"),
    @NamedQuery(name = "Vendors.findByZipCode", query = "SELECT v FROM Vendors v WHERE v.zipCode = :zipCode"),
    @NamedQuery(name = "Vendors.findByTelephone", query = "SELECT v FROM Vendors v WHERE v.telephone = :telephone"),
    @NamedQuery(name = "Vendors.findByContactEmail", query = "SELECT v FROM Vendors v WHERE v.contactEmail = :contactEmail"),
    @NamedQuery(name = "Vendors.findByContactPhone", query = "SELECT v FROM Vendors v WHERE v.contactPhone = :contactPhone")})
public class Vendors implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "opening_balance")
    private double openingBalance;
    @Basic(optional = false)
    @Column(name = "current_balance")
    private double currentBalance;
    @Column(name = "address")
    private String address;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone")
    private String contactPhone;

    public Vendors() {
    }

    public Vendors(Long id) {
        this.id = id;
    }

    public Vendors(Long id, String type, long openingBalance, long currentBalance) {
        this.id = id;
        this.type = type;
        this.openingBalance = openingBalance;
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
        if (!(object instanceof Vendors)) {
            return false;
        }
        Vendors other = (Vendors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
