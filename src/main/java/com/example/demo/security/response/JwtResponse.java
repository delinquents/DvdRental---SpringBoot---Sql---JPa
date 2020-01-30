package com.example.demo.security.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
public class JwtResponse {

	
	private String token;
    private String type = "Bearer";
    
    
    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }
}
