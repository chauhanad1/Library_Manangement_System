package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Users;

public interface LoginService {
    public Users loginUser(String email, String password);
}
