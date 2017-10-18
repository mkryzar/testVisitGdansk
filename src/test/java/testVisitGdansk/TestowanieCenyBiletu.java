package testVisitGdansk;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestowanieCenyBiletu {
	private WebDriver driver;
	private TestCeny util;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://visitgdansk.com/");
		util = new TestCeny(driver);
	}
	
	@Test
	public void testCenyZakupuBiletu() {
		util.klikniecieZakladkiKartaTurysty();
		util.przekierowanieNaKupnoBiletu();
		util.dodanieNormalnegoBiletu();
		util.waitForAjax();
		util.wybranieOpcjiBiletu();
		util.waitForAjax();
		util.pobranieCenyBiletu();
		util.waitForAjax();
		util.pobranieKwotyTotal();
		
		assertEquals(util.pobranieKwotyTotal(), util.pobranieCenyBiletu() );
	}
	
	
	
}
