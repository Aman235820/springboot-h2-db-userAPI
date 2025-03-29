package com.task.backendapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.io.Serializable;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)  //include empty fields
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse implements Serializable {
    @JsonProperty("users")   //maps the actual name in json
    private List<UserDTO> users;  // This should match the API response field

    @JsonProperty("total")
    private int total;

    @JsonProperty("skip")
    private int skip;

    @JsonProperty("limit")
    private int limit;

    public List<UserDTO> getUsers(){
        return users;
    }

}
