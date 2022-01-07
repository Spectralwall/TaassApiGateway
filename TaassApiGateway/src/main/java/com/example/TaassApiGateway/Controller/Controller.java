package com.example.TaassApiGateway.Controller;

import com.example.TaassApiGateway.Model.*;
import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

//da scrivere
//TODO metodo di delete



@RestController
@RequestMapping("/gateway")
public class Controller {

    private final RestTemplate restTemplate;

    public Controller(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping(value = "/all")
    public ArrayList getAllUser() {
        System.out.println("Prende tutti gli utenti");
        String url = "http://microserviceuser:8081/api/v1/users";
        return this.restTemplate.getForObject(url, ArrayList.class);
    }


    /*
     *  questa verra chiamata alla creazione di un utente sul sito
     *  crea l'utente sul primo microservizio e crea i suoi dati sull'altro daatabase
     */
    @PostMapping(value = "/create")
    public ResponseEntity<UserAndData> createUserData(@RequestBody User user) {
        System.out.println("Create a new user");
        String url = "http://microserviceuser:8081/api/v1/users/create";

        ResponseEntity<User> response1 = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        System.out.println("Create Document");

        String url2 = "http://microservicedata:8082/api/v2/data/newuser";
        ResponseEntity<userData> response2 = this.restTemplate.postForEntity(url2, new userData(String.valueOf(response1.getBody().getId())), userData.class);

        System.out.println("RESPONSE 1");
        System.out.println(response1);
        System.out.println(response1.getBody());

        System.out.println("RESPONSE 2");
        System.out.println(response2);
        System.out.println(response2.getBody());

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.OK);
    }

    @PostMapping(value = "/createGoogle")
    public ResponseEntity<UserAndData> createUserDataGoogle(@RequestBody User user) {
        System.out.println("Create a new user");
        String url = "http://microserviceuser:8081/api/v1/users/createGoogle";

        ResponseEntity<User> response1 = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        System.out.println("Create Document");

        String url2 = "http://microservicedata:8082/api/v2/data/newuser";
        ResponseEntity<userData> response2 = this.restTemplate.postForEntity(url2, new userData(String.valueOf(response1.getBody().getId())), userData.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUserData(@RequestBody User user) {

        System.out.println("Login user");
        String url = "http://microserviceuser:8081/api/v1/users/login";

        ResponseEntity<User> response1 = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        System.out.println("User Loged :" + response1.getBody());

        System.out.println("Get Document for id :" + String.valueOf(response1.getBody().getId()));

        String url2 = "http://microservicedata:8082/api/v2/data/document";
        ResponseEntity<String> response2 = this.restTemplate.postForEntity(url2, response1.getBody(), String.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response2.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/loginGoogle")
    public ResponseEntity<String> loginUserDataGoogle(@RequestBody User user) {

        System.out.println("Login Google user");
        String url = "http://microserviceuser:8081/api/v1/users/loginGoogle";

        ResponseEntity<User> response1 = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        System.out.println("User Loged :" + response1.getBody());

        System.out.println("Get Document for id :" + String.valueOf(response1.getBody().getId()));

        String url2 = "http://microservicedata:8082/api/v2/data/document";
        ResponseEntity<String> response2 = this.restTemplate.postForEntity(url2, response1.getBody(), String.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response2.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody UserModifier userModifier) {

        System.out.println("Cambio Password");
        String url = "http://microserviceuser:8081/api/v1/users/changePassword";

        ResponseEntity<UserModifier> response = this.restTemplate.postForEntity(url,userModifier, UserModifier.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("password changed", HttpStatus.OK);
    }

    @PostMapping(value = "/newTopic")
    public ResponseEntity<userData> newTopics(@RequestBody newTopic newTopic) {

        System.out.println("Nuovo Topic");
        String url = "http://microservicedata:8082/api/v2/data/newTopic";

        ResponseEntity<userData> response = this.restTemplate.postForEntity(url,newTopic, userData.class);

        System.out.println("RESPONSE");
        System.out.println(response);
        System.out.println(response.getBody());

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<userData>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/topicUser")
    public ResponseEntity<userData> topicUser(@RequestBody userData user) {

        System.out.println("Ritorno topic");
        String url = "http://microservicedata:8082/api/v2/data/topics";

        return this.restTemplate.postForEntity(url,user, userData.class);
    }

    @PostMapping(value = "/newReg")
    public ResponseEntity<userData> newReg(@RequestBody newRegistration newReg) {

        System.out.println("Nuova Registrazione : " + newReg);
        String url = "http://microservicedata:8082/api/v2/data/newRegi";

        ResponseEntity<userData> response = this.restTemplate.postForEntity(url,newReg, userData.class);

        System.out.println("user data : " + response.getBody());

        System.out.println("RESPONSE");
        System.out.println(response);
        System.out.println(response.getBody());

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/delReg")
    public ResponseEntity<String> deleteRegsitration(@RequestBody deleteReg deleteReg) {

        System.out.println("Cancello Registrazione : " + deleteReg);
        String url = "http://microservicedata:8082/api/v2/data/deleteReg";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,deleteReg, String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/delTopic")
    public ResponseEntity<String> deleteTopic(@RequestBody deleteTopic delete) {

        System.out.println("Cancello Topic : " + delete);
        String url = "http://microservicedata:8082/api/v2/data/deleteTopic";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,delete, String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/sharedTopic")
    public ResponseEntity<String> sharedTopic() {

        System.out.println("ritorno i topic Condivisi ");
        String url = "http://microservicedata:8082/api/v2/data/sharedTopic";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,null ,String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/changSharedTopic")
    public ResponseEntity<String> changSharedTopic(@RequestBody deleteTopic delete) {

        System.out.println("modifico condivisione del topic " + delete.getName() + " dell'utente :" + delete.getId());
        String url = "http://microservicedata:8082/api/v2/data/changSharedTopic";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,delete, String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/changeNameTopic")
    public ResponseEntity<String> changeNameTopic(@RequestBody deleteTopic delete) {

        System.out.println("modifico nome del topic " + delete.getName() + " dell'utente :" + delete.getId());
        String url = "http://microservicedata:8082/api/v2/data/changeNameTopic";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,delete, String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteAll(@RequestBody User user) {

        System.out.println("Delete user :" + user.getEmail());
        String url = "http://microserviceuser:8081/api/v1/users/deleteUser";

        ResponseEntity<String> response1 = this.restTemplate.postForEntity(url, user, String.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>("problema micro servizio utente", HttpStatus.CONFLICT);
        }


        System.out.println("eliminazione dati per utente : " + user.getEmail());
        String url2 = "http://microservicedata:8082/api/v2/data/deleteUser";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url2,user, String.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>("problema micro servizio dati", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("eliminazione utente e dati corretta ", HttpStatus.OK);
    }

}
