package com.example.library_management_system.ServiceImpl;


import com.example.library_management_system.Entity.Users;
import com.example.library_management_system.Repository.UserRepository;
import com.example.library_management_system.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users loginUser(String email, String password) {
        // Check if the user exists
        Optional<Users> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            // Compare the provided password with the stored password
            if (user.get().getPassword().equals(password)) {
                return user.get();  // You can return user details here as well
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}