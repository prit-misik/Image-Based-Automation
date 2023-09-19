import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class HeadClass {

	public static WebDriver driver = null;
    public static final String CSV_LOCATION="C:\\dummy.csv";
    
    public final static String ISHost = "localhost";
	public final static String ISPort = "8866";
	public final static String username = "Administrator";
	public final static String password = "manage";
	public final static String FILE = "CurrentScreen/";
	/**
	 * Method to open any browser based on the input browser name
	 * 
	 * @param browser
	 *            - input browser name
	 * @return
	 */
	public static void openBrowser(String browser) {

		ProfilesIni pf = new ProfilesIni();
		FirefoxProfile profile = pf.getProfile("");

		if (browser.equalsIgnoreCase("mozilla")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\Lib\\\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public static void openURL(String url) throws InterruptedException {

		driver.get(url);
	
	}
	
	public static void main(String srgs[]) throws IOException{
		
		openBrowser("chrome");
	    Utils.loginToIS();    
		Utils.readCSV(CSV_LOCATION);
		CreateHTMLReport.fetchDSPNameAndCreateReport(Image.FailedDSPList);
		
	}
	
	
}
