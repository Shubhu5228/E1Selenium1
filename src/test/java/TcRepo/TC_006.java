package TcRepo;

import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectRepo.CreatingNewOrganisationPage;
import objectRepo.HomePage;
import objectRepo.OrganisationsPage;

public class TC_006 extends BaseClass
{
	@Test
	public void ORG_02() throws Exception 
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationHome();
		OrganisationsPage orp = new OrganisationsPage(driver);
		orp.clickOnCreateNewOrganisationsIcon();
		CreatingNewOrganisationPage corp = new CreatingNewOrganisationPage(driver);
		String orgName = eUtil.getDataFromExcel("Organisation", 5, 1);
		String website = eUtil.getDataFromExcel("Organisation", 5, 2);
		String employee = eUtil.getDataFromExcel("Organisation", 5, 3);
		String phNo = eUtil.getDataFromExcel("Organisation", 5, 4);
		String othPh = eUtil.getDataFromExcel("Organisation", 5, 5);
		String email = eUtil.getDataFromExcel("Organisation", 5, 6);
		corp.createNewOrganisation(orgName, website, employee, phNo, othPh, email);
		
	}
}