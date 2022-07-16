package Utilities;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class BaseClass {

	static WebDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor jse;

	protected static Logger logger = LogManager.getLogger(BaseClass.class);

	@BeforeAll()
	public static void before_all() {
		logger.info("Before ALL");
		cleanUpOldFiles(getProperty("src/test/resources/app.properties", "old_files_path_t"), Integer.parseInt(getProperty("src/test/resources/app.properties", "days_deletion")));
		cleanUpOldFiles(getProperty("src/test/resources/app.properties", "old_files_path_l"), Integer.parseInt(getProperty("src/test/resources/app.properties", "days_deletion")));
		cleanUpOldFiles(getProperty("src/test/resources/app.properties", "old_files_path_s"), Integer.parseInt(getProperty("src/test/resources/app.properties", "days_deletion")));
}

	@AfterAll()
	public static void after_all() {
		logger.info("After ALL");
	}

	@Before
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getProperty("src/test/resources/app.properties", "timeOut_duration"))));
		jse = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get(getProperty("src/test/resources/app.properties", "app_url"));
		logger.info("Chrome Browser Launched..."+driver.getCurrentUrl());
	}

	public void sendInput(By locator, String input) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		element.sendKeys(input);
		logger.info("Sent Input successfully --> "+element);
	}

	public void clickElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.click();
		logger.info("Element clicked successfully --> "+element);
	}

	public String getText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		scrollToElement(element);
		HighlightElement(element);
		return element.getText();
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if(scenario.isFailed()) {
			try {
				logger.info("Taking screenshot...");
				captureScreenshot(scenario);
				logger.info("Browser closed...");
				driver.close();
			}catch(Exception e) {
				driver.quit();
				logger.info("FAILED --> Browser closed...");
			}
		}
		else {
			try {
				logger.info("Browser closed...");
				driver.close();
			}catch(Exception e) {
				driver.quit();
				logger.info("FAILED --> Browser closed...");
			}
		}

	}

	//	public void captureScreenshot() {
	//		Date date = new Date();
	//		String time = String.valueOf(date.getTime());
	//		//Take the screenshot
	//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   
	//		//Copy the file to a location and use try catch block to handle exception
	//		try {
	//			FileUtils.copyFile(screenshot, new File("Screenshots/SS_Error"+time+".png"));
	//		} catch (Exception e) {
	//			logger.info(e.getMessage());
	//		}
	//	}

	public void captureScreenshot(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		//Take the screenshot
		scenario.log("This is failure screenshot");
		byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);   
		//Copy the file to a location and use try catch block to handle exception
		try {
			scenario.attach(screenshot, "image/png", screenshotName);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void HighlightElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
		}catch (Exception e) {
			logger.info("Failed to highlight an element --> "+element);
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].scrollIntoView(false);", element);
		}catch(Exception e) {
			logger.info("Failed to scroll to an element --> "+element);
		}
	}

	public static String getProperty(String filepath, String propertyName) {

		try {
			FileReader fr = new FileReader(filepath);
			Properties props = new Properties();
			props.load(fr);
			return props.getProperty(propertyName);
		} catch (Exception e) {
			logger.info("Failed to get property");
		}
		return null;		
	}

	private static void cleanUpOldFiles(String folderPath, int expirationPeriod) {
		File targetDir = new File(folderPath);
		if (!targetDir.exists()) {
			throw new RuntimeException(String.format("Log files directory '%s' " +
					"does not exist in the environment", folderPath));
		}

		File[] files = targetDir.listFiles();
		for (File file : files) {
			long diff = new Date().getTime() - file.lastModified();

			// Granularity = DAYS;
			long desiredLifespan = TimeUnit.DAYS.toMillis(expirationPeriod); 

			if (diff > desiredLifespan) {
				logger.info("Expiration Period : "+expirationPeriod);
				logger.info("DELETING ---> "+file.getName());
				file.delete();
			}
		}
	}
}
