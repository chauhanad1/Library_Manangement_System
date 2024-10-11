package com.example.library_management_system.ServiceImpl;

import com.example.library_management_system.Entity.Users;
import com.example.library_management_system.Repository.UserRepository;
import com.example.library_management_system.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Users getUserbyID(int user_id) {
        return userRepository.findById(user_id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public void changeBorrowCount(int borrowed_book_count, int user_id) {
        userRepository.changeBorrowCount(borrowed_book_count,user_id);
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
}
