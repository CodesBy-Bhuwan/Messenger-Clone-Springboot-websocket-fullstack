package com.messanger.messengerclone.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtTokenValidator extends OncePerRequestFilter{


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwt=request.getHeader("Authorization");

        if (jwt!=null){
            try {
//                Bearer toker which is not a exact token that we get
                jwt=jwt.substring(7);

                SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
                Claims claims=Jwts.perserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();


            } catch (Exception e){
//exception here
            }
        }
    }
}

