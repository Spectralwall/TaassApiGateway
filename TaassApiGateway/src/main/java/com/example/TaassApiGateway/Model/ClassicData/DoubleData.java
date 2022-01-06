package com.example.TaassApiGateway.Model.ClassicData;



import com.example.TaassApiGateway.Model.sourceDataInterface;

import java.io.Serializable;

// classe pe trattare dati di tipo double
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class DoubleData implements sourceDataInterface, Serializable {

    private Double val;

    public  DoubleData(double x){
        val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (Double) val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
