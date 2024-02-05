package com.sign.config;

import com.sign.entity.JwtRequest;
import com.sign.entity.JwtResponse;
import com.sign.entity.User;
import com.sign.repo.UserDetailRepo;
import com.sign.security.JwtHelper;
import com.sign.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
//        try {
            doAuthenticate(request.getEmail(), request.getPassword());
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            String token = this.helper.generateToken(userDetails);

            JwtResponse response = JwtResponse
                    .builder()
                    .jwtToken(token)
                    .username(userDetails.getUsername())
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
//        }catch (BadCredentialsException e){
//            throw new RuntimeException("Invalid username or password");
//        }
    }

    private void doAuthenticate(String emil,String password){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(emil,password);
        try{
            manager.authenticate(authentication);
        }catch (BadCredentialsException e){
            throw new RuntimeException("Invaild username and password");
        }
    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public String exceptionHandler(){
//        return "Credentials Invalid !! ";
//    }

    @PostMapping("/create_user")
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);

    }



}
