package com.hk.test;

import org.junit.Test;

import com.hk.dao.EmpDao;
import com.hk.dao.impl.EmpDaoImpl;
import com.hk.servlet.EmpDelServlet;

public class Test01 {
	@Test
	public void test() {
		EmpDao empDao = new EmpDaoImpl();
		System.out.println(empDao.selectEmpAll());
	}
	

}
