package min.edu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import min.edu.dto.Dto;

public class Dao extends sqlMapConfig{

	private String namespace ="min.edu.room.";
	
	//1.전체정보가지고오기
	//전체정보는 파라미터로 던지는 값이 없고 , 결과값이 객체로 넘어 온다.
	
	public List<Dto> selectAll(){
		
		List<Dto> lists = new ArrayList<Dto>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = getSQLSessionFactory().openSession(true);
			lists= sqlSession.selectList(namespace+"selectAll");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
				
		return lists;
		
	}
	
	//2.상세정보 가져오기
	
	public Dto selectdetail(String id) {
		
		Dto dto = null;
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		SqlSession sqlSession =null;
		
		try {
			sqlSession = getSQLSessionFactory().openSession(true);
			dto = sqlSession.selectOne(namespace+"selectdetail", map); //우리가 json때문에 상세정보쿼리문에서 regdate를 to_char로 String형태로 바꿧기 때문에 , 자동으로 mapping을 하려면 dto에도 그 
																	   //값을 받을수 있는 파라미터가 필요하다. 그게 dto에서 sregdate!!
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
				
		
		return dto;
	}
	
	//3.로그인
	public Dto login(String id,String pw) {
		
		Dto dto = null;
		Map<String, String> map = new HashMap<String,String>();
		SqlSession sqlSession =null;
		
		map.put("id", id);
		map.put("pw", pw);
		
		try {
			sqlSession = getSQLSessionFactory().openSession(true);
			dto = sqlSession.selectOne(namespace+"login", map);
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
				
		
		return dto;
	}
	
	//4.회원가입하기
	//회원가입은 결과로써 성공했느냐 안했느냐만 파악하기위해 boolean으로 리턴값을받고 
	//파라미터로 id,pw,name,email을 받겠다.
	public boolean signup(String id, String pw,String name, String email) {
		
		int count =0;
		SqlSession sqlSession = null;
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("email", email);
		
		try {
			sqlSession =getSQLSessionFactory().openSession(true);
			count = sqlSession.insert(namespace+"signup", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return count>0?true:false;
		
		
	}
	
	
}
