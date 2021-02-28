package com.client.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.get.set.Endereco;
import com.google.gson.Gson;

public class JavaClientHttp {
	
	public static void main(String[] args) throws Exception {newEndereco();}
	
	static String API_URL = "https://viacep.com.br/ws/01001000/json/";
    static int ok = 200;
	
	public static Endereco newEndereco()throws Exception{
		
		try {
		
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(API_URL))
					.build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.statusCode() != ok) {
				throw new RuntimeException("HTTP error code : " + response.statusCode());
			}
			
			Gson gson = new Gson();
	        Endereco enderecos = gson.fromJson(response.body(), Endereco.class);
			
			System.out.println("client: "+client);
			System.out.println("-------------------------");
			
			System.out.println("request: "+request);
			System.out.println("-------------------------");
			
			System.out.println("Conexão Status: "+response.statusCode());
			
			System.out.println("response: "+ response);
			System.out.println("-------------------------");
			System.out.println("response body:"+response.body());
	        
	        System.out.println("-------------------------");
			System.out.println("enderecos: "+enderecos);
		
		return enderecos;
		
		}catch (Exception e) {
	        throw new Exception("ERRO: " + e);
	    }
	}
}