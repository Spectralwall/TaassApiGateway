package com.example.TaassApiGateway.Model;

import java.io.Serializable;

public interface sourceDataInterface<T> extends Serializable {
    abstract T getData();
    abstract void setData(T val);
}
