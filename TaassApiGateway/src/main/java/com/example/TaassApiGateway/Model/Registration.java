package com.example.TaassApiGateway.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Registration implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty("creationDate")
    private LocalDate creationDate;

    @JsonProperty("typeNameRegistration")
    private ArrayList<TypeNameReg<?>> typeNameRegistration;

    public Registration(){
        super();
    }

    public Registration(ArrayList<TypeNameReg<?>> val){
        this.creationDate = LocalDate.now();
        this.typeNameRegistration = val;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public ArrayList<TypeNameReg<?>> getTypeNameRegistration() {
        return typeNameRegistration;
    }

    public void setTypeNameRegistration(ArrayList<TypeNameReg<?>> typeNameRegistration) {
        this.typeNameRegistration = typeNameRegistration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "registration{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", typeNameRegistration=" + typeNameRegistration +
                '}';
    }
}
