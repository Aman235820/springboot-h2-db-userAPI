package com.task.backendapi.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.backendapi.Entities.User;
import com.task.backendapi.Interface.UserService;
import com.task.backendapi.Models.UserDTO;
import com.task.backendapi.Models.UserResponse;
import com.task.backendapi.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Cacheable(key = "'allUsers'" , value = "UserData")
    public List<User> saveAllUsers(UserResponse userData) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ModelMapper modelMapper = new ModelMapper();



        List<User> users = userData.getUsers()
                .stream()
                .map(dto -> modelMapper.map(dto, User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(users);
        return users;

    }

    @Override
    // @Cacheable(key = "#role" , value = "RedisData")
    public List<User> getByRole(String role) {

        return userRepository.findAllByRole(role);

    }


    @Override
    //@Cacheable(key = "#id" , value = "RedisData")
    public Optional<User> findUserById(Long id) {

        return userRepository.findById(id);

    }


}
