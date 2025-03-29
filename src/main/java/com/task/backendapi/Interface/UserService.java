package com.task.backendapi.Interface;

import com.task.backendapi.Entities.User;
import com.task.backendapi.Exceptions.ResourceNotFoundException;
import com.task.backendapi.Models.UserResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> saveAllUsers(UserResponse userData) throws IOException;

    List<User> getByRole(String role);

    Optional<User> findUserById(Long id);
}
