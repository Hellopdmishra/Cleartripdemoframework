package com.cleartrip.Testdata;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.Base.TestBase;
import com.cleartrip.Pages.FlightsPage;







public class PlanAtripTest extends TestBase {
	
	FlightsPage flightpage;

	public PlanAtripTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();		
		flightpage = new FlightsPage();	
	}
	
	@Test(description="Veify search flight")
	public void Searchflight() throws InterruptedException {
		flightpage.SearchFlight();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

