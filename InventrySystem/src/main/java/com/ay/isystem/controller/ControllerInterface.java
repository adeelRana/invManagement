/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.controller;

import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.EntityBeans.PayableReceiveable;
import com.ay.isystem.models.Response;
import com.ay.isystem.models.Login;

/**
 *
 * @author Adeel rana
 */
public interface ControllerInterface {

    public Response fetch(String param);

    public Response login(Login login);

    public Response logout();

    public Response insertRecord(Object object, String className);

    public Response updateRecord(Object object, String className);

    public Response deleteRecord(long id, Class className);

    public Response addDeal(Deals dealBean, int transactionType);

    public Response deleteDeal(Number dealId, long vendorId, long agentId, int transactionType);

    public Response addPayableReceiveable(PayableReceiveable tran);

    public Response deletePayableReceiveable(long id, Class className);

    public Response BackUp();

    public Response Restore();

}
