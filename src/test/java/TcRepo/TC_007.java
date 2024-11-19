package TcRepo;

import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectRepo.CreatingNewOrganisationPage;
import objectRepo.HomePage;
import objectRepo.OrganisationsPage;

public class TC_007 extends BaseClass{
	@Test
	public void ORG_03() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		OrganisationsPage orp = new OrganisationsPage(driver);
		orp.clickOnCreateNewOrganisationsIcon();
		CreatingNewOrganisationPage corp = new CreatingNewOrganisationPage(driver);
		String orgName = eUtil.getDataFromExcel("Organisations", 8, 1);
		String website = eUtil.getDataFromExcel("Organisations", 8, 2);
		String billAdd = eUtil.getDataFromExcel("Organisations", 8, 3);
		String billCity = eUtil.getDataFromExcel("Organisations", 8, 4);
		String billState = eUtil.getDataFromExcel("Organisations", 8, 5);
		corp.createNewOrganisation(orgName, website, billAdd, billCity, billState );
		
	}
}