package com.core.fullstack.controller;

import java.io.PrintWriter;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CacheServlet {

  @RequestMapping(value = "/cachedServlet", method = RequestMethod.GET)
	public HttpServletResponse getcachedServlet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			log.info("inside getcachedServlet controller:: {}", request);
			response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        // Get the current date and time
	        Date currentDate = new Date();

	        // Check if the client has a cached version and is making a conditional request
	        String ifModifiedSince = request.getHeader("If-Modified-Since");

	        if (ifModifiedSince != null) {
	            long ifModifiedSinceTime = Long.parseLong(ifModifiedSince);

	            // If the client's cached version is still valid, send a 304 Not Modified response
	            if (currentDate.getTime() <= ifModifiedSinceTime) {
	                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
	                return response;
	            }
	        }

	        // Set the last-modified header to the current date
	        response.setDateHeader("Last-Modified", currentDate.getTime());

	        // Set cache control headers to instruct browsers and proxies
	        response.setHeader("Cache-Control", "public, max-age=60"); // Cache for 60 seconds
	        response.setHeader("Expires", new Date(currentDate.getTime() + 60000).toString()); // Expire after 60 seconds

	        // Business logic: Generate a simple HTML response with the current date
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<h2>Current Date and Time: " + currentDate + "</h2>");
	        out.println("</body></html>");
		} catch (Exception e) {
			log.error("error in fetching cache", e);
		}
		return null;
  }
}
