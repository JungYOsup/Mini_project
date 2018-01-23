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
			lists= sqlSession.selectList(namespace+"selectAll"); //매핑은 DataMapper에서 결과값으로 반환할때 해줌!
			//그리고 그 결과값을 lists가 받는것일뿐이다. 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
				
		return lists;
		
	}
	//1.1특정갯수만큼 정보 가지고 오기
	
	public List<Dto> selectAll(String snum,String lnum){
		
		List<Dto> lists = new ArrayList<Dto>();
		SqlSession sqlSession = null;
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("snum", snum);
		map.put("lnum", lnum);
		
		
		try {
			sqlSession = getSQLSessionFactory().openSession(true);
			lists= sqlSession.selectList(namespace+"selectWhere",map); //매핑은 DataMapper에서 결과값으로 반환할때 해줌!
			//그리고 그 결과값을 lists가 받는것일뿐이다. 
			
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
			dto = sqlSession.selectOne(namespace+"login", map); //dto와 매핑을 한 객체를 반환해줌
					
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
	//5.결과값을 가져오는 메서드
	//파라미터로 입력값을 받고 그 입력값을 쿼리에 넣었을때 그 값과 일치하는게 있을경우 정답
	//결과값은 dto로 리턴받겠다
	public String bringresult(String text) {
		String str="";
		
		SqlSession sqlSession = null;
		
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("result", text);
					
		try {
			sqlSession = getSQLSessionFactory().openSession(true);
			str= sqlSession.selectOne(namespace+"resultsql", map);
			
			System.out.println(str);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return str;
		
		
	}
	
	//6.측정된 시간값을 받아 그걸로 쿼리를 업데이트 시켜주는 메서드
	//리턴타입은 성공여부에따라 리턴해주기 때문에 boolean
	
	public boolean UpdateRecord(String record,String id) {
		int count =0;
		SqlSession sqlSession = null;
		
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("record", record);
		map.put("id", id);
		
		sqlSession=getSQLSessionFactory().openSession(true);
		
		count=sqlSession.update(namespace+"update",map);
				
		return count>0?true:false;
		
		
		
	}
	
	//7.등급 업데이트,탈퇴 업데이트 
	public boolean UpdateGrade(String grade , String id,String enabled) {
		int count =0;
		SqlSession sqlSession = null;
		
		
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("grade", grade);
		map.put("id", id);
		map.put("enabled", enabled);
		sqlSession=getSQLSessionFactory().openSession(true);
		
		count=sqlSession.update(namespace+"updategrade",map);
				
		return count>0?true:false;
		
		
		
	}
	
	//페이지 측정 메소드
	
	public int pageCount() {
		int count=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=getSQLSessionFactory().openSession(true);
			count=sqlSession.selectOne(namespace+"boardcount");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count;
	}
	
	
	
}
