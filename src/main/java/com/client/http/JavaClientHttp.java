package com.client.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaClientHttp {
	
	String cep = "01001000";
	String api = "https://viacep.com.br/ws/"+cep+"/json/";
	
	private static final String APP_URL_CEP = "https://viacep.com.br/ws/01001000/json/";;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(APP_URL_CEP))
				.build(); 
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response);
	}
}