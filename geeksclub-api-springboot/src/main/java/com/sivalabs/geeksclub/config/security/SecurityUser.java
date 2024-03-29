package com.sivalabs.geeksclub.config.security;

import com.sivalabs.geeksclub.users.entities.User;
import java.util.Set;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@EqualsAndHashCode(callSuper = true)
public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private final User user;

    public SecurityUser(User user) {
        super(
                user.getEmail(),
                user.getPassword(),
                Set.of(new SimpleGrantedAuthority(user.getRole().name())));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
