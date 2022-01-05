package com.example.TaassApiGateway.Model;

import java.io.Serializable;

public class UserAndData implements Serializable {

    private User userInformation;
    private userData dataInformation;

    public UserAndData(User user, userData userData){
        this.dataInformation = userData;
        this.userInformation = user;
    }



    public void setDataInformation(userData dataInformation) {
        this.dataInformation = dataInformation;
    }

    public User getUserInformation() {
        return userInformation;
    }

    public userData getDataInformation() {
        return dataInformation;
    }

    public void setUserInformation(User userInformation) {
        this.userInformation = userInformation;
    }

}
