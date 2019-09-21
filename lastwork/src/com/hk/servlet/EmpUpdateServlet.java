package com.hk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.bean.Emp;
import com.hk.dao.impl.EmpDaoImpl;

public class EmpUpdateServlet extends HttpServlet {
	
	public boolean update(Emp e){
		EmpDaoImpl empDaoImpl = new EmpDaoImpl();
		Emp emp = new Emp();
		emp.setEmpno(e.getEmpno());
		emp.setEname(e.getEname());
		emp.setJob(e.getJob());
		emp.setMgr(e.getMgr());
		emp.setHiredate(e.getHiredate());
		emp.setHiredate(e.getHiredate());
		emp.setSal(e.getSal());
		emp.setComm(e.getComm());
		emp.setDeptno(e.getDeptno());
	    empDaoImpl.updateEmp(emp);
	
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
		//e.setHiredate(hiredate);
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
		
		boolean b=update(e);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		if(b) {
			resp.sendRedirect("list.do");
		}else {
			out.println("ÐÞ¸ÄÊ§°Ü");
		}
	


	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}


	
