package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.http.JavaReqResHttp;
import com.get.set.Endereco;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String cep = "01001000";
        
        try {
	        	HttpResponse<String> res = JavaReqResHttp.newResponse(cep);
	        	String json = res.body();
	        	Endereco gson = JavaReqResHttp.convertGson(cep);
        	
	        try (PrintWriter out = response.getWriter()) {
	        	     	
	        	out.println("<!DOCTYPE html>");
	            out.println("<html><head>");
	            out.println("<title>Maven api</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h4> Request: " + res + "</h4>");
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