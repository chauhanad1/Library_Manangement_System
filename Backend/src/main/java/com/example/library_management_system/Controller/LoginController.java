package com.example.library_management_system.Controller;

import com.example.library_management_system.Entity.Users;
import com.example.library_management_system.ServiceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> loginJson) {
        String email = loginJson.get("email");
        String password = loginJson.get("password");
        if(email == null || password == null){
            return ResponseEntity.badRequest().body("Email or password is missing");
        }
        Users user = loginService.loginUser(email, password);
        if (user!=null) {
            return ResponseEntity.ok(user);  // You can return user object here instead of result
        } else {
            return ResponseEntity.status(400).body("Invalid email or password");
        }
    }
}