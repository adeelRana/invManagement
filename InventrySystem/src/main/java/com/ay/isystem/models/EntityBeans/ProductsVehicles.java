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
import javax.persistence.Transient;

/**
 *
 * @author Adeel rana
 */
@Entity
@Cacheable(false)
@Table(name = "products_vehicles")
@NamedQueries({
    @NamedQuery(name = "ProductsVehicles.findAll", query = "SELECT p FROM ProductsVehicles p"),
    @NamedQuery(name = "ProductsVehicles.findById", query = "SELECT p FROM ProductsVehicles p WHERE p.id = :id"),
    @NamedQuery(name = "ProductsVehicles.findByProductId", query = "SELECT p FROM ProductsVehicles p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductsVehicles.findByVehicleId", query = "SELECT p FROM ProductsVehicles p WHERE p.vehicleId = :vehicleId")})
public class ProductsVehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "product_id")
    private long productId;
    @Basic(optional = false)
    @Column(name = "vehicle_id")
    private long vehicleId;
    @Transient
    private Vehicle vehicle;

    public ProductsVehicles() {
    }

    public ProductsVehicles(Long id) {
        this.id = id;
    }

    public ProductsVehicles(Long id, long productId, long vehicleId) {
        this.id = id;
        this.productId = productId;
        this.vehicleId = vehicleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicle getVehicle() {
          return (Vehicle) DBM.getRecordsBy(Vehicle.class, "Id", vehicleId).get(0);
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        if (!(object instanceof ProductsVehicles)) {
            return false;
        }
        ProductsVehicles other = (ProductsVehicles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getVehicle().getName();
    }

}
