package com.clienthttp;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.getset.Endereco;
import com.google.gson.Gson;

public class JavaReqResHttp implements Serializable {	

	private static final long serialVersionUID = 474087116905787177L;
	static String API_URL = "https://viacep.com.br/ws/";
	
	public HttpResponse<String> newResponse(String cep) throws Exception {
		
		try {
			
			String Chamada = API_URL + cep + "/json";
		
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(Chamada))
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println("-------------------------");
			System.out.println("client: "+client);
			System.out.println("-------------------------");
			System.out.println("request: "+ response);
			System.out.println("Conexão Status: "+response.statusCode());
			
			System.out.println("-------------------------");
			System.out.println("response body:" + response.body());
			
			
			return response;
			
		}catch (Exception e) {
	        throw new Exception("ERRO [newResponse]: " + e);
	    }
	}
	
	public Endereco convertGson(String cep) throws Exception{
		
		Gson gson = new Gson();		
		HttpResponse<String> res;
		JavaReqResHttp jrrh = new JavaReqResHttp();
		
		try {
		
		res = jrrh.newResponse(cep);			
		Endereco enderecos = gson.fromJson(res.body() , Endereco.class);
		
		System.out.println("request: "+ res);
		System.out.println("Conexão Status: "+res.statusCode());
		
		System.out.println("-------------------------");
		System.out.println("response body:"+res.body());
		
		System.out.println("-------------------------");
		System.out.println("enderecos: "+enderecos);
		        
		return enderecos;
		
		}catch(Exception e) {
			throw new Exception("ERRO [convertGson]: " + e);
		}
			
	}
}