package com.niit.FavouriteMovieService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authHeader= request.getHeader("Authorization");

        if (authHeader==null || !authHeader.startsWith("Bearer")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            servletOutputStream.println("Invalid or Missing Token");
        }
        else{
            String token=authHeader.substring(7);
            Claims claims= Jwts.parser().setSigningKey("teamsecrectkey").parseClaimsJws(token).getBody();
            request.setAttribute("claims",claims);
            filterChain.doFilter(request, response);
        }
    }
}
