package com.example.streamingdienst.service;

import com.example.streamingdienst.model.User;
import com.example.streamingdienst.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void SaveUser(User user){userRepo.save(user);}

}
