package YahooMail.pages;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import YahooMail.utility.*;


import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import java.awt.AWTException;

import java.io.File;
import java.io.IOException;


public class YahooDemo {

	static AndroidDriver driver;

	By Yahoo_Signin_button = By.id("com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link");
	By Yahoo_Signin_Username = By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By Yahoo_Signin_Next = By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.Button[1]");
	By Yahoo_Signin_Password_Text = By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]");
	By Yahoo_Signin_Password_Next = By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[3]");
	By Yahoo_Back_to_Home = By.id("com.yahoo.mobile.client.android.mail:id/button_back");
	By Yahoo_Home_Close_Other_Folder = By.id("com.yahoo.mobile.client.android.mail:id/close_button");
	By Yahoo_Home_Customize_Close = By.xpath("/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
	By yahoo_Compose = By.id("com.yahoo.mobile.client.android.mail:id/right_button_1");
	By Yahoo_Schedule_Close = By.id("com.yahoo.mobile.client.android.mail:id/close_button");
	By Yahoo_mail_Suggestion_Close = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.ListView/android.view.View/android.widget.Button[2]");
	By Yahoo_mail_Subject_Field = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText");
	By Yahoo_mail_send = By.id("com.yahoo.mobile.client.android.mail:id/send");
	By Yahoo_mail_ErrorMsg_popup = By.id("com.yahoo.mobile.client.android.mail:id/message");
	By Yahoo_mail_Dont_send = By.id("com.yahoo.mobile.client.android.mail:id/left_button");
	By Yahoo_mail_Body_TextField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.widget.EditText");
	By Yahoo_mail_ID = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView");
	By Yahoo_mail_ID_EditText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]");
	By Yahoo_mail_CC_Field = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText");
	By Yahoo_mail_InvalidID = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[2]");
	By Yahoo_mail_Remove_Invalid = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button");
	By Yahoo_mail_Sent_Message = By.id("com.yahoo.mobile.client.android.mail:id/toast_message");
	By Yahoo_Signin_userError = By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
	By Yahoo_mail_back = By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]");
	By Yahoo_mail_delete_draft = By.xpath("com.yahoo.mobile.client.android.mail:id/toast_button");
	

	/* Testcase to send an email successfully */

	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	String NoSubjectMsg = "This message has no subject. Send anyway?";
	String Subject = "Demo";
	String NoBodyMsg = "This message is empty. Send anyway?";
	String InvalidRecepientMsg = "This message has invalid recipients. Send anyway?";
	String InvalidUserName = "test@.com";
	String InvalidUserName_ErrorMsg = "Sorry, we don't recognize this account.";
	String Invalidpassword = "test@com";
	String InvalidPassword_ErrorMsg = "Sorry, we don't recognize this account.";

	@Before

	public void Report() {

		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\testReport.html");
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setOfflineMode(true);
		sparkReporter.config().setDocumentTitle("Simple Automation Report");
		sparkReporter.config().setReportName("Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a ");
		sparkReporter.config().setEncoding("UTF-8");
	}

	public String screenshotmsg(Status Pass, String msg) throws IOException {

		String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
		System.out.println(s);
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/" + msg + ".png"));
		File Destfile = new File("./Screenshots/" + msg + ".png");
		String destinationFilePath = Destfile.getAbsolutePath();
		extentTest.addScreenCaptureFromPath(destinationFilePath, msg);

		return msg;

	}


	@Test
	public void LaunchYahooapp() throws AWTException, IOException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("AUTOMATION_NAME", "UiAutomator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "OnePlus Nord");
		cap.setCapability("udid", "98441d77");
		cap.setCapability("platformVersion", "12.0");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("appPackage", "com.yahoo.mobile.client.android.mail");
		cap.setCapability("appActivity", ".activity.MainActivity");
		cap.setCapability("nativeWebTap", true);
		cap.setCapability("unicodeKeyboard", false);
		cap.setCapability("resetKeyboard", false);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		Actions action = new Actions(driver);
		
		FluentWait<AndroidDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NotFoundException.class);

		extentTest = extent.createTest("Signing in an Mail, drafting the mail and sending the mail with all the possible Edge scenarios scenario");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_button));
		
		screenshotmsg(Status.PASS, "YahooSign in Page is launched");

		driver.findElement(Yahoo_Signin_button).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_Username));

		driver.findElement(Yahoo_Signin_Username).click();

		action.sendKeys(InvalidUserName).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_Next));

		driver.findElement(Yahoo_Signin_Next).click();


		/* Checking the Invalid user name scenario */
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_userError));

		Assert.assertTrue(driver.findElement(Yahoo_Signin_userError).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_Signin_userError).getText().trim().replaceAll("\n", "").contains(InvalidUserName_ErrorMsg));

		driver.navigate().back();

		driver.findElement(Yahoo_Signin_button).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_Username));

		driver.findElement(Yahoo_Signin_Username).click();

		action.sendKeys(PropertyFileReader.getProperty("username")).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_Next));

		driver.findElement(Yahoo_Signin_Next).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_Password_Text));

		driver.findElement(Yahoo_Signin_Password_Text).click();

		action.sendKeys(Invalidpassword).perform();

		driver.findElement(Yahoo_Signin_Next).click();
		

		/* Checking the Invalid Password scenario */

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Signin_userError));

		driver.findElement(Yahoo_Signin_Password_Text).click();

		action.sendKeys(PropertyFileReader.getProperty("password")).perform();

		driver.findElement(Yahoo_Signin_Password_Next).click();
		

		/* Compose a new email and send it */
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Back_to_Home));

		driver.findElement(Yahoo_Back_to_Home).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Home_Close_Other_Folder));

		driver.findElement(Yahoo_Home_Close_Other_Folder).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Home_Customize_Close));

		driver.findElement(Yahoo_Home_Customize_Close).click();

		screenshotmsg(Status.PASS, "Yahoomail Homepage is displayed");

		driver.findElement(yahoo_Compose).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_Schedule_Close));

		driver.findElement(Yahoo_Schedule_Close).click();

		action.sendKeys("tdemo321@myyahoo.com").perform();

		screenshotmsg(Status.PASS, "Navigated to Mail Compose screen and entered Valid username");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Suggestion_Close));

		driver.findElement(Yahoo_mail_Suggestion_Close).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Subject_Field));
		
		driver.findElement(Yahoo_mail_Subject_Field).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_send));

		driver.findElement(Yahoo_mail_send).click();
		

		/* Checking the error message of sending an email with No subject scenario */

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(NoSubjectMsg));

		screenshotmsg(Status.PASS, "Tried to send the mail without entering Subject and validated the Error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Subject_Field));

		driver.findElement(Yahoo_mail_Subject_Field).click();

		action.sendKeys(Subject).perform();

		driver.findElement(Yahoo_mail_send).click();
		
		

		/*Checking the error message of sending an email with No message in the body scenario  */

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(NoBodyMsg));

		screenshotmsg(Status.PASS,"Entered Subject but tried to send the mail ithout any message and validated the error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Body_TextField));

		driver.findElement(Yahoo_mail_Body_TextField).click();

		action.sendKeys("Hi,\n" + "This is a Demo for Appium MobileAutomation Testing.").perform();

		driver.navigate().back();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ID));

		driver.findElement(Yahoo_mail_ID).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Remove_Invalid));

		driver.navigate().back();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ID_EditText));

		driver.findElement(Yahoo_mail_ID_EditText).click();

		action.sendKeys("test@yahoo").perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_CC_Field));

		driver.findElement(Yahoo_mail_CC_Field).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_send));

		driver.findElement(Yahoo_mail_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(InvalidRecepientMsg));

		screenshotmsg(Status.PASS,"Filled out all the details including an invalid recepient and tried to send it and validated the error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_InvalidID));

		driver.findElement(Yahoo_mail_InvalidID).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Remove_Invalid));

		driver.findElement(Yahoo_mail_Remove_Invalid).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_send));

		driver.findElement(Yahoo_mail_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Sent_Message));

		Assert.assertTrue(driver.findElement(Yahoo_mail_Sent_Message).isDisplayed());

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Sent_Message));

		SeleniumUtils.waitForSeconds(3);

		screenshotmsg(Status.PASS, "Removed the invalid recepient and sent the email successfully");
		

		
		/* Drafting a mail Scenario */
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(yahoo_Compose));

		driver.findElement(yahoo_Compose).click();

		SeleniumUtils.waitForSeconds(3);

		action.sendKeys(PropertyFileReader.getProperty("username")).perform();

		screenshotmsg(Status.PASS, "Navigated to Mail Compose screen and entered Valid username");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Subject_Field));
		
		driver.findElement(Yahoo_mail_Subject_Field).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_send));

		driver.findElement(Yahoo_mail_send).click();
		
		

		/* Checking the error message of sending an email with No subject scenario */

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(NoSubjectMsg));

		screenshotmsg(Status.PASS, "Tried to send the mail without entering Subject and validated the Error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Subject_Field));

		driver.findElement(Yahoo_mail_Subject_Field).click();

		action.sendKeys(Subject).perform();

		driver.findElement(Yahoo_mail_send).click();
		
		

		/* Checking the error message of sending an email with No message in the body scenario */

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(NoBodyMsg));

		screenshotmsg(Status.PASS,"Entered Subject but tried to send the mail ithout any message and validated the error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Body_TextField));

		driver.findElement(Yahoo_mail_Body_TextField).click();

		action.sendKeys("Hi,\n" + "This is a Demo for Appium MobileAutomation Testing.").perform();

		driver.navigate().back();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ID));

		driver.findElement(Yahoo_mail_ID).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Remove_Invalid));

		driver.navigate().back();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ID_EditText));

		driver.findElement(Yahoo_mail_ID_EditText).click();

		action.sendKeys("test@yahoo").perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_CC_Field));

		driver.findElement(Yahoo_mail_CC_Field).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_send));

		driver.findElement(Yahoo_mail_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_ErrorMsg_popup));

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).isDisplayed());

		Assert.assertTrue(driver.findElement(Yahoo_mail_ErrorMsg_popup).getText().trim().replaceAll("\n", "").equals(InvalidRecepientMsg));

		screenshotmsg(Status.PASS,"Filled out all the details including an invalid recepient and tried to send it and validated the error message");

		driver.findElement(Yahoo_mail_Dont_send).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_InvalidID));

		driver.findElement(Yahoo_mail_InvalidID).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_Remove_Invalid));

		driver.findElement(Yahoo_mail_Remove_Invalid).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Yahoo_mail_back));

		driver.findElement(Yahoo_mail_back).click();

		SeleniumUtils.waitForSeconds(3);

		screenshotmsg(Status.PASS, "Saved the mail as draft successfully");
		
		extent.flush();
	}

}