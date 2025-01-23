package com.BookMyShow.BookMyShow.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class headerValidationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("X-User-Id");
        String roles = request.getHeader("X-User-Roles");

        if (userId == null || roles == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }
        if (request.getRequestURI().contains("/Admin")) {
            if (roles!="Admin") {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: Admin role required");
                return false; // User does not have admin role
            }
        } else if (request.getRequestURI().contains("/booking")) {
            if (roles!="User") {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: User role required");
                return false; // User does not have user role
            }
        }
        return true;
    }
}