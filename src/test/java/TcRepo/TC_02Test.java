package TcRepo;

import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_02Test extends BaseClass
{
	
	@Test
	public void LE_02() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		CreatingNewLeadPage clp = new CreatingNewLeadPage(driver);
		String fname = eUtil.getDataFromExcel("Leads", 5, 1);
		String lName = eUtil.getDataFromExcel("Leads", 5, 2);
		String company = eUtil.getDataFromExcel("Leads", 5, 3);
		String title = eUtil.getDataFromExcel("Leads", 5, 4);
		String phNo = eUtil.getDataFromExcel("Leads", 5, 5);
		String email = eUtil.getDataFromExcel("Leads", 5, 6);
		String nOfEmp = eUtil.getDataFromExcel("Leads", 5, 7);
		String street = eUtil.getDataFromExcel("Leads", 5, 8);
		String poBox = eUtil.getDataFromExcel("Leads", 5, 9);
		String pCode = eUtil.getDataFromExcel("Leads", 5, 10);
		String city = eUtil.getDataFromExcel("Leads", 5, 11);
		String country = eUtil.getDataFromExcel("Leads", 5, 12);
		String state = eUtil.getDataFromExcel("Leads", 5, 13);
		clp.createNewLead(fname, lName, company, title, phNo, email, nOfEmp, street, poBox, pCode, city, country, state, state);
		
	}
}