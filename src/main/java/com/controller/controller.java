package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clienthttp.JavaReqResHttp;
import com.getset.Endereco;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String cep;
        
        try {
	        	HttpResponse<String> res;
	        	String json;
	        	Endereco gson;
        	
	        try (PrintWriter out = response.getWriter()) {
	        	     	
	        	out.println("<!DOCTYPE html>");
	            out.println("<html><head>");
	            out.println("<title>Maven API</title>");            
	            out.println("</head><body>"); 
	            
	            cep = request.getParameter("cep");
	            res = JavaReqResHttp.newResponse(cep);
	            json = res.body();
	            gson = JavaReqResHttp.convertGson(cep);
	            
	            out.println("<h4> Request: " + res  + "</h4>");
		        out.println("<h4> Response: " + json + "</h4>");
		        out.println("<h4> Convert: " + gson + "</h4>");
		        
	            out.println("</body></html>");
      
        }} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

}}