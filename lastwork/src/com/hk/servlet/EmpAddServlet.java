package com.hk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.dao.impl.EmpDaoImpl;
import com.hk.bean.Emp;
public class EmpAddServlet extends HttpServlet {
	
	public boolean add(Emp e){
		
		EmpDaoImpl empDaoImpl = new EmpDaoImpl();
		Emp emp = new Emp();
		emp.setEmpno(e.getEmpno());
		emp.setEname(e.getEname());
		emp.setJob(e.getJob());
		emp.setMgr(e.getMgr());
		java.util.Date date=e.getHiredate();
		emp.setHiredate(new java.sql.Date(date.getTime()));
		emp.setSal(e.getSal());
		emp.setComm(e.getComm());
		emp.setDeptno(e.getDeptno());
	    empDaoImpl.insertEmp(emp);
		
		return true;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String empno=req.getParameter("empno");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String mgr=req.getParameter("mgr");
		String hiredate=req.getParameter("hiredate");
		String sal=req.getParameter("sal");
		String comm=req.getParameter("comm");
		String deptno=req.getParameter("deptno");
		
		Emp e=new Emp();
		e.setEmpno(Integer.parseInt(empno));
		e.setEname(ename);
		e.setJob(job);
		e.setMgr(Integer.parseInt(mgr));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			e.setHiredate(sdf.parse(hiredate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.setSal(Double.parseDouble(sal));
		e.setComm(Double.parseDouble(comm));
		e.setDeptno(Integer.parseInt(deptno));
		
		boolean b=add(e);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		if(b) {
			
			resp.sendRedirect("list.do");
		}else {
			out.println("ÃÌº” ß∞‹");
		}


	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

	
