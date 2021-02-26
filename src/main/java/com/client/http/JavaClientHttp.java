package com.client.http;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.get.set.Endereco;

public class JavaClientHttp {
	
	private static final String APP_URL_CEP = "https://viacep.com.br/ws/01001000/json/";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		
		System.out.println("client: "+client);
		System.out.println("-------------------------");
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(APP_URL_CEP))
				.build();
		
		System.out.println("request: "+request);
		System.out.println("-------------------------");
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		//response.statusCode();
		System.out.println("Conexão: "+response.statusCode());
		
		System.out.println("response: "+ response);
		System.out.println("-------------------------");
		System.out.println("response body:"+response.body());
		
		
	}
}