package com.example.TaassApiGateway.Model;

import java.io.Serializable;

public class UserAndData implements Serializable {

    private User userInformation;
    private UserData dataInformation;

    public UserAndData(User user, UserData userData){
        this.dataInformation = userData;
        this.userInformation = user;
    }



    public void setDataInformation(UserData dataInformation) {
        this.dataInformation = dataInformation;
    }

    public User getUserInformation() {
        return userInformation;
    }

    public UserData getDataInformation() {
        return dataInformation;
    }

    public void setUserInformation(User userInformation) {
        this.userInformation = userInformation;
    }

}
