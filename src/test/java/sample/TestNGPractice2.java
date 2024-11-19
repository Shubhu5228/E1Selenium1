package sample;

import org.testng.annotations.Test;

public class TestNGPractice2 {
	@Test(priority=2,dependsOnMethods= {"deleteUser","modifyUser"})
	public void createUser()
	{
		System.out.println("User Created");
	}
	
	@Test
	public void modifyUser()
	{
		System.out.println("User Modified");
	}
	
	@Test
	public void deleteUser()
	{
		System.out.println("User Deleted");
	}

}
