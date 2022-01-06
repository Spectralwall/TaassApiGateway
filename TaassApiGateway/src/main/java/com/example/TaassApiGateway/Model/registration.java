package com.example.TaassApiGateway.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class registration implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("creationDate")
    private LocalDate creationDate;

    @JsonProperty("typeNameRegistration")
    private ArrayList<sourceDataInterface> typeNameRegistration;

    public registration(ArrayList<sourceDataInterface> val){
        this.creationDate = LocalDate.now();
        this.typeNameRegistration = val;
    }

    public registration(){}

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public ArrayList<sourceDataInterface> getTypeNameRegistration() {
        return typeNameRegistration;
    }

    public void setTypeNameRegistration(ArrayList<sourceDataInterface> typeNameRegistration) {
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
