package com.sign.RestController;

import com.sign.entity.User;
import com.sign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getUser(){
        List<User>  userlist = userService.getAllUser();
        System.err.println("getting users");
        return userlist;
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

    @GetMapping("/abc")
    public String abc(HttpRequest request, HttpResponse response){
        Map<Long,String> myMap = new HashMap<>();
        myMap.put(1l,"abc");
        myMap.put(2l,"xyz");
        System.err.println(myMap);
        return "Gaurav";
    }
}
//