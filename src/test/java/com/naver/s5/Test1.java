package com.naver.s5;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class Test1 extends AbstractTestCase {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws Exception{
		//단정문
		assertNotNull(dataSource.getConnection());
		//assertEquals(1, );
		//assertNotEquals(unexpected, actual);
	}

}
