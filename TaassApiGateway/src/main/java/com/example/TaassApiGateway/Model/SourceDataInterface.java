package com.example.TaassApiGateway.Model;

import com.example.TaassApiGateway.Model.ClassicData.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanData.class, name = "BooleanData"),
        @JsonSubTypes.Type(value = ByteData.class, name = "ByteData"),
        @JsonSubTypes.Type(value = CharData.class, name = "CharData"),
        @JsonSubTypes.Type(value = DoubleData.class, name = "DoubleData"),
        @JsonSubTypes.Type(value = FloatData.class, name = "FloatData"),
        @JsonSubTypes.Type(value = IntegerData.class, name = "IntegerData"),
        @JsonSubTypes.Type(value = LongData.class, name = "LongData"),
        @JsonSubTypes.Type(value = ShortData.class, name = "ShortData"),
        @JsonSubTypes.Type(value = StringData.class, name = "StringData")
})
public interface SourceDataInterface<T> extends Serializable {
    abstract T getData();
    abstract void setData(T val);
}
