package com.hk.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.bean.Emp;
import com.hk.dao.EmpDao;
import com.hk.util.MyBatisUtil;

public class EmpDaoImpl implements EmpDao {
	
	private SqlSession sqlSession;

	@Override
	public void insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		try {
		sqlSession=MyBatisUtil.getSqlSession();
		sqlSession.insert("insertEmp",emp);
		sqlSession.commit();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}

	@Override
	public void deleteEmp(int empno) {
		// TODO Auto-generated method stub
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.delete("deleteEmp",empno);
			sqlSession.commit();
			} finally {
				if(sqlSession!=null) sqlSession.close();
			}
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.update("updateEmp",emp);
			sqlSession.commit();
			} finally {
				if(sqlSession!=null) sqlSession.close();
			}
	}

	@Override
	public Emp selectEmpByEmpno(int empno) {
		// TODO Auto-generated method stub
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			Emp emp=sqlSession.selectOne("selectEmpByEmpno",empno);
			return emp;
			} finally {
				if(sqlSession!=null) sqlSession.close();
			}
		
	}

	@Override
	public List<Emp> selectEmpAll() {
		// TODO Auto-generated method stub
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			List<Emp> elist=sqlSession.selectList("selectEmpAll");
			return elist;
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}

}
