package com.example.TaassApiGateway.Model;

public interface sourceDataInterface<T> {
    abstract T getData();
    abstract void setData(T val);
}
