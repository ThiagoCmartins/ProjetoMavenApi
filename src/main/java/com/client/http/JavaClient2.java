package com.client.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.get.set.Endereco;
import com.google.gson.Gson;

public class JavaClient2 {
	
	public static void main(String[] args) throws Exception {
		
		newEndereco();
		
	}
	
	
	static String API_URL = "https://viacep.com.br/ws/01001000/json/";
    static int ok = 200;

	public static Endereco newEndereco()throws Exception{
		
	try {
		
			URL url = new URL(API_URL);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			
			System.out.println("-----------------");
			System.out.println("conexao: "+conexao);
			System.out.println("-----------------");
			System.out.println("conexao: "+conexao.getResponseCode());
			System.out.println("-----------------");
			
			if (conexao.getResponseCode() != ok) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			
			System.out.println("resposta: " + resposta);
			System.out.println("-----------------");
			
			String jsonEmString = test.converteJsonEmString(resposta);
			
			System.out.println("jsonEmString: " + jsonEmString);
			System.out.println("-----------------");
			
			Gson gson = new Gson();
            Endereco enderecos = gson.fromJson(jsonEmString, Endereco.class);
			
            System.out.println("enderecos: " + enderecos);
			System.out.println("-----------------");
            
			return enderecos;
		
	}catch (Exception e) {
        throw new Exception("ERRO: " + e);
    }
  }
}