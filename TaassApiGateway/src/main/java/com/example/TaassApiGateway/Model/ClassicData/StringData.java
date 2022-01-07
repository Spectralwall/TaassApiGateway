package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.SourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo char
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class StringData implements SourceDataInterface, Serializable {

    // in questo caso non abbiamo un wrapper ma direttamente la classe String
    private String val;

    public StringData(String x){
        this.val = x;
    }

    @Override
    public Object getData(){
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (String)val;
    }

    @Override
    public String toString() {
        return val;
    }
}
