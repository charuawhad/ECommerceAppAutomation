package org.maven.groupid.testatifactid;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/Users/surajkute/eclipse-workspace/SeleniumFrameworkProject/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//adding multiple items into the cart
		String[] veggies = {"Cucumber","Tomato"};
		int j = 0;

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);

		// selecting all the product
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// System.out.println(products.get(i).getText());
			String[] name = products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			//Convert array into array list for easy search
			//Check whether name you extracted is present in arrayList or not
			List veggiesList = Arrays.asList(veggies);

			if (veggiesList.contains(formattedName)) {
				j++;
				// Click on Cucumber, Add to cart/product-action
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==3)
				{
					break;
				}

			}
		}
		//driver.close();

	}

}
