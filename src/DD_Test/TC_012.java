


package DD_Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_012 extends Test_Core{


	@BeforeTest
		
		public void isSkip()
		{
			if(!Test_Util.isExecutable("TC_012"))
			{
				throw new SkipException("Skiping the test case as run mode set to NO");
			}
		}
	
	@Test(dataProvider="getData")
	public void user_Login_Gmail(String mailid,String passward,String username) throws InterruptedException 
	{
		System.out.println("*********************TC_012 Execution Start*********************");
		
		account_Login(mailid,passward);
		int for_count_loop;
		
        String total_string=driver.findElement(By.xpath(object.getProperty("actual_number_string"))).getText();
		String s1=total_string.trim().replaceAll("^(\\S*\\s){2}","");
	    int actual_mail=Integer.valueOf(s1);
		System.out.println("Actual mail in number format:>>:"+actual_mail);
	    String s2=total_string.trim().substring(2,4);
	    int div=Integer.valueOf(s2);
	    for_count_loop=actual_mail/div;
		System.out.println("for_count_loop value is integer:>>:"+for_count_loop);
		int unreadCount = 0,readCount = 0;;
		
		
		for(int d=1;d<=for_count_loop+1;d++)
	    {
	    	WebElement Flag_GmailWebTable = driver.findElement(By.className("UI"));
	    	List<WebElement> Flag_rows_GmailWebTable  = Flag_GmailWebTable.findElements(By.tagName("tr"));
	    	
		  
	    	int Flag_rows_Count = Flag_rows_GmailWebTable.size();
	    	
	    	for(int row=0;row<Flag_rows_Count;row++) 
	    	{
	    		String class_name=Flag_rows_GmailWebTable.get(row).getAttribute("class").replaceAll("\\s+","").trim();
	 
	    		//Thread.sleep(2000);
	    		if(class_name.equalsIgnoreCase("zAyO") || class_name.equalsIgnoreCase("zAyOaqw")) 
	    		{
	    			String fontWeight = Flag_rows_GmailWebTable.get(row).findElement(By.className("yP")).getCssValue("fontWeight");
	    			if(fontWeight.equals("normal"))
	    			{
	    				readCount++;
	    			}
	    		}
	    		else if(class_name.equalsIgnoreCase("zAzE") || class_name.equalsIgnoreCase("zAzEaqw")) 
	    		{
	    			String fontWeight = Flag_rows_GmailWebTable.get(row).findElement(By.className("zF")).getCssValue("fontWeight");
	    			if(fontWeight.equals("bold"))
	    			{
	    				unreadCount++;
	    			}
	    			//System.out.println("UnRead mail:"+unreadCount);
	    		}
	    		else 
	    		{
	    			Thread.sleep(2000);
	    			System.out.println("Class name is not match:>>:"+class_name);
	    		}
	    	}		   
		    Thread.sleep(5000);
			driver.findElement(By.cssSelector(object.getProperty("right_direction"))).click();
		    Thread.sleep(8000);
	   }
		
		System.out.println("Read mail:>>:"+readCount);
		System.out.println("UnRead mail:>>:"+unreadCount);
		
		//Check unread mail equal to real count unread mails
		
		
		/*Thread.sleep(10000);
		String actual_unread_mail=driver.findElement(By.xpath(object.getProperty("actual_unread_mail"))).getText();
		    //String total_string=driver.findElement(By.xpath(object.getProperty("actual_number_string"))).getText();
		System.out.println("actual_unread_mail:>>:"+actual_unread_mail);*/
		  //String numberOnly= actual_unread_mail.replaceAll("[^0-9]","");
		  //System.out.println(numberOnly);
		 // numberOnly.trim();
		/*int actual_unread_mail_number=Integer.valueOf(actual_unread_mail);
		System.out.println("Real unread number is:>>:"+actual_unread_mail_number);
		*/
		
	}
	

	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
	
}