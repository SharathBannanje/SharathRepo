package pkgGenericFunctions;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class clsGenericFunctions {
	
	WebDriver driver;	
	public clsGenericFunctions(WebDriver driver){
		this.driver=driver;
	}
	
	public void fnPopulateText(String strType, String strUniqueObject, String strData){
		  WebElement oTemp = driver.findElement(By.id(strUniqueObject));
		  oTemp.clear();
		  oTemp.sendKeys(strData); 	
	}
	  
	public void fnPopulateDropDown(String strType, String strUniqueObject, String strData){
		  
		  WebElement oTemp = driver.findElement(By.id(strUniqueObject));
		  Select SelOption = new Select(oTemp);

		  switch (strType.trim()){
		  	case "selectByIndex":   		
		  		SelOption.selectByIndex(Integer.parseInt(strData));
		  		break;
		  	case "selectByValue": 
		  		//System.out.println(Integer.parseInt(strData));
		  		SelOption.selectByValue(strData);
		  		break;
		  	case "selectByVisibleText": 
		  		SelOption.selectByVisibleText(strData);
		  		break;
		  }
		  //Select SecQuestion = new Select(driver.findElement(By.id("userRegistrationForm:securityQ")));
		  //SecQuestion.selectByValue("0");
		  //driver.findElement(By.id("userRegistrationForm:securityAnswer")).sendKeys("wuifuiwf");  
	 }
	  
	 public void fnPopulateRadio(String strType, String strUniqueObject, String strData){
		  
		java.util.List<WebElement> oRadioButton = driver.findElements(By.name(strUniqueObject));
		//System.out.println("aa"+Integer.parseInt(strData));
		oRadioButton.get(Integer.parseInt(strData)).click();
	 }
	  
	 public boolean isAlertPresent(){
		  boolean foundAlert = false;
		  try {
		  		//System.out.println("12"+driver.getCurrentUrl());
			  	Alert alert = driver.switchTo().alert();
				System.out.println("* "+ alert.getText());
				
				//https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/4412
				//getscreenshot();
				
				alert.accept();
				foundAlert = true;
		  } catch (Exception e) {
			  //e.printStackTrace();
		  }
		  return foundAlert;
	 }
	 
	 public void getscreenshot()
     {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 try {
			 //The below method will save the screen shot in the drive as.png"
			 //FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
			 FileHandler.copy(scrFile, new File("C:\\ACENext\\screenshot.png"));
		 } catch (Exception e) {
			//e.printStackTrace();
		 }
		 
     }
	 
	 public boolean isObjectEnabled(String strType, String strUniqueObject){
		  boolean isObjectEnabled = false;
		  try {
			  WebElement oTemp = driver.findElement(By.id(strUniqueObject));
			  if(oTemp.isEnabled()){
				  oTemp.click();
				  isObjectEnabled = true;
			  }
		  } catch(Exception e) {
			  //e.printStackTrace();
		  }
		  return isObjectEnabled;
	 }
	 
	 public boolean isObjectDisplayed(String strType, String strUniqueObject){
		  boolean isObjectDisplayed = false;
		  try {
			  WebElement oTemp = driver.findElement(By.id(strUniqueObject));
			  if(oTemp.isDisplayed()){
				  oTemp.click();
				  isObjectDisplayed = true;
			  }
		  } catch(Exception e) {
			  //e.printStackTrace();
		  }	  
		  return isObjectDisplayed;
	 }
	

}
