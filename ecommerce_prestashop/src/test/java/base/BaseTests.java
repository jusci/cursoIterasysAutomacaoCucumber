package base;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import pages.HomePage;

public class BaseTests {

	private static WebDriver driver; // declarando objeto do tipo WebDriver utilizado pelo selenium WebDriver
	protected HomePage homePage;

	@BeforeAll // metodo ser� executado antes de todas as classes de testes

	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\automacao\\curso_iterasys\\webdrivers\\chromedriver\\versao83\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeEach // antes de cada teste
	public void carregarPaginaInicial() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		homePage = new HomePage(driver);
	}

	public void capturarTela(String nomeTeste, String resultado) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);

		try {
			Files.move(capturaDeTela, new File("resources/screenshots/" + nomeTeste + "_" + resultado + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@AfterAll // depois que finaliza a execu��o de cada classe de teste

	public static void finalizar() {
		driver.quit();
	}
}
