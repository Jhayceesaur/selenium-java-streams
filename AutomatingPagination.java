import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomatingPagination 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//span[normalize-space()='Veg/fruit name']")).click(); //Clicking the web element to sort the values within the table
		List <WebElement> itemList = driver.findElements(By.xpath("//tr/td[1]")); //Locate values within the table
		List <String> origItemList = itemList.stream().map(s->s.getText()).collect(Collectors.toList()); //Store located values within the table thru streams and storing it to a new list (origItemList)
		List <String> sortedItemList = origItemList.stream().sorted().collect(Collectors.toList()); //New list stored will be sorted and storing it again to a new list (sortedItemList)
		Assert.assertTrue(origItemList.equals(sortedItemList)); //Comparing lists if values match (origItemList and sortedItemList)
		
		List<String> price;
		do 
		{
		//Implement custom method
			List <WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getItePrice(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
		
				if (price.size()<1) 
				{
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
		}
		while (price.size()<1);
	}

	private static String getItePrice(WebElement s) 
	{
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); //Get values of the sibling element (price)
		return priceValue; 
	}
}
