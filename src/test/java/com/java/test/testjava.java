package com.java.test;

import static org.junit.Assert.assertTrue;

import java.net.http.HttpResponse;
import java.util.List;

import org.junit.Test;

import com.clienthttp.JavaReqResHttp;
import com.getset.Endereco;

public class testjava {
	
	
	static String cep = "01001000";
	
	@Test
	public void TestRes() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		HttpResponse<String> res = jrrh.newResponse(cep);
		
		if(res != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
	}
	
	@Test
	public void TestStatusCode() throws Exception {
		
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
	public void TestResp() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		HttpResponse<String> resp = jrrh.newResponse(cep);
		
		if(resp.body() != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}		
	}
	
	@Test
	public void TesteList() throws Exception {
		
		JavaReqResHttp jrrh = new JavaReqResHttp();
		List<Endereco> list;
		
		list = jrrh.listagem(cep);
		
		if(list != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}		
	}
	
}