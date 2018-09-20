package myfirsttestpackeage;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import Generic Functions Package
import pkgGenericFunctions.clsGenericFunctions;

public class clsUserSignUp extends clsExcelDataExtract{
	
  WebDriver driver;
  String strBaseURL = "https://www.irctc.co.in/eticketing/userSignUp.jsf";
  
  @Test(priority=1, dataProvider="getData")
  public void fnUserRegForm(String args []) {
	  //Open the URL
	  driver.get(strBaseURL);
	  String strText;
	  
	  //Create an instance of Generic Functions Class
	  clsGenericFunctions clsGenFun = new clsGenericFunctions(driver);
	  
	  //UserID	  
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:userName", args[0]);

	  
	  //Check Availability
	  //driver.findElement(By.linkText("Check Availability")).click();
	  driver.findElement(By.id("userRegistrationForm:checkavail")).click();
	  
	  
	  if(clsGenFun.isAlertPresent()){
		  //User Id not available, report the issue and close the session	  
		  afterTest();
		  return;
	  } 
	  
	 //User Id already exists, report the issue and close the session	
	 if (driver.findElements(By.xpath("//label[contains(text(),'already')]")).size() > 0){
		 WebElement lblMsg = driver.findElement(By.xpath("//label[contains(text(),'already')]"));
		 strText=lblMsg.getText();
		 clsGenFun.getscreenshot();
		 System.out.println("* " + strText);
		 afterTest();
		 return;
		 
	 }
	  
	  //Password
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:password", args[1]);
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:confpasword", args[1]);
	  if(clsGenFun.isAlertPresent()){
		  afterTest();
		  return;
	  }
	  	  
	  //Security Question	
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:securityQ", args[2]);
	    
	  //Answer to Question
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:securityAnswer", args[3]);
	
	  //Pref Language
	  clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:prelan", args[4]);
	  
	  //User Name	  
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:firstName", args[5]);
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:middleName", args[6]);
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:lastName", args[7]);

	  //Gender
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:gender", args[8]);

	  //MaritalStatus
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:maritalStatus", args[9]);
	  
	  //DOB
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:dobDay", "25");
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:dobMonth", "03");
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:dateOfBirth", "1998");
	  
	  
	  //Occupation
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:occupation", args[11]);
	  
	  //Aadhar
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:uidno", args[12]);
	  
	  //Pan No
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:idno", args[13]);
	  
	  //Populate Country
	  clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:countries", args[14]);
	  
	  //Email
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:email", args[15]);
	  
	  //mobile
	  if(clsGenFun.isObjectEnabled("By.id", "userRegistrationForm:isdCode")){
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:isdCode", args[16]);
	  }
	  
	  //fnPopulateText("By.id", "userRegistrationForm:mobile", "1122334455");
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:mobile", args[17]);
	
	  //Nationality
	  clsGenFun.fnPopulateDropDown("selectByVisibleText", "userRegistrationForm:nationalityId", args[18]);
	  
	  //Address
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:address", args[19]);
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:street", args[20]);
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:area", args[21]);
	  
	  //Pincode
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:pincode", args[22]);

	  //City & Post Office
	  if(clsGenFun.isObjectDisplayed("By.id", "userRegistrationForm:statesName")){
		
		  // https://www.softwaretestingmaterial.com/stale-element-reference-exception-selenium-webdriver/
		  //driver.navigate().refresh();
		  
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebDriverWait waitA = new WebDriverWait(driver, 30);
		  waitA.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']"))));
		  waitA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userRegistrationForm:cityName']")));
		  waitA.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='userRegistrationForm:cityName']")));
		  
		  /*
		  // ** Quick Checks **
		  System.out.println("City Size: " + driver.findElements(By.xpath("//*[@id='userRegistrationForm:cityName']")).size());
		  WebElement A1 = driver.findElement(By.xpath("//*[@id='userRegistrationForm:statesName']"));
		  System.out.println("StateName: " + A1.getAttribute("value"));
		  System.out.println("StateName: " + A1.isDisplayed());
		  WebElement A2 = driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']"));
		  System.out.println("CityName: " + A2.getAttribute("value"));
		  System.out.println("CityName isEnabled: " + A2.isEnabled());
		  System.out.println("CityName isDisplayed: " + A2.isDisplayed());
		  System.out.println("CityName isSelected: " + A2.isSelected());
		  */
		  
		  //Populate City 
		  //clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:cityName", "1");
		  clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:cityName", args[24]);
		  
		  /*
		  Select AA = new Select(waitA.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='userRegistrationForm:cityName']"))));
		  AA.selectByVisibleText("Udupi");	
		  // or	  
		  WebElement oTemp = driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']"));
		  Select SelOption = new Select(oTemp);
		  //SelOption.selectByIndex(Integer.parseInt("0"));
		  SelOption.selectByValue("Udupi");
		  */
		  
		  waitA.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:postofficeName']"))));
		  waitA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userRegistrationForm:postofficeName']")));
		  waitA.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='userRegistrationForm:postofficeName']")));
		  
