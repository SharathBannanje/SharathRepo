package pkgUserRegForm_Delete;

import java.util.concurrent.TimeUnit;

import java.awt.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clsUserRegForm {
	
	public WebDriver driver;
	  String strBaseURL = "https://www.irctc.co.in/eticketing/userSignUp.jsf";
	  //"http://demo.guru99.com/selenium/facebook.html";
	 	  
		
	  @Test(priority=10)
	  public void f() {
		  String strTitle = "";
		  driver.get(strBaseURL);
		  driver.manage().window().maximize();
		  strTitle = driver.getTitle();
		  System.out.println(strTitle);
		  
		  
		  //User ID
		  driver.findElement(By.id("userRegistrationForm:userName")).sendKeys("NewRRR");  
		  driver.findElement(By.linkText("Check Availability")).click();
		  
		  if(isAlertPresent()){
			  afterTest();
			  return;
		  }
		  
		  driver.findElement(By.id("userRegistrationForm:password")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:confpasword")).sendKeys("wuifuiwf");  
		  
		  Select SecQuestion = new Select(driver.findElement(By.id("userRegistrationForm:securityQ")));
		  SecQuestion.selectByValue("3");
		  driver.findElement(By.id("userRegistrationForm:securityAnswer")).sendKeys("wuifuiwf"); 
		  
		  Select PrefLanguage = new Select(driver.findElement(By.id("userRegistrationForm:prelan")));
		  PrefLanguage.selectByIndex(0);
		  
		  driver.findElement(By.id("userRegistrationForm:firstName")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:middleName")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:lastName")).sendKeys("wuifuiwf");  
		  
		  java.util.List<WebElement> oRadioButton = driver.findElements(By.name("userRegistrationForm:gender"));
		  oRadioButton.get(1).click();
		  
		  java.util.List<WebElement> oRadioButton1 = driver.findElements(By.name("userRegistrationForm:maritalStatus"));
		  oRadioButton1.get(1).click();
		  
		  Select dobDay = new Select(driver.findElement(By.id("userRegistrationForm:dobDay"))); 
		  dobDay.selectByValue("25");
		  Select dobMonth = new Select(driver.findElement(By.id("userRegistrationForm:dobMonth"))); 
		  dobMonth.selectByValue("03"); 
		  Select dateOfBirth = new Select(driver.findElement(By.id("userRegistrationForm:dateOfBirth"))); 
		  dateOfBirth.selectByValue("1998"); 
		  
		  Select occup = new Select(driver.findElement(By.id("userRegistrationForm:occupation"))); 
		  occup.selectByValue("2"); 
		  
		  driver.findElement(By.id("userRegistrationForm:uidno")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:idno")).sendKeys("wuifuiwf");  
		  
		  Select countries = new Select(driver.findElement(By.id("userRegistrationForm:countries"))); 
		  countries.selectByValue("25");
		  //countries.selectByVisibleText("India");
		  	  
		  driver.findElement(By.id("userRegistrationForm:email")).sendKeys("wuifuiwf@gmail.com");  
		
		  //userRegistrationForm:mobile
		  //<input disabled="" id="userRegistrationForm:isdCode" name="userRegistrationForm:isdCode" value="91" class="textfield01" maxlength="3" onblur="changeOfISD()" onkeypress=" if(event.which==8 || event.which==46 ||event.which==37 || event.which==39) {return true } else if(event.which < 48 || event.which > 57) { return false };" style="width:25px" type="text">
		  //<input id="userRegistrationForm:mobile" name="userRegistrationForm:mobile" class="textfield01" maxlength="12" onkeypress=" if(event.which==8 || event.which==46 ||event.which==37 || event.which==39) {return true } else if(event.which < 48 || event.which > 57) { return false };" type="text">
		  
		  driver.findElement(By.id("userRegistrationForm:nationalityId")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:address")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:street")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:area")).sendKeys("wuifuiwf");  
		  driver.findElement(By.id("userRegistrationForm:pincode")).sendKeys("576101");  
		  
		  if(isObjectDisplayed())
			  System.out.println("State Enabled");
		  else
			  System.out.println("State Not Enabled");
		  
		  driver.findElement(By.id("userRegistrationForm:landline")).sendKeys("11223344");  
		  
		  java.util.List<WebElement> oRadioButton2 = driver.findElements(By.name("userRegistrationForm:resAndOff"));
		  oRadioButton2.get(0).click();
		  
		  /*
		  Scanner in = new Scanner(System.in);
		  System.out.println("Please enter the Capatcha: \n");
		  String strTemp= in.nextLine();
		  driver.findElement(By.id("userRegistrationForm:captchaM")).sendKeys(strTemp);  
		  in.close();
		  */
	  
		  java.util.List<WebElement> oRadioButton3 = driver.findElements(By.name("userRegistrationForm:newsletter"));
		  oRadioButton3.get(1).click();
		  java.util.List<WebElement> oRadioButto4 = driver.findElements(By.name("userRegistrationForm:commercialpromo"));
		  oRadioButto4.get(1).click();
		  java.util.List<WebElement> oRadioButton5 = driver.findElements(By.name("userRegistrationForm:irctcsbicard"));
		  oRadioButton5.get(1).click();
		  

		  WebElement lblMsg=driver.findElement(By.id("userRegistrationForm:useravail"));
		  String strText=lblMsg.getAttribute("value");
		  System.out.println(strText);
		  String strText1=lblMsg.getText();
		  System.out.println(strText1);
		  
	  	  //<label id="userRegistrationForm:useravail" style="color:green;font-weight:bold"></label>
		  //<label id="userRegistrationForm:useravailn" style="color:red;font-weight:bold">User Id  already exists .... Please choose a different User Name...</label>
		 
		  //<input checked="checked" name="userRegistrationForm:resAndOff" id="userRegistrationForm:resAndOff:0" value="Y" type="radio">
		  
		 
		  
		
	  }
	  
	  public boolean isAlertPresent(){
		  boolean foundAlert = false;
		  try {
			  	Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				foundAlert = true;
		  }
		  catch (Exception e) {
			    System.out.println("Alert not found: " /*+ e.getMessage()*/ );
		  }
		  
		  /* Fails at wait condition when No Alert
	      try{
	      	// Explicit Waits 
	    	  WebDriverWait wait = new WebDriverWait(driver, 15);
	    	  wait.until(ExpectedConditions.alertIsPresent());
	    	  Alert alert = driver.switchTo().alert();
	        	System.out.println("The Alert is : " + alert.getText());
	        	foundAlert = true;
	        	alert.accept();
	      } catch (NoAlertPresentException e) {
	    		System.out.println("No Alert : " + 	e );
	      }
	      */	    
		   return foundAlert;
	  }
	 
	  public boolean isObjectDisplayed(){
		  boolean isObjectDisplayed = false;
		  try{
			  //<input id="userRegistrationForm:statesName" type="text" name="userRegistrationForm:statesName" class="textfield01" maxlength="15" disabled="disabled" style="visibility: hidden;">		
			  WebElement statesName = driver.findElement(By.id("userRegistrationForm:statesName"));
			  //Assert.assertEquals(true, statesName.isDisplayed());
			  if(statesName.isDisplayed()){
				  isObjectDisplayed = true;
				  
				  //<select id="userRegistrationForm:cityName" name="userRegistrationForm:cityName" class="labeltxt" size="1" onchange="fetchPostOfficeList()" style="visibility: visible;">	<option value="-1">---- Select city ---- </option>
				  //</select>
				  //<select id="userRegistrationForm:postofficeName" name="userRegistrationForm:postofficeName" class="labeltxt" size="1" onchange="fetchPostOfficeDistrict()" style="visibility: visible;">	<option value="-1">---- Select a Post Office ---- </option>
				 // </select>
				  Select cityName =  new Select(driver.findElement(By.id("userRegistrationForm:cityName")));
				  cityName.selectByIndex(1);
				  Select postofficeName = new Select(driver.findElement(By.id("userRegistrationForm:postofficeName")));
				  postofficeName.selectByIndex(1);
				  
			  }else{
				  
				  //<input id="userRegistrationForm:otherState" type="text" name="userRegistrationForm:otherState" maxlength="25" style="visibility: visible;">
				  //<input id="userRegistrationForm:otherCityId" type="text" name="userRegistrationForm:otherCityId" maxlength="25" style="visibility: visible;">
				  driver.findElement(By.id("userRegistrationForm:otherState")).sendKeys("wuifuiwf");  
				  driver.findElement(By.id("userRegistrationForm:otherCityId")).sendKeys("wuifuiwf");  
				  
			  }
			  
			  //String string1="Junit";					
		      //String string2="Junit";
		      //int variable1=1;					
		      //int	variable2=2;	
		      //Assert.assertEquals(string1,string2);	
		      //Assert.assertTrue(variable1<variable2);	
			  
		  } catch(Exception e){
			  
		  }	  
		  return isObjectDisplayed;
		  
	  }
	 
	  @Test(priority=2)
	  public void login() {
		  	/*
		  	driver.findElement(By.cssSelector("#usernameInput")).sendKeys("MxAdmin");
		    driver.findElement(By.cssSelector("#passwordInput")).sendKeys("1");
		    driver.findElement(By.cssSelector("#loginButton")).click();
		    */
		  //System.out.println("priority=2");
	  }
	  
	  @Test(priority=3)
	  public void openExpensesTab() {
		  /*
	      WebDriverWait wait = new WebDriverWait(driver, 10);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mx-name-tabPage4"))).click();
	      */
		 //System.out.println("priority=3");
	  }
	  
	  
	  
	  @Test(priority=4)
	  public void createExpense() {
		  /*
	      driver.findElement(By.cssSelector(".mx-name-newButton3")).click();
	      driver.findElement(By.cssSelector(".mx-window-active .mx-name-textBox6 input")).clear();
	      driver.findElement(By.cssSelector(".mx-window-active .mx-name-textBox6 input")).sendKeys("15.00");
	      driver.findElement(By.cssSelector(".mx-window-active .mx-name-referenceSelector1 option:nth-child(2)")).click();
	      driver.findElement(By.cssSelector(".mx-window-active .mx-name-saveButton1")).click();
	      */
		 // System.out.println("priority=4");
	  }
	  
	  @Test(priority=5)
	  public void signOut() {
		  /*
	      driver.findElement(By.cssSelector(".mx-name-signOutButton1")).click();
	      */
		  //System.out.println("priority=5");
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  
		  //System.setProperty("webdriver.gecko.driver","D:\\SeleniumDrivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		  //driver = new FirefoxDriver();
		  
		  /*
		  System.setProperty("webdriver.firefox.marionette","D:\\SeleniumDrivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
	  	  driver = new FirefoxDriver();
	  	  */
		  
		  /*
		  System.setProperty("webdriver.gecko.driver","D:\\SeleniumDrivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		  FirefoxOptions options = new FirefoxOptions();
		  options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
		  driver = new FirefoxDriver(options);
		  */
		  
		  System.setProperty("webdriver.chrome.driver","D:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  //This will try to wait until the page is fully loaded on every page navigation or page reload.
		  //Implicit Wait 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @AfterTest
	  public void afterTest() {
		 //driver.close();
	  }
}
