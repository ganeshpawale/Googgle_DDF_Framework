package DD_Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_013 extends Test_Core{


@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_013"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
    @Test(dataProvider="getData")
    public void google_Language(String mailid,String passward,String username) throws InterruptedException
    {
	System.out.println("*********************TC_013 Execution Start*********************");
		
		account_Login(mailid,passward);
		boolean compose_btn_status,to_link_status,cc_link_status,bcc_link_status,subject_textbox_status,recipients_area_status,attache_files_status,send_button_status;
		
		Thread.sleep(7000);
		//String parent_win=driver.getWindowHandle();
		//System.out.println("Before switching title is:>>:"+driver.getTitle());
		
		compose_btn_status=isElementPresent(By.cssSelector(object.getProperty("compose_btn")));
		if(compose_btn_status) 
		{
			driver.findElement(By.cssSelector(object.getProperty("compose_btn"))).click();
		}
		else 
		{
			System.out.println("Compose button not found");
		}
		
		Thread.sleep(3000);
		//int iframes=driver.findElements(By.tagName("iframe")).size();
		
		//System.out.println("Total frame is:>>:"+iframes);
		
		to_link_status=isElementPresent(By.xpath(object.getProperty("to_link")));
		/*if(to_link_status.!true) 
		{
			System.out.println("To link is not Present");
		}*/
		//System.out.println("to status:>>:"+to_link_status);
		
		cc_link_status=isElementPresent(By.xpath(object.getProperty("cc_link")));
		//System.out.println("cc status:>>:"+cc_link_status);
		
		bcc_link_status=isElementPresent(By.xpath(object.getProperty("bcc_link")));
		//System.out.println("bcc status:>>:"+bcc_link_status);
		
		recipients_area_status=isDisplayedElement(By.xpath(object.getProperty("recipients_area")));
		//System.out.println("recipients_area_status:>>:"+recipients_area_status);
		
		subject_textbox_status=isDisplayedElement(By.xpath(object.getProperty("subject_textbox")));
		//System.out.println("subject status:>>:"+subject_textbox_status);
		
		attache_files_status=isElementPresent(By.xpath(object.getProperty("attache_files")));
		//System.out.println("attache status:>>:"+attache_files_status);
		
		send_button_status=isElementPresent(By.xpath(object.getProperty("send_button")));
		//System.out.println("attache status:>>:"+send_button_status);
		
		
		
		if(compose_btn_status && to_link_status && cc_link_status && bcc_link_status && subject_textbox_status && recipients_area_status && attache_files_status && send_button_status)
		{
			System.out.println("Compose Dialogbox is Exists...-Passed");
			app_log.debug("Compose Dialogbox is Exists...-Passed");
		}
		else 
		{
			System.out.println("Compose Dialogbox is not Exists...-Failed");
			app_log.debug("Compose Dialogbox is Exists...-Failed");
		}
		
		
    }
    
    @DataProvider
    public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
}