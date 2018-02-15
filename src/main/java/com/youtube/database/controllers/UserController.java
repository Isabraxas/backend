package com.youtube.database.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.database.model.User;
import com.youtube.database.service.UserService;
import com.youtube.database.util.QueryResult;
import com.youtube.database.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @RequestMapping(value = "/getUsers", method=RequestMethod.GET)
    public List<User> getUsers(){
        return this.userService.findAll();
    }

    @RequestMapping(value="/deleteUser", method = RequestMethod.POST)
    public void deleteUser(@RequestBody String userJson) throws Exception {
        this.mapper= new ObjectMapper();
        User user= this.mapper.readValue(userJson, User.class);

        if(user.getId() == null){
            throw new Exception("El usuario esta nulo");
        }

        this.userService.deleteUser(user.getId());
    }

    @RequestMapping(value = "/deleteUserById/{id}", method=RequestMethod.GET)
    public List<User> deleteUserById(@PathVariable Long id){
        this.userService.deleteUserById(id);
        return this.userService.findAll();
    }

    @RequestMapping(value = "/getByName/{name}", method=RequestMethod.GET)
    public List<User> getByName(@PathVariable String name){
        return this.userService.findByName(name);
    }

    public boolean validate(User user){
        boolean isValid =true;

        if(user.getFirstName() == null || user.getFirstName() == ""){
            isValid=false;
        }

    if(StringUtils.trimToNull(user.getFirstSurname()) == null){
            isValid=false;
        }

        if(StringUtils.trimToNull(user.getAddress()) == null){
            isValid=false;
        }

        return isValid;
    }
}
