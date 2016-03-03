/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ay.isystem.models.EntityBeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "license")
@NamedQueries({
    @NamedQuery(name = "License.findAll", query = "SELECT l FROM License l"),
    @NamedQuery(name = "License.findById", query = "SELECT l FROM License l WHERE l.id = :id"),
    @NamedQuery(name = "License.findByInstallationDate", query = "SELECT l FROM License l WHERE l.installationDate = :installationDate"),
    @NamedQuery(name = "License.findByUpdateDate", query = "SELECT l FROM License l WHERE l.updateDate = :updateDate"),
    @NamedQuery(name = "License.findByDaysAllow", query = "SELECT l FROM License l WHERE l.daysAllow = :daysAllow"),
    @NamedQuery(name = "License.findByDaysRun", query = "SELECT l FROM License l WHERE l.daysRun = :daysRun"),
    @NamedQuery(name = "License.findByCreated", query = "SELECT l FROM License l WHERE l.created = :created"),
    @NamedQuery(name = "License.findByPass", query = "SELECT l FROM License l WHERE l.pass = :pass"),
    @NamedQuery(name = "License.findByDbVersion", query = "SELECT l FROM License l WHERE l.dbVersion = :dbVersion")})
public class License implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "key")
    private String key;
    @Lob
    @Column(name = "mac_address")
    private String macAddress;
    @Column(name = "installation_date")
    private long installationDate;
    @Column(name = "update_date")
    private long updateDate;
    @Column(name = "days_allow")
    private Integer daysAllow;
    @Column(name = "days_run")
    private Integer daysRun;
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @Column(name = "dbVersion")
    private String dbVersion;

    public License() {
    }

    public License(Integer id) {
        this.id = id;
    }

    public License(Integer id, Date created, String pass, String dbVersion) {
        this.id = id;
        this.created = created;
        this.pass = pass;
        this.dbVersion = dbVersion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(long installationDate) {
        this.installationDate = installationDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDaysAllow() {
        return daysAllow;
    }

    public void setDaysAllow(Integer daysAllow) {
        this.daysAllow = daysAllow;
    }

    public Integer getDaysRun() {
        return daysRun;
    }

    public void setDaysRun(Integer daysRun) {
        this.daysRun = daysRun;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion;
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
        if (!(object instanceof License)) {
            return false;
        }
        License other = (License) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventrysystem.models.License[ id=" + id + " ]";
    }
    
}
