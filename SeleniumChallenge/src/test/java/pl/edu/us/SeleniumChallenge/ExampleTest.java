package pl.edu.us.SeleniumChallenge;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;








public class ExampleTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testGoogle() {
		driver.get("http://google.pl");
		assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		driver.get("http://google.pl");
		WebElement searchInput = driver.findElement(By.id("lst-ib"));
		searchInput.sendKeys("instytut informatyki uś");
		searchInput.submit();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Instytut Informatyki")));
		final String previousURL = driver.getCurrentUrl();
		WebElement link = driver.findElement(By.linkText("Instytut Informatyki"));
		link.click();
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (driver.getCurrentUrl() != previousURL);
			}
        });
		assertEquals("Instytut Informatyki", driver.getTitle());
	}
	
	@Test
	public void testCalc() {
		
		assertEquals(35, multiply(driver, 7,5 ));
		SeleniumScreenshotHelper(driver, "D:\\test.jpg");

	}
	
	
	void SeleniumScreenshotHelper(WebDriver driver, String screenshotFileName){
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	int multiply(WebDriver driver, int multiplier, int multiplicand) {
	driver.get("http://www.anaesthetist.com/mnm/javascript/calc.htm");

	String multiplierStr="";
	String multiplicandStr="";
	
	switch(multiplicand){
	case 0: {
		multiplicandStr="zero";
		break;
		
	}
	case 1: {
		multiplicandStr="one";
		break;
		
	}
	case 2: {
		multiplicandStr="two";
		break;
		
	}
	case 3: {
		multiplicandStr="three";
		break;
		
	}
	case 4: {
		multiplicandStr="four";
		break;
		
	}
	case 5: {
		multiplicandStr="five";
		break;
		
	}
	case 6: {
		multiplicandStr="six";
		break;
		
	}

	case 7: {
		multiplicandStr="seven";
		break;
		
	}

	case 8: {
		multiplicandStr="eight";
		break;
		
	}

	case 9: {
		multiplicandStr="nine";
		break;
		
	}
	}
	
	
	
	
	switch(multiplier){
	case 0: {
		multiplierStr="zero";
		break;
		
	}
	case 1: {
		multiplierStr="one";
		break;
		
	}
	case 2: {
		multiplierStr="two";
		break;
		
	}
	case 3: {
		multiplierStr="three";
		break;
		
	}
	case 4: {
		multiplierStr="four";
		break;
		
	}
	case 5: {
		multiplierStr="five";
		break;
		
	}
	case 6: {
		multiplierStr="six";
		break;
		
	}

	case 7: {
		multiplierStr="seven";
		break;
		
	}

	case 8: {
		multiplierStr="eight";
		break;
		
	}

	case 9: {
		multiplierStr="nine";
		break;
		
	}
	}
	WebElement seven = driver.findElement(By.cssSelector("table [name='"+multiplierStr+"']"));
	seven.click();
	
	WebElement multiplication = driver.findElement(By.cssSelector("table [name='mul']"));
	multiplication.click();
	
	WebElement five = driver.findElement(By.cssSelector("table [name='"+multiplicandStr+"']"));
	five.click();
	
	WebElement result = driver.findElement(By.cssSelector("table [name='result']"));
	result.click();
	
	WebElement display = driver.findElement(By.cssSelector("table [name='Display']"));
	return Integer.parseInt(display.getAttribute("value"));
	}
}
