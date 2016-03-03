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
@Table(name = "manage_account")
@NamedQueries({
    @NamedQuery(name = "ManageAccount.findAll", query = "SELECT m FROM ManageAccount m"),
    @NamedQuery(name = "ManageAccount.findById", query = "SELECT m FROM ManageAccount m WHERE m.id = :id"),
    @NamedQuery(name = "ManageAccount.findByDate", query = "SELECT m FROM ManageAccount m WHERE m.date = :date"),
    @NamedQuery(name = "ManageAccount.findByDebitAccount", query = "SELECT m FROM ManageAccount m WHERE m.debitAccount = :debitAccount"),
    @NamedQuery(name = "ManageAccount.findByCreditAccount", query = "SELECT m FROM ManageAccount m WHERE m.creditAccount = :creditAccount"),
    @NamedQuery(name = "ManageAccount.findByAmount", query = "SELECT m FROM ManageAccount m WHERE m.amount = :amount")})
public class ManageAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    private long date;
    @Basic(optional = false)
    @Column(name = "debit_account")
    private long debitAccount;
    @Basic(optional = false)
    @Column(name = "credit_account")
    private long creditAccount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private double amount;

    public ManageAccount() {
    }

    public ManageAccount(Integer id) {
        this.id = id;
    }

    public ManageAccount(Integer id, long date, int debitAccount, int creditAccount) {
        this.id = id;
        this.date = date;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(long debitAccount) {
        this.debitAccount = debitAccount;
    }

    public long getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(long creditAccount) {
        this.creditAccount = creditAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        if (!(object instanceof ManageAccount)) {
            return false;
        }
        ManageAccount other = (ManageAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventrysystem.models.ManageAccount[ id=" + id + " ]";
    }

}
