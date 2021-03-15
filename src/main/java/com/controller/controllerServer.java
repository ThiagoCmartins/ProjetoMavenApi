package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.NumberFormatException;

import com.clienthttp.JavaReqResHttp;
import com.getset.Endereco;

@WebServlet(name = "controller", urlPatterns = { "/controller" })
public class controllerServer extends HttpServlet {

	private static final long serialVersionUID = -6934454164476137642L;

	int validar;
	String cep;
	List<Endereco> cepDados;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			JavaReqResHttp jrrh = new JavaReqResHttp();
			try {
				cep = request.getParameter("cep");
				if (cep.trim().length() != 0) {

					
					validar = (Integer.parseInt(cep));
					
					cepDados = jrrh.listagem(cep);

					if (cepDados.isEmpty()) {
						request.setAttribute("mensagem", "Erro 400: [Cep não encontrado]");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} else {
						request.setAttribute("cepDados", cepDados);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("mensagem", "Erro: [Campo CEP Vazio]");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			} catch (NumberFormatException v) {
				request.setAttribute("mensagem", "Erro: [Didite apenas números] >> [" + v +"]");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}