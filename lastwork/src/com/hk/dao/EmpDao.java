package com.hk.dao;

import java.util.List;

import com.hk.bean.Emp;

public interface EmpDao {
	public void insertEmp(Emp emp);
	public void deleteEmp(int empno);
	public void updateEmp(Emp emp);
	public Emp selectEmpByEmpno(int empno);
	public List<Emp> selectEmpAll();

}
