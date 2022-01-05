package com.example.TaassApiGateway.Model;

/*
 * Classe cher sara il documento che viene salvato su mongo DB
 * abbiamo diversi dati
 * un id
 * un id relativo all'utente
 * e la lista dei topic
 */


import java.io.Serializable;
import java.util.ArrayList;


public class userData implements Serializable {


    private String id;

    private String idUser;

    private ArrayList<topic> topicList;

    public userData(String Userid){
        this.idUser = Userid;
        this.topicList = new ArrayList<>();
    }

    public userData(String idUser, ArrayList<topic> topic){
        this.idUser = idUser;
        this.topicList = topic;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setTopicList(ArrayList<topic> topicList) {
        this.topicList = topicList;
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public ArrayList<topic> getTopicList() {
        return topicList;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", idUser=" + idUser +
                ", topicList =" + topicList +
                '}';
    }


}

