package com.task.backendapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;
    private String ip;
    private String macAddress;
    private String university;
    private String ein;
    private String ssn;
    private String userAgent;
    private String role;

    @Embedded
    private Hair hair;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "user_address")),
            @AttributeOverride(name = "city", column = @Column(name = "user_city")),
            @AttributeOverride(name = "state", column = @Column(name = "user_state")),
            @AttributeOverride(name = "stateCode", column = @Column(name = "user_stateCode")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "user_postalCode")),
            @AttributeOverride(name = "country", column = @Column(name = "user_country")),
            @AttributeOverride(name = "coordinates.lat", column = @Column(name = "user_lat")),
            @AttributeOverride(name = "coordinates.lng", column = @Column(name = "user_lng"))
    })
    private Address address;

    @Embedded
    private Bank bank;

    @Embedded
    private Company company;

    @Embedded
    private Crypto crypto;
}

@Embeddable
@Data
class Hair {
    private String color;
    private String type;
}

@Embeddable
@Data
class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private String country;

    @Embedded
    private Coordinates coordinates;
}

@Embeddable
@Data
class Coordinates {
    private double lat;
    private double lng;
}

@Embeddable
@Data
class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}

@Embeddable
@Data
class Company {
    private String department;
    private String name;
    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "company_address")),
            @AttributeOverride(name = "city", column = @Column(name = "company_city")),
            @AttributeOverride(name = "state", column = @Column(name = "company_state")),
            @AttributeOverride(name = "stateCode", column = @Column(name = "company_stateCode")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "company_postalCode")),
            @AttributeOverride(name = "country", column = @Column(name = "company_country")),
            @AttributeOverride(name = "coordinates.lat", column = @Column(name = "company_lat")),
            @AttributeOverride(name = "coordinates.lng", column = @Column(name = "company_lng"))
    })
    private Address address;
}

@Embeddable
@Data
class Crypto {
    private String coin;
    private String wallet;
    private String network;
}
