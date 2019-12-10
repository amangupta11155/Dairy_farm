package admin_testcases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import niit_Reposatory.niit_Dao1;
import niit_utilities.Emp;

public class user_testcases {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	/*public void test() {
		Emp e=new Emp();
		e.setName("aman");
		e.setPassword("Aman@123");
		e.setEmail("aman0090@gamil.com");
		e.setMobile(90992);
		
			assertEquals(1,niit_Dao1.save(e));
	}

}*/public void test() {
	Emp e=new Emp();
	e.setName("aman");
	e.setPassword("Aman@123");
	e.setEmail("aman0090@gamil.com");
	//e.setMobile(90992);
	
		assertEquals(0,niit_Dao1.save(e));
	}
}

