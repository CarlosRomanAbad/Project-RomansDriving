package com.salesianostriana.edu.romansdriving.security;

import java.io.IOException;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Component
@Log
public class RoleBasedSuccessHandler 
	implements AuthenticationSuccessHandler {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					org.springframework.security.core.Authentication authentication)
					throws IOException, ServletException {
				authentication.getAuthorities();
				
			}


	}