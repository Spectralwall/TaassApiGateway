package com.example.TaassApiGateway.Model.ClassicData;

import com.example.TaassApiGateway.Model.SourceDataInterface;


import java.io.Serializable;

// classe pe trattare dati di tipo Long
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class LongData implements SourceDataInterface, Serializable {

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

    @JsonCreator
    public LongData(@JsonProperty("val")Long val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = true;

        if((obj != null) && (obj.getClass().equals(this.getClass()))) {
            LongData castedObj = (LongData) obj;

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
