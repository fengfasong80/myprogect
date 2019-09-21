package com.hk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.util.JdbcUtil;

public class EmpLoginServlet extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		System.out.println("this is a bug");
		if(login(userName,userPass)) {
		//	System.out.println("恭喜你，登录成功");
			//RequestDispatcher dispatcher = req.getRequestDispatcher("list.do");
			//dispatcher.forward(req,resp);
			String ten = req.getParameter("ten");
			Cookie cookie = new Cookie("userName",userName);
			if("on".equals(ten)) {
				cookie.setMaxAge(60*60*24*10);
				resp.addCookie(cookie);
				System.out.println("添加cookie成功......");
			}else {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			HttpSession session=req.getSession();
			session.setAttribute("userName", userName);
			resp.sendRedirect("list.do");
			
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			resp.setHeader("refresh", "5,url=login.html");
			out.println("用户名或密码错误，5秒后系统自动跳转到登录页面，如果没有跳转，请点击<a href='login.html'>这里</a>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	public boolean login(String userName,String userPass) {
		Connection conn = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select userName from user where userName=? and userPass=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, userPass);
			rs=pst.executeQuery();
			
			//System.out.println("this is a bug");
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeDb(rs, pst, conn);
		}
		return false;
	}

}
