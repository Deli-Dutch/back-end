package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.User;
import com.cokothon.DeliDutch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
