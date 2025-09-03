package dev.vamsi.springsecurity.Controllers;

import dev.vamsi.springsecurity.Models.User;
import dev.vamsi.springsecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);//it will do 12 rounds of encoding

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }
}
