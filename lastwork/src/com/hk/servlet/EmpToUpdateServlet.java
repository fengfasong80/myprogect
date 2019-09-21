package com.hk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.bean.Emp;
import com.hk.dao.impl.EmpDaoImpl;

public class EmpToUpdateServlet extends HttpServlet {
	
	public Emp queryByEmpno(int empno){
		EmpDaoImpl empDaoImpl = new EmpDaoImpl();
		 Emp e=new Emp();
		 e=empDaoImpl.selectEmpByEmpno(empno);
		 
		return e;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=(String)req.getSession().getAttribute("userName");
		if(userName==null){
			resp.sendRedirect("login.html");
			return;
		}
		
		String empno=req.getParameter("empno");
	    Emp e=new Emp();
	    e=queryByEmpno(Integer.parseInt(empno));
	    
	    req.setAttribute("emp", e);
	    req.getRequestDispatcher("toUpdate.jsp").forward(req, resp);
	   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}


	
