package com.example.SecurityProject.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


           filterChain.doFilter(servletRequest ,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
