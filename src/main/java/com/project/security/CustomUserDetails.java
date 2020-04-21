package com.project.security;


import com.project.security.models.UserApp;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomUserDetails extends UserApp implements UserDetails {

    public CustomUserDetails(UserApp userApp) {
        super(userApp);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //todo - przyjrzeć się czy nie powinno byc this zamiast super this.getPassword()
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}