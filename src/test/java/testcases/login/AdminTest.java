package testcases.login;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.orangehrm.DashboardPage;

public class AdminTest extends BaseTest {
	@Test
	public void searchingUser() {
		DashboardPage dashboard = loginpageor.login("Admin", "admin123");
		waitfor(5);
		adminPage.searchUser("David Morris", "ESS", "Orange test", "Enabled");
		adminPage.addUser("Admin", "Testing", "Enabled", "ABC", "ab12", "ab12");
		
	}
}
