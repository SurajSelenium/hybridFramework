package generic;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebDriverCommonLib extends BaseTest{

	//This method is used to get the title of the webpage
	public String getTitleOfTheWebPage()
	{
		String titleOfTheWebPage = driver.getTitle();
		return titleOfTheWebPage;
	}

	//this method is used to verify the WePageTitle
	public void verifyTheTitleOfTheWebpage(String expectedTitle,String actualTitle,String pageName)
	{
		if (actualTitle.equals(expectedTitle))
		{
			System.out.println("The"+pageName+" page title is matching and TEST CASE IS PASSED");
		}
		else
		{
			System.out.println("The"+pageName+" page title is not  matching and TEST CASE IS FAILED");
		}

	}

	//this method is used to use the implicitely wait
	public void waitForElement(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//this method is used  for pageLoad ( Whenever we get new page this method can be used to avoid the synchronisation issue)
	public void waitForPageLoad(int time,String title)
	{
		WebDriverWait wb = new WebDriverWait(driver,time);
		wb.until(ExpectedConditions.titleContains(title));

	}


	//This method is used to perform the mouseHover Action
	public void mouseHoverOnTheElement(WebElement target)
	{
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
	}

	//This method is used to right click on the WebElement
	public void rightClick(WebElement target)
	{
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
	}


	//this method is used to perform the drag and drop operation
	public void dragAndDropWeblement(WebElement source,WebElement target )
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();

	}


	//this method is used to perform the double click action
	public void doubleClick(WebElement source,WebElement target )
	{
		Actions act = new Actions(driver);
		act.doubleClick(source).perform();

	}

	// This three continuous methods are overloaded methods can be used acodingly
	//--------------------------------------------------
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	//------------------------------------------------------------

	//----------------------------------------------------------
	//The instance where in the method overloading is used
	public void selectTheOption(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}


	public void selectTheOption(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}


	public void selectTheOption(String value,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	//----------------------------------------------------



	//explicitely wait for the WebElement
	public void waitForWebELement(int time,String text,WebElement element,String nameOfTheElement)
	{
		WebDriverWait wb = new WebDriverWait(driver,time);
		wb.until(ExpectedConditions.textToBePresentInElement(element, text));
		System.out.println("The " +nameOfTheElement+ " is displayed and Test is passed for Invalid Credentials");

	}


	//This method is designed to get all the options of the dropdown
	public void getOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		java.util.List<WebElement> ops = sel.getOptions();

		for(WebElement we:ops)
		{
			String dropdownOps = we.getText();
			System.out.println(dropdownOps);
		}



	}
}




