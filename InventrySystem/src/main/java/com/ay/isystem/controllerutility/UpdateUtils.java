/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.controllerutility;

import com.ay.isystem.db.DBM;
import com.ay.isystem.db.DbmUtils;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Users;
import com.ay.isystem.models.Response;

/**
 *
 * @author Adeel rana
 */
public class UpdateUtils {

    DbmUtils dbmUtils = new DbmUtils();

    public Response insert(Object object, String className) {
        Response response;
        switch (className) {
            case "Users":
                response = updateUsers((Users) object);
                break;
            case "Products":
                response = updateProducts((Products) object);
                break;
            default:
                return new Response("invalid Input");
        }
        return response;
    }

    private Response updateUsers(Users user) {
        if (dbmUtils.isUserExist(user.getName(), 0, false)) {
            return new Response("User Already Exists");
        } else {
            return new Response(DBM.insertRecords(Users.class, user));
        }
    }

    private Response updateProducts(Products product) {
        if (dbmUtils.isProductExist(product)) {
            return new Response("Product Already Exists");
        } else {
            return new Response(DBM.insertRecords(Products.class, (product)));
        }
    }

}
