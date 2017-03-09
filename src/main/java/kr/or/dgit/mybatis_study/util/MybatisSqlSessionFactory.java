package kr.or.dgit.mybatis_study.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null){
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //여기서 섹션팩토리만들어서 리턴
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();   // DBCon 작업 
		
	}
	
}
