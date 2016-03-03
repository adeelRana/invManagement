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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "deal_details")
@NamedQueries({
    @NamedQuery(name = "DealDetails.findAll", query = "SELECT d FROM DealDetails d"),
    @NamedQuery(name = "DealDetails.findById", query = "SELECT d FROM DealDetails d WHERE d.id = :id"),
    @NamedQuery(name = "DealDetails.findByDealId", query = "SELECT d FROM DealDetails d WHERE d.dealId = :dealId"),
    @NamedQuery(name = "DealDetails.findByTransactionTypeId", query = "SELECT d FROM DealDetails d WHERE d.transactionTypeId = :transactionTypeId"),
    @NamedQuery(name = "DealDetails.findByTansactionDate", query = "SELECT d FROM DealDetails d WHERE d.tansactionDate = :tansactionDate"),
    @NamedQuery(name = "DealDetails.findByProductId", query = "SELECT d FROM DealDetails d WHERE d.productId = :productId"),
    @NamedQuery(name = "DealDetails.findByProductQty", query = "SELECT d FROM DealDetails d WHERE d.productQty = :productQty"),
    @NamedQuery(name = "DealDetails.findByProductSaleRate", query = "SELECT d FROM DealDetails d WHERE d.productSaleRate = :productSaleRate"),
    @NamedQuery(name = "DealDetails.findByProductInvoiceRate", query = "SELECT d FROM DealDetails d WHERE d.productInvoiceRate = :productInvoiceRate")})
public class DealDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "deal_id")
    private long dealId;
    @Basic(optional = false)
    @Column(name = "transaction_type_id")
    private int transactionTypeId;
    @Column(name = "tansaction_date")
    private long tansactionDate;
    @Basic(optional = false)
    @Column(name = "product_id")
    private long productId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_qty")
    private double productQty;
    @Column(name = "product_sale_rate")
    private double productSaleRate;
    @Column(name = "product_invoice_rate")
    private double productInvoiceRate;

    public DealDetails() {
    }

    public DealDetails(Long id) {
        this.id = id;
    }

    public DealDetails(Long id, long dealId, int transactionTypeId, long productId) {
        this.id = id;
        this.dealId = dealId;
        this.transactionTypeId = transactionTypeId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public long getTansactionDate() {
        return tansactionDate;
    }

    public void setTansactionDate(long tansactionDate) {
        this.tansactionDate = tansactionDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getProductQty() {
        return productQty;
    }

    public void setProductQty(double productQty) {
        this.productQty = productQty;
    }

    public double getProductSaleRate() {
        return productSaleRate;
    }

    public void setProductSaleRate(double productSaleRate) {
        this.productSaleRate = productSaleRate;
    }

    public double getProductInvoiceRate() {
        return productInvoiceRate;
    }

    public void setProductInvoiceRate(double productInvoiceRate) {
        this.productInvoiceRate = productInvoiceRate;
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
        if (!(object instanceof DealDetails)) {
            return false;
        }
        DealDetails other = (DealDetails) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return DBM.getSingleRecordById(Products.class, productId).toString();
    }

    public boolean matches(DealDetails object) {
        DealDetails other = (DealDetails) object;
        return (this.id != null || other.id == null) && (this.id == null || this.productId == other.productId);
    }
}
