package allura.estudo.cep.interactive;

import java.util.Scanner;

import allura.estudo.cep.webconnection.GsonProcessor;

public class UserInteraction {
	
	private Scanner sc = new Scanner(System.in);
	private GsonProcessor gsonProce = new GsonProcessor();

	public void requestCep() {
		
		System.out.println("Digite o Cep para consultar (Somente numeros)");
		System.out.println(gsonProce.getJsonCepData(String.valueOf(sc.next())));
		
		
		sc.close();
	}
	
	public void responseCep(Cep cep) {
		
		System.out.println(gsonProce.setJsonCepData(cep));
	}
}
