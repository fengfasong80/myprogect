package com.hk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.dao.impl.EmpDaoImpl;


public class EmpDelServlet extends HttpServlet {
	
	public boolean del(int empno){
		EmpDaoImpl empDaoImpl = new EmpDaoImpl();
		empDaoImpl.deleteEmp(empno);
		return true;
	}
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String empno=req.getParameter("empno");
	        boolean b=del(Integer.parseInt(empno));
	        
	        resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out=resp.getWriter();
	        if(b){
	        	//out.println("É¾³ý³É¹¦");
	        	resp.sendRedirect("list.do");
	        }else{
	        	out.println("É¾³ýÊ§°Ü");
	        }
		}
	
	



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}



	

	
