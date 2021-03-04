package com.client.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.get.set.Endereco;
import com.google.gson.Gson;

public class JavaReqResHttp {
	
	//public static void main(String[] args) throws Exception {String cep = "01001000"; newResponse(cep); convertGson(cep);}
	
	static String API_URL = "https://viacep.com.br/ws/";
	static int ok = 200;
	
	public static HttpResponse<String> newResponse(String cep) throws Exception {
		
		try {
			
			String Chamada = API_URL + cep + "/json";
		
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(Chamada))
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.statusCode() != ok) {
				throw new RuntimeException("HTTP error code : " + response.statusCode());
				}
			
			System.out.println("-------------------------");
			System.out.println("client: "+client);
			System.out.println("-------------------------");
			
			System.out.println("request: "+request);
			System.out.println("-------------------------");
			
			System.out.println("response: "+ response);
			System.out.println("Conexão Status: "+response.statusCode());
			
			System.out.println("-------------------------");
			System.out.println("response body:"+response.body());
			
			return response;
			
		}catch (Exception e) {
	        throw new Exception("ERRO [newResponse]: " + e);
	    }
	}
	
	public static Endereco convertGson(String cep) throws Exception{
		
		Gson gson = new Gson();		
		HttpResponse<String> res;
		
		try {
		
		res = JavaReqResHttp.newResponse(cep);
						
		Endereco enderecos = gson.fromJson(res.body() , Endereco.class);
		
		System.out.println("-------------------------");
		System.out.println("enderecos: "+enderecos);
		        
		return enderecos;
		
		}catch(Exception e) {
			throw new Exception("ERRO [convertGson]: " + e);
		}
			
	}
}