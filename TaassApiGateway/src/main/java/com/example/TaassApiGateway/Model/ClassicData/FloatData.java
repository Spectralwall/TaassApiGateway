package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.SourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo float
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class FloatData implements SourceDataInterface, Serializable {

    private Float val;

    public FloatData(float x){
        this.val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (float)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }

    @JsonCreator
    public FloatData(@JsonProperty("val")Float val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = true;

        if((obj != null) && (obj.getClass().equals(this.getClass()))) {
            FloatData castedObj = (FloatData) obj;

            //check val
            if((val != null) && (castedObj.getData() != null)) {
                if(!val.equals(castedObj.getData())) {
                    res = false;
                }
            } else if(!((val == null) && (castedObj.getData() == null))) {
                res = false;
            }
        } else {
            res = false;
        }

        return res;
    }
}
