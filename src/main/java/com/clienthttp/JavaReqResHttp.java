package com.clienthttp;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.getset.Endereco;
import com.google.gson.Gson;

public class JavaReqResHttp implements Serializable {

	private static final long serialVersionUID = 474087116905787177L;

	static String API_URL = "https://viacep.com.br/ws/";
	int ok = 200;

	public List<Endereco> listagem(String cep) throws Exception {

		List<Endereco> lista = new ArrayList<Endereco>();
		JavaReqResHttp jrrh = new JavaReqResHttp();
		Endereco endereco = new Endereco();

		try {
			endereco = jrrh.convertGson(cep);

			if (endereco.getCep() != null && endereco.getErro() == null) {

				lista.add(endereco);
				return lista;

			} else {
				return lista;
			}

		} catch (Exception e) {
			throw new Exception("ERRO [listagem]" + e);
		}
	}

	public Endereco convertGson(String cep) throws Exception {

		Endereco ed = new Endereco();
		JavaReqResHttp jrrh = new JavaReqResHttp();
		HttpResponse<String> response;
		Gson gson = new Gson();

		try {

			response = jrrh.newResponse(cep);

			if (response.statusCode() == ok) {

				Endereco endereco = gson.fromJson(response.body(), Endereco.class);
				System.out.println("To String 200:" + endereco);
				System.out.println("-------------------------");

				return endereco;

			} else {

				System.out.println("To String 400:" + ed);
				System.out.println("-------------------------");
				return ed;
			}

		} catch (Exception e) {
			throw new Exception("ERRO [convertGson]" + e);
		}
	}

	public HttpResponse<String> newResponse(String cep) throws Exception {

		try {

			String Chamada = API_URL + cep + "/json";

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(Chamada)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("-------------------------");
			System.out.println("client: " + client);
			System.out.println("-------------------------");
			System.out.println("response body:" + response.body());
			System.out.println("-------------------------");
			System.out.println("Conexão Status: " + response.statusCode());
			System.out.println("-------------------------");
			System.out.println("request: " + response);
			System.out.println("-------------------------");
			System.out.println("response body:" + response.body());
			System.out.println("-------------------------");

			return response;

		} catch (Exception e) {
			throw new Exception("ERRO [newResponse]: " + e);
		}
	}
}