		  /*
		  System.out.println("postofficeName Size: " + driver.findElements(By.xpath("//*[@id='userRegistrationForm:postofficeName']")).size());
		  WebElement A3 = driver.findElement(By.xpath("//*[@id='userRegistrationForm:postofficeName']"));
		  System.out.println("postofficeName: " + A3.getAttribute("value"));
		  System.out.println("postofficeName isEnabled: " + A3.isEnabled());
		  System.out.println("postofficeName isDisplayed: " + A3.isDisplayed());
		  System.out.println("postofficeName isSelected: " + A3.isSelected());
		  */
		  
		  //Populate Post office
		  //clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:postofficeName", "1");
		  clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:postofficeName",args[25]);
		  
		  /*
		  WebElement oTemp = driver.findElement(By.xpath("//*[@id='userRegistrationForm:postofficeName']"));
		  Select SelOption = new Select(oTemp);
		  SelOption.selectByIndex(Integer.parseInt("1"));
		  //SelOption.selectByValue("Adi-udupi B.O");
		  */
		  
		  //******* Check for Staleness *********
		  //System.out.println("State Staleness: " + ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:statesName']"))));
		  //System.out.println("City Staleness: " + ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']"))));
		  //System.out.println("C: " + driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']")).toString());
		  //System.out.println("D: " + driver.findElement(By.xpath("//*[@id='userRegistrationForm:statesName']")).toString());
		  
		  //waitA.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:statesName']")))));
		  
		  //driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']/option[1]"));
		  //driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityName']/option[@value='Udupi' and . = 'Udupi']"));
		  
