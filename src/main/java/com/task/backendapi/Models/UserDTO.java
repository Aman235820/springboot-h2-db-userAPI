package com.task.backendapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO implements Serializable {

    @JsonIgnore
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("maidenName")
    private String maidenName;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-M-d") // Handle single-digit months and days
    private Date birthDate;

    @JsonProperty("image")
    private String image;

    @JsonProperty("bloodGroup")
    private String bloodGroup;

    @JsonProperty("height")
    private double height;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("eyeColor")
    private String eyeColor;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("macAddress")
    private String macAddress;

    @JsonProperty("university")
    private String university;

    @JsonProperty("ein")
    private String ein;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("userAgent")
    private String userAgent;

    @JsonProperty("role")
    private String role;

    @JsonProperty("hair")
    private Hair hair;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("bank")
    private Bank bank;

    @JsonProperty("company")
    private Company company;

    @JsonProperty("crypto")
    private Crypto crypto;
}

@Data
class Hair {
    @JsonProperty("color")
    private String color;

    @JsonProperty("type")
    private String type;
}

@Data
class Address {
    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("stateCode")
    private String stateCode;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("coordinates")
    private Coordinates coordinates;
}

@Data
class Coordinates {
    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;
}

@Data
class Bank {
    @JsonProperty("cardExpire")
    private String cardExpire;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("cardType")
    private String cardType;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("iban")
    private String iban;
}

@Data
class Company {
    @JsonProperty("department")
    private String department;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("address")
    private Address address;
}

@Data
class Crypto {
    @JsonProperty("coin")
    private String coin;

    @JsonProperty("wallet")
    private String wallet;

    @JsonProperty("network")
    private String network;
}

