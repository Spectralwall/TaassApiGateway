package com.example.TaassApiGateway.Model.ClassicData;



import com.example.TaassApiGateway.Model.sourceDataInterface;
import java.io.Serializable;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class BooleanData implements sourceDataInterface, Serializable {

    private Boolean val;

    public BooleanData(boolean x){
        val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (Boolean)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
