package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test
	public void test1() {
		System.out.println("Inside Test 1");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside After Suite");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After Method");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside Test 2");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside Before Class");
	}
}
