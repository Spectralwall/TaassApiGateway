package com.example.TaassApiGateway.Model.ClassicData;



import com.example.TaassApiGateway.Model.sourceDataInterface;

import java.io.Serializable;

// classe pe trattare dati di tipo char
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class CharData implements sourceDataInterface, Serializable {

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
}