		  /*
		  	<select name="userRegistrationForm:cityName" class="labeltxt" id="userRegistrationForm:cityName" onchange="fetchPostOfficeList()" size="1">	<option value="-1">---- Select city ---- </option>
			<option value="Udupi">Udupi</option>
			</select>
			
			<select id="userRegistrationForm:postofficeName" name="userRegistrationForm:postofficeName" class="labeltxt" size="1" onchange="fetchPostOfficeDistrict()">	<option value="-1">---- Select a Post Office ---- </option>
			<option value="Adi-udupi B.O">Adi-udupi B.O</option>
			<option value="Bannanje S.O">Bannanje S.O</option>
			<option value="Chitpadi B.O">Chitpadi B.O</option>
			<option value="Kinnimulki B.O">Kinnimulki B.O</option>
			<option value="Kukkikatte B.O">Kukkikatte B.O</option>
			<option value="Mission Compound S.O">Mission Compound S.O</option>
			<option value="Udupi Courts S.O">Udupi Courts S.O</option>
			<option value="Udupi H.O">Udupi H.O</option>
			</select>
		*/
		  	  	
	  }else{
		//Populate State and City
		//fnPopulateText("By.id", "userRegistrationForm:otherState", "MyState");
		//fnPopulateText("By.id", "userRegistrationForm:otherCityId", "MyCity");
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:otherState", args[23]);
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:otherCityId", args[24]);
	  }
	 
	  //fnPopulateText("By.id", "userRegistrationForm:landline", "11223344");
	  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:landline", args[26]);
	  
	  //Office Address
	  //clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:resAndOff", "1");
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:resAndOff", args[27]);
	  
	  //Other Address
	  if(clsGenFun.isObjectDisplayed("By.id", "userRegistrationForm:addresso")){
		  //Address
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:addresso", args[28]);
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:streeto", args[29]);
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:areao", args[30]);
		  clsGenFun.fnPopulateDropDown("selectByVisibleText", "userRegistrationForm:countrieso", args[31]);
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:pincodeo", args[32]);

		  //City & Post Office based on State
		  if(clsGenFun.isObjectDisplayed("By.id", "userRegistrationForm:statesNameo")){	
			
			  //Populate City Other
			  WebDriverWait waitA = new WebDriverWait(driver, 30);
			  waitA.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:cityNameo']"))));
			  waitA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userRegistrationForm:cityNameo']")));
			  waitA.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='userRegistrationForm:cityNameo']")));
			  
			  //clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:cityNameo", "Udupi");
			  clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:cityNameo", args[34]);
			  
			  //Populate Post office Other
			  waitA.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='userRegistrationForm:postofficeNameo']"))));
			  waitA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userRegistrationForm:postofficeNameo']")));
			  waitA.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='userRegistrationForm:postofficeNameo']")));
			  
			  //clsGenFun.fnPopulateDropDown("selectByValue", "userRegistrationForm:postofficeNameo", "Bannanje S.O");
			  clsGenFun.fnPopulateDropDown("selectByIndex", "userRegistrationForm:postofficeNameo", args[35]);
			  
			  //driver.findElement(By.id("userRegistrationForm:otherStateo")).sendKeys(Keys.TAB);
			  //driver.findElement(By.id("userRegistrationForm:cityNameo")).sendKeys(Keys.ENTER);
			  //driver.findElement(By.id("userRegistrationForm:cityNameo")).click(); 
			
		  }else{
			  //Populate State Other and City Other
			  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:otherStateo", args[33]);
			  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:otherCityIdo", args[34]);
		  }
		 
		  clsGenFun.fnPopulateText("By.id", "userRegistrationForm:landlineo", args[36]);
	  }

	 
	  //Subscription Alert
	  //fnPopulateRadio("By.name", "userRegistrationForm:newsletter", "1");
	  //fnPopulateRadio("By.name", "userRegistrationForm:commercialpromo", "1");
	  //fnPopulateRadio("By.name", "userRegistrationForm:irctcsbicard", "1");
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:newsletter", args[37]);
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:commercialpromo", args[38]);
	  clsGenFun.fnPopulateRadio("By.name", "userRegistrationForm:irctcsbicard", args[39]);
	  
	  
	  //Enter Capacha manually
	  Scanner in = new Scanner(System.in);
	  System.out.println("Please enter the Captcha: \n");
	  String strTemp= in.nextLine();
	  driver.findElement(By.id("captcha")).sendKeys(strTemp);  
	  in.close();
	  	  
	  //Submit the form
	  driver.findElement(By.id("userRegistrationForm:j_idt502")).click();
	  //driver.findElement(By.linkText("Submit Registration Form>>>")).click();
	  
	  if (clsGenFun.isAlertPresent()){
		  afterTest();
		  return;
	  }
  
	  //Invalid data entry message, report the issue and close the session	
	  if (driver.findElements(By.xpath("//*[@id='userRegistrationForm:j_idt152_body']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/span")).size() > 0){
			 WebElement spanMsg = driver.findElement(By.xpath("//*[@id='userRegistrationForm:j_idt152_body']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/span"));
			 strText=spanMsg.getText();
			 clsGenFun.getscreenshot();
			 System.out.println("* " + strText);
			 afterTest();	
			 return;
	  }
  }    
  
  @Test(priority=2)
  public void Confirm() {
	  /*
      driver.findElement(By.csssSelector(".mx-name-signOutButton1")).click();
      */
	  //System.out.println("priority=5");
  }
  
  @Parameters({ "browser" })
  @BeforeTest
  public void beforeTest(String browser) {
	  
	  try {
	  
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			//System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.marionette", "D:\\SeleniumDrivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.marionette", "D:\\SeleniumDrivers\\geckodriver-v0.20.1-win32\\geckodriver.exe");
			//driver = new FirefoxDriver();
			//driver.get("https://www.google.fi/");
			
			/*
			 System.setProperty("webdriver.firefox.marionette","D:\\SeleniumDrivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			  FirefoxOptions options = new FirefoxOptions();
			  options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
			  driver = new FirefoxDriver(options);
			 
			  */
			//https://github.com/SeleniumHQ/selenium/issues/4197
			
			System.setProperty("webdriver.firefox.marionette","D:\\SeleniumDrivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	    	FirefoxOptions options = new FirefoxOptions();
			//options.setLogLevel(FirefoxDriverLogLevel.DEBUG);
	    	options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(options);
	            
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver", "D:\\SeleniumDrivers\\Microsoft_Web_Driver\\MicrosoftWebDriver.exe");
			//create Edge instance
			driver = new EdgeDriver();

	  	} 
		//Check if parameter passed as 'IE'
		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\SeleniumDrivers\\IEDriverServer_x64_3.12.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	  } catch (Exception e) {
			System.out.println(e.getMessage());
	  }
	  
	  /*
	  try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"D:/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	   */
	  
	  //This will try to wait until the page is fully loaded on every page navigation or page reload.
	  //Implicit Wait 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();  
  }

  @AfterTest
  public void afterTest() {
	 //driver.close();
  }
  
