package Stepdefinations;

import java.io.IOException;

import org.junit.Assert;

import Base.Baseselenium;
import Locators.projectlocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class projectstepdefination extends  Baseselenium{

	
	@Given("Setup")
	public void setup() throws Throwable {
	    
		setDriver();
		
		
	}

	@When("Enter the usernsame amd password")
	public void enter_the_usernsame_amd_password() throws Throwable {

		waittillelementvisible(projectlocator.email);
		Assert.assertTrue(iselementpresent(projectlocator.email));
		
		String email = getdata("Username");
		
		System.out.println("The Username is: "+email);
		sendkey(projectlocator.email, email);
		
		waittillelementvisible(projectlocator.password);
		Assert.assertTrue(iselementpresent(projectlocator.password));
		
		String Password = getdata("Password");
		
		System.out.println("The Password is: "+Password);
		sendkey(projectlocator.password, Password);
	
		waittillelementvisible(projectlocator.loginbutton);
		Assert.assertTrue(iselementpresent(projectlocator.loginbutton));
		clicks(projectlocator.loginbutton);
		
	}
}
