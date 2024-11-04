package com.example.fullstack.controller;

import com.example.fullstack.exception.UserNotFoundException;
import com.example.fullstack.model.Users;
import com.example.fullstack.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @PostMapping("/Users")
    Users newUser(@RequestBody Users newUser){
        return userRespository.save(newUser);
    }
    @GetMapping("/getUsers")
    List<Users> getAllUser(){
        return userRespository.findAll();
    }

    @GetMapping("/getUser/{id}")
    Users getuserId(@PathVariable Long id){
        return userRespository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/updateUser/{id}")
    Users updateUser(@RequestBody Users newUser , @PathVariable Long id) {
        return userRespository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            return userRespository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }
    @DeleteMapping("/deleteUser/{id}")
    String delteUser(@PathVariable Long id){
        if(!userRespository.existsById(id)){
                throw new UserNotFoundException(id);
        }
        userRespository.deleteById(id);
        return "User with id " +id+ " has been delete success";
    }
}
