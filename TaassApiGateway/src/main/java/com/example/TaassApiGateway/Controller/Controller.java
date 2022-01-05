package com.example.TaassApiGateway.Controller;

import com.example.TaassApiGateway.Model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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
    public ResponseEntity<User> getPostsPlainJSON(@RequestBody User user) {
        System.out.println("Create a new user");
        String url = "http://localhost:8081/api/v1/users/create";

        ResponseEntity<User> response = this.restTemplate.postForEntity(url, user, User.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response;
        } else {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }


}
