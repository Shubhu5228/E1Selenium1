package TcRepo;

import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectRepo.CreatingNewOrganisationPage;
import objectRepo.HomePage;
import objectRepo.OrganisationsPage;

public class TC_005 extends BaseClass
{
	
	
	@Test
	public void ORG_01() throws Exception
	{
	
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationHome();
		OrganisationsPage orp = new OrganisationsPage(driver);
		orp.clickOnCreateNewOrganisationsIcon();
		CreatingNewOrganisationPage corp = new CreatingNewOrganisationPage(driver);
		String orgName = eUtil.getDataFromExcel("Organisations", 2, 1);
		String website = eUtil.getDataFromExcel("Organisations", 2, 2);
		String emp = eUtil.getDataFromExcel("Organisations", 2, 3);
		corp.createNewOrganisation(orgName, website, emp);
		
	}
}
