/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.db;

import com.ay.isystem.models.EntityBeans.Location;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Users;
import com.ay.isystem.models.EntityBeans.Vehicle;
import com.ay.isystem.models.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Adeel rana
 */
public class DbmUtils {

    public boolean isUserExist(String userName, Number userId, boolean isIdIncluded) {
        if (isIdIncluded) {
            String query = "SELECT u FROM Users u WHERE u.name = '" + userName + "' AND u.id !=  '" + userId + "'";
            return !DBM.getRecordsFromQuery(query).isEmpty();
        } else {
            return !DBM.getRecordsBy(Users.class, "Name", userName).isEmpty();
        }
    }

    public boolean islogedIn(Login login) {
        String query = "SELECT u FROM Users u WHERE u.name = '" + login.getUserName() + "' AND u.password =  '" + login.getPassword() + "'";
        return !DBM.getRecordsFromQuery(query).isEmpty();
    }

//////////////////////////////////////////////////////////////////////////////////////////
    public boolean isVehicleExist(Vehicle vehicle) {
        String query = "SELECT v FROM Vehicle v WHERE( v.name = '" + vehicle.getName() + "' AND v.model = '" + vehicle.getModel() + "')";
        return !DBM.getRecordsFromQuery(query).isEmpty();
    }

    public long getVehicleId(Vehicle vehicle) {
        String query = "SELECT v FROM Vehicle v WHERE  ( v.name = '" + vehicle.getName() + "' AND v.model = '" + vehicle.getModel() + "')";
        return ((Vehicle) DBM.getRecordsFromQuery(query).get(0)).getId();
    }

    public static void addVehicle(Vehicle vehicle) {
        if (!vehicle.getName().isEmpty()) {
            if (JOptionPane.showConfirmDialog(null, "Vehicle " + vehicle.getName() + " having Model " + vehicle.getModel() + " Does not exist. \n Do you want to add new ") == 0) {
                DBM.insertRecords(Vehicle.class, vehicle);
            }
        }
    }

    public boolean isLocationExist(Location location) {
        String query = "SELECT l FROM Location l WHERE ( l.name = '" + location.getName() + "' )";
        return !DBM.getRecordsFromQuery(query).isEmpty();
    }

    public int getLocationId(Location location) {
        String query = "SELECT l FROM Location l WHERE ( l.name = '" + location.getName() + "' )";
        return ((Location) DBM.getRecordsFromQuery(query).get(0)).getId();
    }

    public static
            int addLocation(Location location) {
        if (!location.getName().isEmpty()) {
            if (JOptionPane.showConfirmDialog(null, "Location \"" + location.getName() + "\" Does not exist. \n Do you want to add new ") == 0) {
                return ((Location) DBM.insertRecords(Location.class, location)).getId();
            }
        }
        return 0;
    }

    public boolean isProductExist(Products product) {
        String query = "SELECT p FROM Products p WHERE p.code = '" + product.getCode() + "' ";
//                + "AND ( p.typeId = '" + product.getTypeId() + "' AND p.vehicleId = '" + product.getVehicleId() + "' "
//                + "AND p.locationId = '" + product.getLocationId() + "' )";
        return !DBM.getRecordsFromQuery(query).isEmpty();
    }

    public static
            void addProduct(Products product) {
        DBM.insertRecords(Products.class, product);
    }

    public Products getProduct(Products product) {
        String query = "SELECT p FROM Products p WHERE p.code = '" + product.getCode() + "' "
                + "AND ( p.type = '" + product.getTypeId() + "' AND p.vehicleId = '" + product.getVehicleId() + "' "
                + "AND p.locationId = '" + product.getLocationId() + "' )";
        return (Products) DBM.getRecordsFromQuery(query).get(0);
    }

}
