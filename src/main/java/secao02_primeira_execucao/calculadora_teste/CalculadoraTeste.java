package secao02_primeira_execucao.calculadora_teste;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;




public class CalculadoraTeste {
	
	@Test
	public void testeCalculadora() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	   
	   
	    AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
	    		+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    
	    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");
	    el4.click();
	    System.out.println("Conteudo = "+ el4.getText());
	    Assert.assertEquals("4", el4.getText());
	    driver.quit();
	}
}
