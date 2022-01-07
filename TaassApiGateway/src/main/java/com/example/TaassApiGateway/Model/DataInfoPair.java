package com.example.TaassApiGateway.Model;

/*
 * classe per le coppie di dati che vengon mandate dal server
 * durante la registrazione di un  nuovo topic
 */

import java.io.Serializable;

public class DataInfoPair implements Serializable {

    private String name;

    private String data;

    public DataInfoPair(String name, String type){
        this.name = name;
        this.data = type;
    }

    public DataInfoPair(){}

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "dataInfoPair{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
