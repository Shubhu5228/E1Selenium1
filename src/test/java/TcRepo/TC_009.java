package TcRepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericutility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;

@Listeners(genericutility.ListenerImplementation.class)
public class TC_009 extends BaseClass 

{
	@Test
	public void CON_01() throws Exception 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsHome();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();
		//Assert.fail();
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		String fName = eUtil.getDataFromExcel("Contacts", 2, 1);
		String lName = eUtil.getDataFromExcel("Contacts", 2, 2);
		String title = eUtil.getDataFromExcel("Contacts", 2, 3);
		cnp.createNewContact(fName, lName, title);
		Thread.sleep(3000);
	}
}