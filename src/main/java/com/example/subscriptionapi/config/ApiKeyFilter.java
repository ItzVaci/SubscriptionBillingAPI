package com.example.subscriptionapi.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {

    private static final String API_KEY_HEADER = "X-API-Key";
    private static final String VALID_API_KEY = "abc123XYZ";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        String path = httpReq.getRequestURI();


        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui") || path.startsWith("/swagger-ui.html") || path.startsWith("/swagger-ui-fixed.html")) {
            chain.doFilter(request, response);
            return;
        }


        String apiKey = httpReq.getHeader(API_KEY_HEADER);
        if (VALID_API_KEY.equals(apiKey)) {
            chain.doFilter(request, response);
        } else {
            httpRes.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing API Key");
        }
    }
}
