import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSortingJavaStreams 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//span[normalize-space()='Veg/fruit name']")).click(); //Clicking the web element to sort the values within the table
		List <WebElement> veggieList = driver.findElements(By.xpath("//tr/td[1]")); //Locate values within the table
		List <String> origVeggieList = veggieList.stream().map(s->s.getText()).collect(Collectors.toList()); //Store located values within the table thru streams and storing it to a new list (origVeggieList)
		List <String> sortedVeggieList = origVeggieList.stream().sorted().collect(Collectors.toList()); //New list stored will be sorted and storing it again to a new list (sortedVeggieList)
		Assert.assertTrue(origVeggieList.equals(sortedVeggieList)); //Comparing lists if values match (origVeggieList and sortedVeggieList)
	}
}
