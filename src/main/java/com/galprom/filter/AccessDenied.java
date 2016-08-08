package com.galprom.filter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDenied implements AccessDeniedHandler {
    private String errorPage;

    public AccessDenied() {
    }

    public AccessDenied(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //some business logic
        response.sendRedirect(errorPage);

    }

}
