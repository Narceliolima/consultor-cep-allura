package allura.estudo.cep.main;

import allura.estudo.cep.interactive.Cep;
import allura.estudo.cep.interactive.UserInteraction;

public class Main {

	public static void main(String[] args) {
		
		UserInteraction user = new UserInteraction();
		
		user.requestCep();
		user.responseCep(new Cep("69978-505", "Rua dos bobos", "Praia da Maria", "Good Garden", "Caucalifornia", "ZE", "1111116", "vazio", 99, 1337));
	}

}
