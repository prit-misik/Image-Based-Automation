import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TEST {

	public static void read(File file){
		BufferedReader reader;
		int count=0;
		try {
			reader = new BufferedReader(new FileReader(
					file));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
				System.out.println(line);
				count ++;
				  if(count==4){
					  System.out.println("\n\n");
					  break;
				  }
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		File folder = new File("C:\\Users\\prs\\Documents\\CV SIQA openings");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile()) {
              if(file.getName().endsWith(".docx") || file.getName().endsWith(".doc")){
                read(file);
              }
		  } 
		}

	}

}
