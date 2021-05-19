package com.sprMbrMbts.customer;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sprMbts.customer.Cst;
import com.sprMbts.customer.IDaoCst;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class IDaoCstTest {

	@Autowired
	private IDaoCst daoCst;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	
	@Test
	public void insertUserTest() {
		
		Cst cst = new Cst();
		cst.setCode(100);
		cst.setName("yoo");
		cst.setEmail("yoo");
		cst.setTel("yoo");
		cst.setWeight(99.9);
		
		daoCst.insertUser(cst);
		
		Cst cst1 = daoCst.getUser(100);
		
//		assertNull(daoMem.getUser("juid3"));
		assertEquals("yoo", cst1.getName());
	}
	
	@Test
	public void getUserTest() {
		
		Cst cst1 = daoCst.getUser(100);
		assertEquals("yoo", cst1.getName());
	}
	



}
