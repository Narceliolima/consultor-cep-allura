package allura.estudo.cep.webconnection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectionRequesterResponser {

	private HttpClient client = null;
	private HttpRequest request = null;
	private HttpResponse<String> response = null;
	
	public ConectionRequesterResponser() {
		this.client = HttpClient.newHttpClient();
		
	}
	
	public String requestData(String data) {
		
		this.request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+data+"/json")).build();
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "Erro na conexao";
		}
		return response.body();
	}
}
