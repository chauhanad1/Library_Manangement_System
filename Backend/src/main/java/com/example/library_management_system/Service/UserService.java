package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Users;
import org.apache.catalina.User;

public interface UserService {
    Users getUserbyID(int user_id);
    void changeBorrowCount(int borrowed_book_count, int user_id);
    Users saveUser(Users user);
}
