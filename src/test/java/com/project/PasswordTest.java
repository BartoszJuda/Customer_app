package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {

   // @Test
    // public void getPasswordHash() {
       // PasswordEncoder pass = new BCryptPasswordEncoder();
          // System.out.println(pass.encode("user"));
   // }
   @Test
           public void getPasswordHash() {
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String password = "password";
       String encodedPassword = passwordEncoder.encode(password);

       System.out.println();
       System.out.println("Password is         : " + password);
       System.out.println("Encoded Password is : " + encodedPassword);
       System.out.println();


       boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
       System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
   }

}
