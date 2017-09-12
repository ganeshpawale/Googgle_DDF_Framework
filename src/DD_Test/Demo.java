package DD_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class Demo extends Test_Core{

	 @Test(dataProvider="getData")
	 public void google_Language(String mailid,String passward,String username,String To_mailid,String Cc_mailid,String Bcc_mailid,String Subject_text,String Message_body_text) throws InterruptedException
	    {
		   account_Login(mailid, passward);
		   
		  //driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/?tab=wm#sent']")).click();
		   //element.click();
		   
		   driver.findElement(By.xpath("//*[contains(@id,':')]/div/div[2]/span/a[1][@title='Sent Mail']")).click();
	    }
	
	 @DataProvider
	    public static Object[][] getData()
		{
			return Test_Util.getData("TC_014");
		}
}
