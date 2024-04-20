package allura.estudo.cep.interactive;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileHandler {
	
	FileWriter fileWriter = null;
	BufferedWriter bufferWritter = null;
	
	public JsonFileHandler() {
		try {
			fileWriter = new FileWriter("jsonCepLog.json");
			bufferWritter = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jsonDataWritter(String jsonData) {
		
		try {
			bufferWritter.write(jsonData+"\n");
			bufferWritter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
