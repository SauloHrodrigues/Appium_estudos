package desafios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DesafiosAppium {

	@Test
	public void primeiroDesafio_deveValidarDadosSalvos() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
				+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
		
		AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
				+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
//		1- Clicar no formulário
		
		MobileElement linkFormulario = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
		linkFormulario.click();		
		
//		2- Preencher todos os campos
		
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Saulo Henrique");

		MobileElement caixaOpcoe = driver.findElement(MobileBy.AccessibilityId("console"));
		caixaOpcoe.click();	
		
		MobileElement opcNintendoSwitch = driver.findElement(MobileBy.xpath("//*[@text='Nintendo Switch']"));
		opcNintendoSwitch.click();
		
		MobileElement checkBox = driver.findElement(MobileBy.AccessibilityId("check"));
		checkBox.click();
		
		MobileElement switchBox = driver.findElement(MobileBy.AccessibilityId("switch"));
		switchBox.click();	
				
//		3- Clicar no botão salvar
		
		MobileElement botaoSalvar = driver.findElement(MobileBy.className("android.widget.Button"));
		botaoSalvar.click();
		
//		4- Válidar campos preenchitos 
		
		MobileElement retornoNome = driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Nome')]"));
		MobileElement retornoSwitch = driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
		MobileElement retornoCheck = driver.findElement(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
//		System.out.println(retornoSwitch.getText());
		Assert.assertTrue(retornoNome.getText().contains("Saulo Henrique"));
		Assert.assertTrue(retornoSwitch.getText().endsWith("Off"));
		Assert.assertEquals("Checkbox: Marcado", retornoCheck.getText());
		driver.closeApp();
	}
}