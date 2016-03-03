/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.models.EntityBeans;

import com.ay.isystem.db.DBM;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "deals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deals.findAll", query = "SELECT d FROM Deals d"),
    @NamedQuery(name = "Deals.findById", query = "SELECT d FROM Deals d WHERE d.id = :id"),
    @NamedQuery(name = "Deals.findByInvoiceDate", query = "SELECT d FROM Deals d WHERE d.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "Deals.findByPartyId", query = "SELECT d FROM Deals d WHERE d.partyId = :partyId"),
    @NamedQuery(name = "Deals.findByPartyType", query = "SELECT d FROM Deals d WHERE d.partyType = :partyType"),
    @NamedQuery(name = "Deals.findByAgentId", query = "SELECT d FROM Deals d WHERE d.agentId = :agentId"),
    @NamedQuery(name = "Deals.findByTransactionTypeId", query = "SELECT d FROM Deals d WHERE d.transactionTypeId = :transactionTypeId"),
    @NamedQuery(name = "Deals.findByTransactionAmount", query = "SELECT d FROM Deals d WHERE d.transactionAmount = :transactionAmount"),
    @NamedQuery(name = "Deals.findByStatus", query = "SELECT d FROM Deals d WHERE d.status = :status")})
public class Deals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(name = "invoice_no")
    private String invoiceNo;
    @Basic(optional = false)
    @Column(name = "invoice_date")
    private long invoiceDate;
    @Basic(optional = false)
    @Column(name = "party_id")
    private long partyId;
    @Basic(optional = false)
    @Column(name = "party_type")
    private String partyType;
    @Column(name = "agent_id")
    private long agentId;
    @Basic(optional = false)
    @Column(name = "transaction_type_id")
    private long transactionTypeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "transaction_amount")
    private double transactionAmount;
    @Column(name = "status")
    private Boolean status;
    @Lob
    @Column(name = "reamarks")
    private String reamarks;

    @Transient
    private ArrayList<DealDetails> details;
    @Transient
    private ArrayList<DealDetails> returnDetails;
    @Transient
    private Vendors party;
    @Transient
    private boolean update;
    @Transient
    private boolean saleReturn;

    public Deals() {
    }

    public Deals(Long id) {
        this.id = id;
    }

    public Deals(Long id, String invoiceNo, long invoiceDate, long partyId, String partyType, long transactionTypeId, double transactionAmount) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.partyId = partyId;
        this.partyType = partyType;
        this.transactionTypeId = transactionTypeId;
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public long getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(long invoiceDate) {
        this.invoiceDate = invoiceDate;
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

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getReamarks() {
        return reamarks;
    }

    public void setReamarks(String reamarks) {
        this.reamarks = reamarks;
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
        if (!(object instanceof Deals)) {
            return false;
        }
        Deals other = (Deals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public ArrayList<DealDetails> getDetails() {
        if (this.details == null) {
            String query = "SELECT d FROM DealDetails d WHERE d.dealId ='" + this.id + "' AND d.transactionTypeId = 5 ";
            return DBM.getRecordsFromQuery(query);
        } else {
            return details;
        }

    }

    public void setDetails(ArrayList<DealDetails> details) {
        this.details = details;
    }

    public ArrayList<DealDetails> getReturnDetails() {
        if (this.returnDetails == null) {
            String query = "SELECT d FROM DealDetails d WHERE d.dealId ='" + this.id + "' AND d.transactionTypeId = 11 ";
            return DBM.getRecordsFromQuery(query);
        } else {
            return returnDetails;
        }
    }

    public void setReturnDetails(ArrayList<DealDetails> returnDetails) {
        this.returnDetails = returnDetails;
    }

    public Vendors getParty() {
        return DBM.getSingleRecordById(Vendors.class, partyId);
    }

    public void setParty(Vendors party) {
        this.party = party;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isSaleReturn() {
        return saleReturn;
    }

    public void setSaleReturn(boolean saleReturn) {
        this.saleReturn = saleReturn;
    }

    @Override
    public String toString() {
        return this.invoiceNo;
    }

}
