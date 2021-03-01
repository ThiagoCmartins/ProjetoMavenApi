package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.http.JavaClientHttp;
import com.get.set.Endereco;

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public controller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
       
        String cep = "01001000";

        try (PrintWriter out = response.getWriter()) {
        	
        	Endereco enderco = JavaClientHttp.newEndereco(cep);
     
            out.println("<p>" + enderco + "<p>");
      
        } catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}