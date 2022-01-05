package com.example.TaassApiGateway.Controller;

import com.example.TaassApiGateway.Model.User;
import com.example.TaassApiGateway.Model.UserAndData;
import com.example.TaassApiGateway.Model.userData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

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
        String url = "http://localhost:8081/api/v1/users";
        return this.restTemplate.getForObject(url, ArrayList.class);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserAndData> createUserData(@RequestBody User user) {
        System.out.println("Create a new user");
        String url = "http://localhost:8081/api/v1/users/create";

        ResponseEntity<User> response1 = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response1.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        String url2 = "http://localhost:8082/api/v2/data/newuser";
        ResponseEntity<userData> response2 = this.restTemplate.postForEntity(url2, new userData(String.valueOf(response1.getBody().getId())), userData.class);

        // check response status code
        if (response2.getStatusCode() == HttpStatus.CONFLICT) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        UserAndData userAndData = new UserAndData(response1.getBody(),response2.getBody());

        return new ResponseEntity<>(userAndData, HttpStatus.CONFLICT);



    }



}
