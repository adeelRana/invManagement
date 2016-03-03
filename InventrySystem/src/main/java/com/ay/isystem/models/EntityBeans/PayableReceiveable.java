/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.models.EntityBeans;

import com.ay.isystem.db.DBM;
import java.io.Serializable;
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
import javax.persistence.Transient;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "payable_receiveable")
@NamedQueries({
    @NamedQuery(name = "PayableReceiveable.findAll", query = "SELECT p FROM PayableReceiveable p"),
    @NamedQuery(name = "PayableReceiveable.findById", query = "SELECT p FROM PayableReceiveable p WHERE p.id = :id"),
    @NamedQuery(name = "PayableReceiveable.findByDate", query = "SELECT p FROM PayableReceiveable p WHERE p.date = :date"),
    @NamedQuery(name = "PayableReceiveable.findByChequeNo", query = "SELECT p FROM PayableReceiveable p WHERE p.chequeNo = :chequeNo"),
    @NamedQuery(name = "PayableReceiveable.findByPartyId", query = "SELECT p FROM PayableReceiveable p WHERE p.partyId = :partyId"),
    @NamedQuery(name = "PayableReceiveable.findByPartyType", query = "SELECT p FROM PayableReceiveable p WHERE p.partyType = :partyType"),
    @NamedQuery(name = "PayableReceiveable.findByAccountId", query = "SELECT p FROM PayableReceiveable p WHERE p.accountId = :accountId"),
    @NamedQuery(name = "PayableReceiveable.findByAmount", query = "SELECT p FROM PayableReceiveable p WHERE p.amount = :amount")})
public class PayableReceiveable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date")
    private long date;
    @Column(name = "cheque_no")
    private String chequeNo;
    @Basic(optional = false)
    @Column(name = "party_id")
    private long partyId;
    @Basic(optional = false)
    @Column(name = "party_type")
    private String partyType;
    @Basic(optional = false)
    @Column(name = "account_id")
    private long accountId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Transient
    private Vendors party;

    public PayableReceiveable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public long getPartyId() {
        return partyId;
    }

    public void setPartyId(long partyId) {
        this.partyId = partyId;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Vendors getParty() {
        return DBM.getSingleRecordById(Vendors.class, partyId);
    }

    public void setParty(Vendors party) {
        this.party = party;
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
        if (!(object instanceof PayableReceiveable)) {
            return false;
        }
        PayableReceiveable other = (PayableReceiveable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getParty().getName();
    }

}
