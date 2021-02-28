package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.http.JavaClientHttp;

public class controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        try {
        	
        	 JavaClientHttp.newEndereco();
        	
	        request.setAttribute("listaEndereco", JavaClientHttp.newEndereco());
	        request.getRequestDispatcher("inicial.jsp").forward(request, response);
        
        }catch (Exception e) {
            new Exception("ERRO: " + e);
        }
	}
}