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
    public void google_Language(String mailid,String passward,String username,String To_mailid,String Cc_mailid,String Bcc_mailid,String Subject_text,String Message_body_text) throws InterruptedException
    {
	System.out.println("*********************TC_013 Execution Start*********************");
		
	   // driver.manage().window().maximize();
		account_Login(mailid,passward);
		boolean compose_btn_status,to_link_status,to_textarea,cc_link_status,Bcc_link_status,subject_textbox_status,recipients_area_status,message_body_area,attache_files_status,send_button_status,sent_mail_link;
		
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
	
		//To_textarea verification 
		to_link_status=isElementPresent(By.xpath(object.getProperty("to_textarea_xpath")));
		if(to_link_status) 
		{
			driver.findElement(By.xpath(object.getProperty("to_textarea_xpath"))).sendKeys(To_mailid,Keys.ENTER);
			
		//System.out.println("Send mail into To_textarea");
		}
		else 
		{
			System.out.println("Mail not send into To_textarea");
		}
		
		//Cc_textarea verification
		
		cc_link_status=isElementPresent(By.xpath(object.getProperty("cc_textarea_xpath")));
		//System.out.println("CC mail id is:>>:"+Cc_mailid);.
		if(cc_link_status) 
		{
		     driver.findElement(By.xpath(object.getProperty("cc_link"))).click();
		     Thread.sleep(3000);
			 driver.findElement(By.xpath(object.getProperty("cc_textarea_xpath"))).sendKeys(Keys.LEFT);
			 driver.findElement(By.xpath(object.getProperty("cc_textarea_xpath"))).sendKeys(Cc_mailid);
			 //System.out.println("Send mail into Cc_textarea");
		}
		else 
		{
			System.out.println("Mail not send into Cc_textarea");
		}
		
		
		/*//Bcc_textarea verification
		
		Bcc_link_status=isElementPresent(By.xpath(object.getProperty("Bcc_textarea_xpath")));
		System.out.println("Bcc mail id is:>>:"+Bcc_mailid);
		if(Bcc_link_status) 
		{
		     driver.findElement(By.xpath("//span[@class='aB  gQ pB']")).click();
		     Thread.sleep(3000);
		     //driver.findElement(By.xpath("//*[@class='wO nr l1']/textarea")).sendKeys(Keys.LEFT);
		     driver.findElement(By.xpath("//span[@class='aB  gQ pB']")).sendKeys("ganesh777");
		     Thread.sleep(3000);
			// driver.findElement(By.xpath(object.getProperty("Bcc_textarea_xpath"))).sendKeys(Keys.LEFT);
			// driver.findElement(By.xpath(object.getProperty("Bcc_textarea_xpath"))).sendKeys(Bcc_mailid);
			 //System.out.println("Send mail into Bcc_textarea");
		}
		else 
		{
			System.out.println("Mail not send into Bcc_textarea");
		}*/
		
	//subject textbox Verification
		
		subject_textbox_status=isElementPresent(By.xpath(object.getProperty("subject_textbox_xpath")));
		if(subject_textbox_status) 
		{
			driver.findElement(By.xpath(object.getProperty("subject_textbox_xpath"))).sendKeys(Subject_text);
		}
		else 
		{
			System.out.println("Subject is not send in subject_box");
		}
		
		
	//	Message body Verification
		
		message_body_area=isElementPresent(By.xpath(object.getProperty("Message_body_xpath")));
		if(message_body_area) 
		{
			driver.findElement(By.xpath(object.getProperty("Message_body_xpath"))).sendKeys(Message_body_text);
		}
		else 
		{
			System.out.println("Message is not send in textbox");	
		}
		
		//Send button verification
		send_button_status=isElementPresent(By.xpath(object.getProperty("send_button")));
		if(send_button_status) 
		{
			driver.findElement(By.xpath(object.getProperty("send_button"))).click();
			System.out.println("Email send successfully");
		}
		else 
		{
			System.out.println("Mail not send");
		}
		
		//Sent mail Verification
        
		sent_mail_link=isElementPresent(By.xpath(object.getProperty("sent_mail_link")));
		if(sent_mail_link) 
		{
			driver.findElement(By.xpath(object.getProperty("sent_mail_link"))).click();
		}
		else
		{
			System.out.println("Sent mail link is not Exist");
		}
    }
    
    @DataProvider
    public static Object[][] getData()
	{
		return Test_Util.getData("TC_014");
	}
}