//fnPopulateText("By.id", "userRegistrationForm:userName", "Sharath6789");
//fnPopulateText("By.id", "userRegistrationForm:password", "TRTRT123");
//fnPopulateText("By.id", "userRegistrationForm:confpasword", "TRTRT123");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:securityQ", "7");
//fnPopulateText("By.id", "userRegistrationForm:securityAnswer", "AAA");
//fnPopulateDropDown("selectByIndex", "userRegistrationForm:prelan", "1");
//fnPopulateText("By.id", "userRegistrationForm:firstName", "NewNameFirst");
//fnPopulateText("By.id", "userRegistrationForm:middleName", "NewNameMiddle");
//fnPopulateText("By.id", "userRegistrationForm:lastName", "NewNameLast");
//fnPopulateRadio("By.name", "userRegistrationForm:gender", "1");
//fnPopulateRadio("By.name", "userRegistrationForm:maritalStatus", "1");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:dobDay", "25");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:dobMonth", "03");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:dateOfBirth", "1998");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:occupation", "2");
//fnPopulateText("By.id", "userRegistrationForm:uidno", "892484YUT62");
//fnPopulateText("By.id", "userRegistrationForm:idno", "AABB12345");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:countries", "25");
//fnPopulateDropDown("selectByVisibleText", "userRegistrationForm:countries", "India");
//fnPopulateText("By.id", "userRegistrationForm:email", "wuifuiwf@gmail.com");
//fnPopulateText("By.id", "userRegistrationForm:isdCode", "21");
//fnPopulateDropDown("selectByValue", "userRegistrationForm:nationalityId", "25");
//fnPopulateDropDown("selectByVisibleText", "userRegistrationForm:nationalityId", "India");
//fnPopulateText("By.id", "userRegistrationForm:address", "Addr1");
//fnPopulateText("By.id", "userRegistrationForm:street", "Street1");
//fnPopulateText("By.id", "userRegistrationForm:area", "Area1");
//fnPopulateText("By.id", "userRegistrationForm:pincode", "576101");

}
