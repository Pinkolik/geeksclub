package com.sivalabs.geeksclub.config.security;

import com.sivalabs.geeksclub.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userService
                .getUserByEmail(username)
                .map(SecurityUser::new)
                .orElseThrow(
                        () ->
                                new UsernameNotFoundException(
                                        "No user found with username " + username));
    }
}
