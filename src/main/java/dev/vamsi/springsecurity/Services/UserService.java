package dev.vamsi.springsecurity.Services;

import dev.vamsi.springsecurity.Models.User;
import dev.vamsi.springsecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }
}
