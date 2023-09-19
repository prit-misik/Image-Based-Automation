import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CreateHTMLReport {
	
	public static void fetchDSPNameAndCreateReport(ArrayList FailedDSPList) throws IOException{
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("HTMLReport/report.html"));
		pw.println("<head><link rel='stylesheet' href='../css/styles.css'></head><body><h1>Image Based UI Test Report</h1><p></p><table><tr><th>No.<th>DSP Name<th>Status<th>Click To Check Failures</tr>");
        String dspName=null;
		String screenShot=null;
		System.out.println("Creating HTML Result...");
		    try{
		    	 for(int i=0;i<FailedDSPList.size();i++){
		    		dspName=(String) FailedDSPList.get(i); 
		    		//screenShot="/resultScreen/"+dspName+".png";
		    		//screenShot="<a href='/resultScreen/"+dspName+".png' target='_blank'><img alt='ScreenShot' width='90px' align='left' src='/resultScreen/"+dspName+".png'></a>";
		    		screenShot="<a href='../resultScreen/"+dspName+".png'><img border='0' alt='screenshot' src='../resultScreen/"+dspName+".png' width='50' height='50' border='0'></a>";
		    		pw.println("<tr><td>" + i+1 +"<td>" + dspName + "<td>" + "FAILED" + "<td>" + screenShot);
		    	 }
		    	
		    }
		    catch(Exception e) {
		    	
		    }
		    finally{
		    	System.out.println("Result generated in HTMLReport/report.html");
		    	pw.println("</body></table>");
		    	pw.close();
		    }
		    	    
	}


	public static void makeReport(){
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter("HTMLReport/report.html"));
			pw.println("<TABLE BORDER><TR><TH>Number<TH>Square of Number</TR>");
	        for (int i = 1; i <= 20; i++) {
	               int square = i * i;
	               pw.println("<TR><TD>" + i + "<TD>" + square);
	        }
	        pw.println("</TABLE>");
	        pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
	}
	
}
