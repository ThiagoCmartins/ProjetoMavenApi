package com.java.test;

import static org.junit.Assert.assertTrue;

import java.net.http.HttpResponse;
import org.junit.Test;

import com.clienthttp.JavaReqResHttp;
import com.getset.Endereco;

public class testjava {
	
	
	static String cep = "01001000";
	
	@Test
	public void primeiroTeste() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		HttpResponse<String> res = jrrh.newResponse(cep);
		
		if(res != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
	}
	
	@Test
	public void segundoTeste() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		HttpResponse<String> res = jrrh.newResponse(cep);
		int ok = 200;
		
		if(res.statusCode() == ok) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}		
	}
	
	@Test
	public void terceroTeste() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		HttpResponse<String> res = jrrh.newResponse(cep);
		
		if(res.body() != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}		
	}
	
	@Test
	public void quartoTeste() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		Endereco gson = jrrh.convertGson(cep);
		
		if(gson != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}		
	}
	
}