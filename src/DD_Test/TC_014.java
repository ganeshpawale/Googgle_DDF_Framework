package DD_Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_014 extends Test_Core{


@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_013"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
    @Test(dataProvider="getData")
    public void google_Language(String mailid,String passward,String username,String To_mailid,String Cc_mailid,String Bcc_mailid) throws InterruptedException
    {
	System.out.println("*********************TC_013 Execution Start*********************");
		
		account_Login(mailid,passward);
		boolean compose_btn_status,to_link_status,to_textarea,cc_link_status,Bcc_link_status,subject_textbox_status,recipients_area_status,attache_files_status,send_button_status;
		
		Thread.sleep(7000);
		//String parent_win=driver.getWindowHandle();
		//System.out.println("Before switching title is:>>:"+driver.getTitle());
		
		//compose button verification
		compose_btn_status=isElementPresent(By.cssSelector(object.getProperty("compose_btn")));
		if(compose_btn_status) 
		{
			driver.findElement(By.cssSelector(object.getProperty("compose_btn"))).click();
		}
		else 
		{
			System.out.println("Compose button not found");
		}
		/*
		//To_textarea verification 
		to_link_status=isElementPresent(By.xpath(object.getProperty("to_textarea_xpath")));
		if(to_link_status) 
		{
			driver.findElement(By.xpath(object.getProperty("to_textarea_xpath"))).sendKeys(To_mailid,Keys.ENTER);
			
		System.out.println("Send mail into To_textarea");
		}
		else 
		{
			System.out.println("Mail not send into To_textarea");
		}
		
		//Cc_textarea verification
		
		cc_link_status=isElementPresent(By.xpath(object.getProperty("cc_textarea_xpath")));
		//System.out.println("CC mail id is:>>:"+Cc_mailid);
		if(cc_link_status) 
		{
		     driver.findElement(By.xpath(object.getProperty("cc_link"))).click();
		     Thread.sleep(3000);
			 driver.findElement(By.xpath(object.getProperty("cc_textarea_xpath"))).sendKeys(Keys.LEFT);
			 driver.findElement(By.xpath(object.getProperty("cc_textarea_xpath"))).sendKeys(Cc_mailid);
			 System.out.println("Send mail into Cc_textarea");
		}
		else 
		{
			System.out.println("Mail not send into Cc_textarea");
		}
		
		*/
		//Bcc_textarea verification
		
		/*Bcc_link_status=isElementPresent(By.xpath(object.getProperty("Bcc_textarea_xpath")));
		System.out.println("Bcc mail id is:>>:"+Bcc_mailid);
		if(Bcc_link_status) 
		{
		     driver.findElement(By.xpath(object.getProperty("Bcc_link_st"))).click();
		     Thread.sleep(3000);
			 driver.findElement(By.xpath(object.getProperty("Bcc_textarea_xpath"))).sendKeys(Keys.LEFT);
			 driver.findElement(By.xpath(object.getProperty("Bcc_textarea_xpath"))).sendKeys(Bcc_mailid);
			 System.out.println("Send mail into Bcc_textarea");
		}
		else 
		{
			System.out.println("Mail not send into Bcc_textarea");
		}
		*/
		
		driver.findElement(By.xpath("//span[@id=':pa']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println("to status:>>:"+to_link_status);
		
/*		
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
		}*/
		
		
    }
    
    @DataProvider
    public static Object[][] getData()
	{
		return Test_Util.getData("TC_014");
	}
}