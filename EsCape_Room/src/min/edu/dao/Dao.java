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
			dto = sqlSession.selectOne(namespace+"selectdetail", map);
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
	
}
