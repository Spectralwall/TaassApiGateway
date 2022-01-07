package com.example.TaassApiGateway.Model;

public class typeNameReg<T> {
    private String name;
    private T val;
    public typeNameReg(String name, T val){
        this.name = name;
        this.val=val;
    }

    public T getVal() {
        return val;
    }

    public String getName() {
        return name;
    }
}