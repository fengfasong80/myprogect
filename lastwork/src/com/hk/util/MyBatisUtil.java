package com.hk.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	  
	  public static SqlSession getSqlSession(){
		  
		  try {
			  if(factory==null){
				  InputStream in=Resources.getResourceAsStream("mybatis.xml");
			      factory=new SqlSessionFactoryBuilder().build(in);
			  }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }

		  return factory.openSession();
	  }

}
