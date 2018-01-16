package min.edu.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class sqlMapConfig {

	
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSQLSessionFactory() {
		
		
		String resource = "min/edu/mybatis/Configuration.xml";
		
	
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
