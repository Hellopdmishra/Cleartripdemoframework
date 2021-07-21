package com.cleartrip.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.Base.TestBase;




public class FlightsPage extends TestBase {

	

	@FindBy(xpath="(//input[@placeholder=\"Any worldwide city or airport\"])[1]")
	WebElement Flightfrom;
	
	@FindBy(xpath="//p[text()=\"Mumbai, IN - Chatrapati Shivaji Airport (BOM)\"]")
	WebElement Filghtfrommum;
	
	@FindBy(xpath="(//input[@placeholder=\"Any worldwide city or airport\"])[2]")
	WebElement FlightTo;
	
	@FindBy(xpath="//p[text()=\"New Delhi, IN - Indira Gandhi Airport (DEL)\"]")
	WebElement FilghtToDel;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/label[2]/div[1]")
	WebElement RoudtripRadio;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[3]/div/div/div/div/button[1]")
	WebElement DepartDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[3]/div/div/div/div/button[2]")
	WebElement ReturnDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select")
	WebElement Adults;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[3]/select")
	WebElement Children;
	
	@FindBy(xpath="//button[text()=\"Search flights\"]")
	WebElement Searchflighbutton;
	
	
	
	public FlightsPage(){
			PageFactory.initElements(driver, this);
		}	
	
	public FlightsPage SearchFlight() throws InterruptedException {
		//select from location
		Flightfrom.sendKeys("mum");
		Filghtfrommum.click();
		//select to location
		FlightTo.sendKeys("delhi");
		FilghtToDel.click();
		RoudtripRadio.click(); 
	    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	    Calendar today = Calendar.getInstance(); 
	    today.add(Calendar.DATE, 2);             
	    String firstDate = dateFormat.format(today.getTime());	    
	  //enter Depart date in the field
	    DepartDate.sendKeys(firstDate);
	    today.add(Calendar.DATE, 4);             
	    String secondDate = dateFormat.format(today.getTime());
	  //enter Return date in the field
	    ReturnDate.sendKeys(secondDate);
	  //selecting adults
	    Select SlctAdults = new Select(Adults);
	    SlctAdults.selectByValue("2");
	  //selecting Children
	    Select SlctCldrn = new Select(Children);
	    SlctCldrn.selectByValue("1");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,450)", "");
	    Thread.sleep(5000);
	    Actions act = new Actions(driver);
	    act.doubleClick(Searchflighbutton).perform();
	    Thread.sleep(5000);
		return new FlightsPage();
	}
}

