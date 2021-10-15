package com.revature.advice;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@WebFilter("/*")
public class CorsFilter extends GenericFilterBean {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse resp,
	                         FilterChain chain) throws IOException, ServletException {

	        HttpServletResponse response = (HttpServletResponse) resp;
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
	        //response.setHeader("Access-Control-Allow-Credentials", "true");
	        chain.doFilter(req, resp);
	    }
}