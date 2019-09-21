package com.hk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.bean.Emp;
import com.hk.dao.impl.EmpDaoImpl;

public class EmpListServlet extends HttpServlet {

	public List<Emp> queryAll(){
		EmpDaoImpl empDaoImpl = new EmpDaoImpl();
		List<Emp> elist=empDaoImpl.selectEmpAll();
		return elist;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Emp> elist=queryAll();
		req.setAttribute("elist", elist);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}



}
