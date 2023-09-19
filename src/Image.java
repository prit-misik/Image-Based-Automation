
import javax.imageio.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Image {

	public static String diffFound="false";
	public static ArrayList FailedDSPList=new ArrayList();
	
	public static void main(String args[]) throws IOException{
		 
		 //write method takes 3 param, the 1st param will come from getDifferenceImage method, 2nd is the extension, 3rd is the file path 
		
		/* 
		 ImageIO.write(
			        getDifferenceImage(
			                ImageIO.read(new File("C:\\WORK\\tools\\input\\a.PNG")),
			                ImageIO.read(new File("C:\\WORK\\tools\\input\\b.PNG"))),"png",new File("C:\\WORK\\tools\\input\\output.PNG"));
	   */ 
	     
	     }
	 
	public static void getResultImage(String imageName){
		try {
			BufferedImage imageToWrite = getDifferenceImage(ImageIO.read(new File("TruthScreen/"+imageName+".png")),ImageIO.read(new File("CurrentScreen/"+imageName+".png")));
			  if(diffFound.equals("true")){ 
				  ImageIO.write(imageToWrite,"png",new File("resultScreen/"+imageName+".png"));
				  Utils.WriteToFile(imageName);
				  FailedDSPList.add(imageName);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			diffFound="false";
		}
		
		
	} 
	
	
	
	/*
	 public static void getResultImage(String imageName){
		 
		 try{
			 if(diffFound.equals("true")){
			   ImageIO.write(
				        getDifferenceImage(
				                ImageIO.read(new File("TruthScreen/"+imageName+".png")),
				                ImageIO.read(new File("CurrentScreen/"+imageName+".png"))),"png",new File("resultScreen/"+imageName+".png"));
			 }
			 
		  } 
			 
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally{
			 diffFound="false";
		 }
		 
	 }
	 */
	 
	 public static BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2) {
		    // convert images to pixel arrays...
		   System.out.println("In getDifferenceImage method for......... "+img1);
		    final int w = img1.getWidth(),
		            h = img1.getHeight(), 
		            highlight = Color.MAGENTA.getRGB();
		    final int[] p1 = img1.getRGB(0, 0, w, h, null, 0, w);
		    final int[] p2 = img2.getRGB(0, 0, w, h, null, 0, w);
		    // compare img1 to img2, pixel by pixel. If different, highlight img1's pixel...
		    for (int i = 0; i < p1.length; i++) {
		        if (p1[i] != p2[i]) {
		        	diffFound="true";
		        	//System.out.println("Difference Found !!! in .... "+img1);
		            p1[i] = highlight;
		            System.out.println("Highlighted the Difference");
		        }
		        else{
		        	//diffFound=false;
		        	//System.out.println("in else part");
		        }
		    }
		    
		         
		    
		    // save img1's pixels to a new BufferedImage, and return it...
		    // (May require TYPE_INT_ARGB)
		    final BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		    out.setRGB(0, 0, w, h, p1, 0, w);
		    return out;
		}
	 
	
}
