package com.example.bayMax.Infrastructure;

import com.example.bayMax.Domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findUsersByUsername(username);

        if (users == null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException(username + "not found");
        }

        return users;
    }
    }

