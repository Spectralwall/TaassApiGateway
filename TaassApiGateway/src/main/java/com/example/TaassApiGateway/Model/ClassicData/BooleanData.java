package com.example.TaassApiGateway.Model.ClassicData;



import com.example.TaassApiGateway.Model.SourceDataInterface;
import java.io.Serializable;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class BooleanData implements SourceDataInterface, Serializable {

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
