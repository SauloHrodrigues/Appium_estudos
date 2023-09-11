package secao02_primeira_execucao.calculadora_teste;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;




public class FormularioTeste {
	
//	@Test // => instala aplicativo externo a app store
	public void deveInstalarAPK() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
//	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
//	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
	    		+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
	   
	   
	    AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
	    		+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.quit();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
//	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
//	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
				+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
		
		AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
				+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		selecionar Formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		
//		for(MobileElement elemento : elementosEncontrados) {
//			System.out.println(elemento.getText());
//		}
		
		elementosEncontrados.get(1).click();
		
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome") );
		campoNome.sendKeys("Saulo");
		
//		Veroficar texto escrito
		
		String textoDoCampo = campoNome.getText();
		
		Assert.assertEquals("Saulo", textoDoCampo);
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
//	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
//	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
				+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
		
		AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
				+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		selecionar Formulario
//		//class[@text='value']
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	
//		clicar no combo
		
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
//		Selecionar a opção
		
		driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
//		verificar a opção selecionada

		String elementoSelecionado = driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		
		Assert.assertEquals("PS4", elementoSelecionado);
		driver.quit();
	}
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
//	    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
//	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
				+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
		
		AndroidDriver<MobileElement> driver= new AndroidDriver(new URL(""
				+ "http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		selecionar Formulario
//		//class[@text='value']
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
//		Verificar status dos elementos
		
		MobileElement check = driver.findElement(MobileBy.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		Assert.assertEquals("false", check.getAttribute("checked"));
		Assert.assertEquals("true", switc.getAttribute("checked"));
//		clicar nos elementos
		
		check.click();
		switc.click();
		
//		Verificar estados alterado dos elementos
		
		Assert.assertEquals("true", check.getAttribute("checked"));
		Assert.assertEquals("false", switc.getAttribute("checked"));
		
		driver.quit();
	}
	
	
}
