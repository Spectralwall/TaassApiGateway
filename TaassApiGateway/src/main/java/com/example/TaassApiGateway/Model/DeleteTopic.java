package com.example.TaassApiGateway.Model;

public class DeleteTopic {
    private String id;

    private String name;

    private String newName;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public String toString() {
        return "deleteTopic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
