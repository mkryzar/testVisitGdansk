package testVisitGdansk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCeny {
	
	
	public boolean waitForAjax() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	private WebDriver driver;
	public TestCeny(WebDriver driver) {
		this.driver = driver;
	}
public void klikniecieZakladkiKartaTurysty() {
	WebElement element = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a"));
	element.click();
}

public void przekierowanieNaKupnoBiletu() {
	WebElement element = driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[9]/span"));
	element.click();
}

public void dodanieNormalnegoBiletu() {
	WebElement element = driver.findElement(By.xpath("//*[@id=\"fLiczbaOsob\"]/div/div/div[1]/div[2]/div/div/div[1]"));
	element.click();
}

public void wybranieOpcjiBiletu() {
	WebElement combo = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr/td[2]/div/select"));
	Select rodzaj = new Select(combo);
	rodzaj.selectByValue("135688");
	
}


public String pobranieCenyBiletu() {
	WebElement total = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr[1]/td[3]/strong"));
	String cena1 = total.getText();
	return cena1;
	
}
	
public String pobranieKwotyTotal() {
	WebElement total = driver.findElement(By.xpath("//*[@id=\"podsumowanie\"]/table/tbody/tr[2]/td[2]"));
	String cena2 = total.getText();
	return cena2;
	
}


}
