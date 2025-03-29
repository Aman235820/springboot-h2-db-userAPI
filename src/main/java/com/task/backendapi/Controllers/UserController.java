package com.task.backendapi.Controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.task.backendapi.Entities.User;
import com.task.backendapi.Interface.UserService;
import com.task.backendapi.Models.ResponseDTO;
import com.task.backendapi.Models.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json")
public class UserController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/healthCheck")
    public String Healthcheck() {
        return "Health check OK";
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<ResponseDTO> GetAllUsers() {

        try {
            String url = "https://dummyjson.com/users";

            String data = webClientBuilder.build()
                    .get()
                    .uri(url)
                    .header("Accept", "application/json")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            UserResponse person = objectMapper.readValue(data, UserResponse.class);

            Object p = userService.saveAllUsers(person);

            return new ResponseEntity<>(new ResponseDTO(p, "Successfully Fetched", false), HttpStatus.OK);

        } catch (Exception ce) {
            return new ResponseEntity<>(new ResponseDTO(null, ce.toString(), true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAllUsersWithRole")
    public ResponseEntity<ResponseDTO> getAllUsersWithRole(@RequestParam String role) {

        try {
            List<User> users = userService.getByRole(role);
            return new ResponseEntity<>(new ResponseDTO(users, "Successfully Fetched", false), HttpStatus.OK);
        } catch (Exception ce) {
            return new ResponseEntity<>(new ResponseDTO(null, ce.getMessage(), true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getUserbyId")
    public ResponseEntity<ResponseDTO> getAllUsersWithRole(@RequestParam Long id) {

        try {
            Optional<User> user = userService.findUserById(id);
            return new ResponseEntity<>(new ResponseDTO(user, "Successfully Fetched", false), HttpStatus.OK);
        } catch (Exception ce) {
            return new ResponseEntity<>(new ResponseDTO(null, ce.getMessage(), true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
