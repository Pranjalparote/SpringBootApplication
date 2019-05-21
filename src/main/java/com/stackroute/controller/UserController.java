package com.stackroute.controller;


import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@controller+response body annotation. returns data as json
@RequestMapping(value="api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch (UserAlreadyExistsException a){
            responseEntity=new ResponseEntity<String>(a.getMessage(), HttpStatus.CONFLICT);
            a.printStackTrace();
        }
        return  responseEntity; // status codes+http+response body
    }

    @GetMapping("user")
    public  ResponseEntity<?> getAllUsers(){
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }


}