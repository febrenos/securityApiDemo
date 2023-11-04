package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    // Outros campos e métodos

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CustomGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new CustomGrantedAuthority(role.name()));
        }
        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implemente a lógica apropriada aqui
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implemente a lógica apropriada aqui
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implemente a lógica apropriada aqui
    }

    @Override
    public boolean isEnabled() {
        return true; // Implemente a lógica apropriada aqui
    }
}
