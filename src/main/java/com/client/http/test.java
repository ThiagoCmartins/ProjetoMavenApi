package com.client.http;

import java.io.BufferedReader;
import java.io.IOException;

public class test {
    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {    	
            jsonEmString += resposta;
            
            System.out.println("jsonEmString: "+ jsonEmString);
            
        }
        return jsonEmString;
    }
}