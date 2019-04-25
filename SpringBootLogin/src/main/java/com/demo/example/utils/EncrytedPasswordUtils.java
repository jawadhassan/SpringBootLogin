package com.demo.example.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

	public static String encryptPassword(String password) {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	     return encoder.encode(password);
	}
	
	
	public static void main(String[] args) {
        String password = "123";
        String encrytedPassword = encryptPassword(password);
 
        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
