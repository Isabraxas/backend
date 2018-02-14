package com.youtube.database.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.database.model.User;
import com.youtube.database.service.UserService;
import com.youtube.database.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    protected UserService userService;

    protected ObjectMapper mapper;

    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson)
                throws  IOException {
        this.mapper = new ObjectMapper();
        User user= this.mapper.readValue(userJson, User.class);

        if (!validate(user)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value()," Los campos no estan diligenciados");
        }
        this.userService.save(user);

        return new RestResponse(HttpStatus.OK.value(),"Operacion exitosa");
    }

    public boolean validate(User user){
        boolean isValid =true;

        if(user.getFirstName() == null){
            isValid=false;
        }

        if(user.getFirstSurname() == null){
            isValid=false;
        }

        if(user.getAddress() == null){
            isValid=false;
        }

        return isValid;
    }
}
