package kz.iitu.taskrestphoenix.rest;

import kz.iitu.taskrestphoenix.dto.UserLoginDto;
import kz.iitu.taskrestphoenix.dto.UserRegisterDto;
import kz.iitu.taskrestphoenix.model.User;
import kz.iitu.taskrestphoenix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserRegisterDto userRegisterDto) {
        try {
            User checkUser = userService.findByUsername(userRegisterDto.getUsername());

            if (checkUser != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
            }

            if (!userRegisterDto.getPassword().equals(userRegisterDto.getPasswordConfirm())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passwords do not match");
            }


            User newUser = new User();
            newUser.setUsername(userRegisterDto.getUsername());
            newUser.setPassword(userRegisterDto.getPassword());
            newUser.setFio(userRegisterDto.getFio());
            newUser.setAvatarLink(userRegisterDto.getAvatarLink());

            userService.register(newUser);

            return ResponseEntity.ok("User registered successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserLoginDto userLoginDto) {
        try {
            String username = userLoginDto.getUsername();
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new Exception("User with username: " + username + " not found");
            }
            if (!user.getPassword().equals(userLoginDto.getPassword())) {
                throw new Exception("Invalid password");
            }
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("password", userLoginDto.getPassword());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    @PostMapping("test")
    public ResponseEntity test() {
        return ResponseEntity.ok("Test");
    }
}