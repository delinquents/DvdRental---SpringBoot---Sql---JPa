package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.model.Role;
import com.example.demo.security.model.RoleName;
import com.example.demo.security.model.User;
import com.example.demo.security.repository.RoleRepository;
import com.example.demo.security.repository.UserRepository;
import com.example.demo.security.request.LoginForm;
import com.example.demo.security.request.SignUpForm;
import com.example.demo.security.response.JwtResponse;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dvd-rental/auth")
public class AuthenticationRestController {
	
	
	 @Autowired
	    AuthenticationManager authenticationManager;
	 
	    @Autowired
	    UserRepository userRepository;
	 
	    @Autowired
	    RoleRepository roleRepository;
	 
	    @Autowired
	    PasswordEncoder encoder;
	 
	    @Autowired
	    JwtProvider jwtProvider;
	 
	    @PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
	 
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );
	 
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	 
	        String jwt = jwtProvider.generateJwtToken(authentication);
	        return ResponseEntity.ok(new JwtResponse(jwt));
	    }
	 
	    @PostMapping("/signup")
	    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
	        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
	            return new ResponseEntity<String>("Fail -> Username is already taken!",
	                    HttpStatus.BAD_REQUEST);
	        }
	 
	        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
	            return new ResponseEntity<String>("Fail -> Email is already in use!",
	                    HttpStatus.BAD_REQUEST);
	        }
	 
	        // Creating user's account
	        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
	                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
	 
	        Set<String> strRoles = signUpRequest.getRole();
	        Set<Role> roles = new HashSet<>();
	 
	        strRoles.forEach(role -> {
	          switch(role) {
	          case "admin":
	            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            roles.add(adminRole);
	            
	            break;
	          case "pm":
	                Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	                roles.add(pmRole);
	                
	            break;
	          default:
	              Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	              roles.add(userRole);              
	          }
	        });
	        
	        user.setRoles(roles);
	        userRepository.save(user);
	 
	        return ResponseEntity.ok().body("User registered successfully!");
	    }
	
	
	

}
