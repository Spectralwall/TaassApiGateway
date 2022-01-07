package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.SourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo integer
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class IntegerData implements SourceDataInterface, Serializable {

    //come attributo abbiamo un Integer ovvero la classe wrapper di int
    //cosi possimo sfruttare tutti i supi metodi
    private Integer val;

    public IntegerData(int x){
        val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (Integer) val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
