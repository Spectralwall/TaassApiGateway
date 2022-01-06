package com.example.TaassApiGateway.Controller;

import com.example.TaassApiGateway.Model.*;
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

//TODO metodo di delete
//TODO metodo per creare una nuova registrazione
//TODO metodo per cancellare una registrazione
//TODO metodo per cancellare un topic
//TODO metodo modificre share topic
//TODO metodo modificre ritornare gli share topic
//TODO metodo modificre nome topic


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

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.CONFLICT);
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

        return new ResponseEntity<>(userAndData, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserAndData> loginUserData(@RequestBody User user) {

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
        ResponseEntity<userData> response2 = this.restTemplate.postForEntity(url2, new userData(String.valueOf(response1.getBody().getId())), userData.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/loginGoogle")
    public ResponseEntity<UserAndData> loginUserDataGoogle(@RequestBody User user) {

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
        ResponseEntity<userData> response2 = this.restTemplate.postForEntity(url2, new userData(String.valueOf(response1.getBody().getId())), userData.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.CONFLICT);
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
    public ResponseEntity<String> newTopics(@RequestBody newTopic newTopic) {

        System.out.println("Nuovo Topic");
        String url = "http://microservicedata:8082/api/v2/data/newTopic";

        ResponseEntity<newTopic> response = this.restTemplate.postForEntity(url,newTopic, newTopic.class);

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>("name of topic taken", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("topic add", HttpStatus.OK);
    }

    @PostMapping(value = "/topicUser")
    public ResponseEntity<String> topicUser(@RequestBody userData user) {

        System.out.println("Ritorno topic");
        String url = "http://microservicedata:8082/api/v2/data/topics";

        return this.restTemplate.postForEntity(url,user, String.class);
    }

    @PostMapping(value = "/newReg")
    public ResponseEntity<String> newTopics(@RequestBody newRegistration newReg) {

        System.out.println("Nuova Registrazione : " + newReg);
        String url = "http://microservicedata:8082/api/v2/data/newRegi";

        ResponseEntity<String> response = this.restTemplate.postForEntity(url,newReg, String.class);

        System.out.println("user data : " + response.getBody());

        if (response.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}
