/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador.pushy;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PushyPushRequest {
    public Object data;
    public String[] registration_ids;

    public PushyPushRequest(Object data, String[] registrationIDs)
    {
        this.data = data;
        this.registration_ids = registrationIDs;
    }
}
