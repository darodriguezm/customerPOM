package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecordWriter {

	private static final String outputFile = "./registros.csv"; 
	private File file;
	private FileWriter fileWriter;
	
	public FileRecordWriter(){
		file = new File(outputFile);
		
		try {
			fileWriter = new FileWriter(file, true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.append("url,title,registro");
	}
	
	public void append(String record) {
		try {
			
			fileWriter.write(record);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}