package TcRepo;

import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_01Test extends BaseClass 
{
	@Test
	public void LE_01() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage leP=new LeadsPage(driver);
		leP.clickOnCreateNewLeadIcon();
		CreatingNewLeadPage clp=new CreatingNewLeadPage(driver);
		String fName=eUtil.getDataFromExcel("Leads", 2, 1);
		String lName=eUtil.getDataFromExcel("Leads", 2, 2);
		String Company=eUtil.getDataFromExcel("Leads", 2, 3);
		clp.createNewLead(fName, lName, Company);
		
	}


}
