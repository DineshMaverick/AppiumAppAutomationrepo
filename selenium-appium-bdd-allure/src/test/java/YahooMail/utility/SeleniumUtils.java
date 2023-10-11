
package YahooMail.utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * Copyright (C) 2017 Clearstream.TV, Inc. All Rights Reserved.
 * Proprietary and confidential.
 * 
*/
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import YahooMail.utility.*;
import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


import java.net.URL;
import io.appium.java_client.remote.MobileCapabilityType;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;

public class SeleniumUtils
{

   private static int maxTimeout = Integer.parseInt(PropertyFileReader.getProperty(Constants.COMMON_WAIT_IN_SECONDS));
   private static final Logger LOG = LogManager.getLogger(PropertyFileReader.class);

   /**
    * waiting for seconds
    *
    * @param timeoutInSeconds
    *           timeout in seconds for wait
    */
   public static void waitForSeconds(int timeoutInSeconds)
   {
      try
      {
         Thread.sleep(timeoutInSeconds * 1000);
      }
      catch (InterruptedException e)
      {
         LOG.error("Thread interrupted error while timeout: " + e.getMessage());
         e.printStackTrace();
      }
   }

   public static List<String> getListFromWebElementsAsString(List<WebElement> columnListData)
   {
      List<String> elementList = new ArrayList<>();
      for (WebElement element : columnListData)
      {
         elementList.add(element.getText());
      }
      return elementList;

   }

  
   
}
