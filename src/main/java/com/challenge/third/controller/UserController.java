package com.challenge.third.controller;

import com.challenge.third.JwtAuthorizationFilter;
import com.challenge.third.model.User;
import com.challenge.third.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ArrayList<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("login")
    public Object login(@RequestParam String nickname, @RequestParam String password) {
        User user = userService.login(nickname, password);
        return user == null ? null : userAuthorization(user);
    }

    @PostMapping
    public Object save(@RequestBody User user) {
        return userAuthorization(userService.save(user));
    }

    private Object userAuthorization(User user) {
        return new Object() {
            
            public User getUser() {
                return user;
            }

            public String getToken() {
                long currentTimeMillis = System.currentTimeMillis();
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_USER");
                return JwtAuthorizationFilter.PREFIX + Jwts
                        .builder()
                        .setId(currentTimeMillis + ":" + user.getId())
                        .setSubject(user.getNickname())
                        .claim("authorities", grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                        .setIssuedAt(new Date(currentTimeMillis))
                        .setExpiration(new Date(currentTimeMillis + 600000))
                        .signWith(SignatureAlgorithm.HS512,
                                JwtAuthorizationFilter.KEY.getBytes()).compact();
            }
            
        };
    }

}
