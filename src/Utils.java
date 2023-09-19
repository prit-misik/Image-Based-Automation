import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Utils extends HeadClass{

	
	
	 public static void readCSV(String csvFile){
	
		  BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            
	            while ((line = br.readLine()) != null) {

	                openURL(line);
	                takeScreenshot(line);
	                Image.getResultImage(line);
                    
	            }
	            driver.close();
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	 }

   public static void openURL(String DSPName){
	   
	  
	   try {
		System.out.println("Opening...");   
		System.out.println("http://"+ISHost+":"+ISPort+"/WmRoot/"+DSPName); 
		//openBrowser("chrome");
		driver.get("http://"+ISHost+":"+ISPort+"/WmRoot/"+DSPName);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		System.out.println("Done !!!");
	     }
	   catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
   }	 
   
   
   public static void loginToIS(){
	   
	   String url = "http://" + username + ":" + password + "@" + ISHost + ":"
				+ ISPort;
	   driver.get(url);
   }
   
   public static void takeScreenshot(String pageName){
	   File src= (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
	    // now copy the  screenshot to desired location using copyFile //method
	   FileUtils.copyFile(src, new File(FILE+pageName+".png"));
	   System.out.println(" SC For "+pageName);
	   }
	    
	   catch (IOException e)
	    {
	     System.out.println(e.getMessage());
	    
	    }
   }

   public static void WriteToFile(String imageName) {

         try{
        	 FileWriter writer = new FileWriter("output.txt", true); 
        	    
        	    writer.write(imageName+ "\n");
        	    
        	    writer.close();
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
		
	} 
   
   
   
   
	 
public static void main(String args[]){
	//openBrowser("chrome");
    //loginToIS();    
	//readCSV("C:\\dummy.csv");
	
   }


	 
	 
}
