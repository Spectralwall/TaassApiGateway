package com.example.TaassApiGateway.Model.ClassicData;



import com.example.TaassApiGateway.Model.SourceDataInterface;

import java.io.Serializable;

// classe pe trattare dati di tipo char
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class CharData implements SourceDataInterface, Serializable {

    private Character val;

    public CharData(char x){
        this.val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (char)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }

    @JsonCreator
    public CharData(@JsonProperty("val")Character val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = true;

        if((obj != null) && (obj.getClass().equals(this.getClass()))) {
            CharData castedObj = (CharData) obj;

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
