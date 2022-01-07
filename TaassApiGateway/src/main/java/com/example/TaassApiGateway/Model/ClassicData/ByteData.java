package com.example.TaassApiGateway.Model.ClassicData;





import com.example.TaassApiGateway.Model.SourceDataInterface;

import java.io.Serializable;

// classe pe trattare dati di tipo Byte

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ByteData implements SourceDataInterface, Serializable {

    private Byte val;

    public ByteData(byte x){
        this.val = x;
    }

    @Override
    public Object getData() {
        return val;
    }

    @Override
    public void setData(Object val) {
        this.val = (byte)val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
