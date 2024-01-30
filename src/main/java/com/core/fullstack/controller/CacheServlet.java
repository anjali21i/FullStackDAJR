package com.core.fullstack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
