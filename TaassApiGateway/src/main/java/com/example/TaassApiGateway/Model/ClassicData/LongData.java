package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.sourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo Long
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class LongData implements sourceDataInterface, Serializable {

    private Long val;

    public LongData(long x){
        this.val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (long)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
