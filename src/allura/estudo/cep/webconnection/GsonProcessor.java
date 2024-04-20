package allura.estudo.cep.webconnection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import allura.estudo.cep.interactive.Cep;
import allura.estudo.cep.interactive.JsonFileHandler;

public class GsonProcessor {

	private Gson gson = null ;
	private ConectionRequesterResponser conectionRR = new ConectionRequesterResponser();
	JsonFileHandler jfs = new JsonFileHandler();
	
	public GsonProcessor() {
		this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();
	}

	public Cep getJsonCepData(String dataNumber) {
		
		String cepJson = conectionRR.requestData(dataNumber.replace("-", ""));
		
		if(cepJson.equals("Erro na conexao")) {
			System.err.println("Erro de conexao gerado");
			return new Cep("Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", -1, -1);
		}
		else {
			try {
				if(cepJson.contains("\"erro\": true")){
					System.err.println("Erro de pesquisa gerado");
					return new Cep("Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", -5, -5);
				}
				else {
					saveCepJsonFile(cepJson);
					return gson.fromJson(cepJson, Cep.class);
				}
			}
			catch (JsonSyntaxException e) {
				System.err.println("Erro de parametro de valor gerado");
				return new Cep("Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", "Erro", -10, -10);
			}
		}
	}

	public String setJsonCepData(Cep cep) {
		
		String cepJson = gson.toJson(cep);
		saveCepJsonFile(cepJson);
		return cepJson;
	}
	
	private void saveCepJsonFile(String cepJson) {
		
		jfs.jsonDataWritter(cepJson);
	}
}
