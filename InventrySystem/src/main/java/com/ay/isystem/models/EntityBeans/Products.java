/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.models.EntityBeans;

import com.ay.isystem.db.DBM;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p ORDER BY p.code"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByTypeId", query = "SELECT p FROM Products p WHERE p.typeId = :typeId"),
    @NamedQuery(name = "Products.findByVehicleId", query = "SELECT p FROM Products p WHERE p.vehicleId = :vehicleId"),
    @NamedQuery(name = "Products.findByLocationId", query = "SELECT p FROM Products p WHERE p.locationId = :locationId"),
    @NamedQuery(name = "Products.findByQuantity", query = "SELECT p FROM Products p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findBySaleRate", query = "SELECT p FROM Products p WHERE p.saleRate = :saleRate"),
    @NamedQuery(name = "Products.findByInvoiceRate", query = "SELECT p FROM Products p WHERE p.invoiceRate = :invoiceRate"),
    @NamedQuery(name = "Products.findByOpeningQty", query = "SELECT p FROM Products p WHERE p.openingQty = :openingQty"),
    @NamedQuery(name = "Products.findByOpeningPrice", query = "SELECT p FROM Products p WHERE p.openingPrice = :openingPrice")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "type_id")
    private long typeId;
    @Basic(optional = false)
    @Column(name = "vehicle_id")
    private long vehicleId;
    @Basic(optional = false)
    @Column(name = "location_id")
    private long locationId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "quantity")
    private double quantity;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "sale_rate")
    private double saleRate;
    @Basic(optional = false)
    @Column(name = "invoice_rate")
    private double invoiceRate;
    @Basic(optional = false)
    @Column(name = "opening_qty")
    private double openingQty;
    @Basic(optional = false)
    @Column(name = "opening_price")
    private double openingPrice;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Transient
    private List<Vehicle> vehiclesList;

    public Products() {
    }

    public Products(Long id) {
        this.id = id;
    }

    public Products(Long id, String name, String code, long typeId, long vehicleId, long locationId, double quantity, double price, double saleRate, double invoiceRate, double openingQty, double openingPrice) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.typeId = typeId;
        this.vehicleId = vehicleId;
        this.locationId = locationId;
        this.quantity = quantity;
        this.price = price;
        this.saleRate = saleRate;
        this.invoiceRate = invoiceRate;
        this.openingQty = openingQty;
        this.openingPrice = openingPrice;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    public double getInvoiceRate() {
        return invoiceRate;
    }

    public void setInvoiceRate(double invoiceRate) {
        this.invoiceRate = invoiceRate;
    }

    public double getOpeningQty() {
        return openingQty;
    }

    public void setOpeningQty(double openingQty) {
        this.openingQty = openingQty;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<ProductsVehicles> getVehiclesList() {
        return DBM.getRecordsBy(ProductsVehicles.class, "ProductId", id);
    }

    public void setVehiclesList(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }

}
