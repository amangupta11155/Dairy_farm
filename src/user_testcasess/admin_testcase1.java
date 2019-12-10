package user_testcasess;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import niit_Reposatory.niit_Dao;
import niit_utilities.Emp;

public class admin_testcase1 {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*@Test
	public void test() {
		Emp e=new Emp();
	e.setName("aman");
	e.setPassword("Aman@123");
	e.setEmail("aman0090@gamil.com");
	e.setMobile(90992);
	
		assertEquals(1,niit_Dao.save(e));
	}

}*/
	/*@Test
	public void test() {
		Emp e=new Emp();
	e.setName("aman");
	e.setPassword("Aman@123");
	e.setEmail("aman0090@gamil.com");
	e.setMobile(90992);
	
		assertEquals(0,niit_Dao.save(e));
	}

}*/
	@Test
	public void test() {
		
		assertEquals(1,niit_Dao.getAllEmployees());
	}

}
