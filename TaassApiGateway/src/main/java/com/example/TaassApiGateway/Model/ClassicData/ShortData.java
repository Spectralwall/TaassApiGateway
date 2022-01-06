package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.sourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo float
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ShortData implements sourceDataInterface, Serializable {

    private Short val;

    public ShortData(short x){
        this.val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (short)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
