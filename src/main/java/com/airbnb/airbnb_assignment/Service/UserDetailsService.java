package com.airbnb.airbnb_assignment.Service;

import com.airbnb.airbnb_assignment.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    public UserRepo userRepo;

    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
