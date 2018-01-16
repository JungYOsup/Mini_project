# calendar_MVC2_mybatis_Practice
켈린더_MVC2_mybatis_연습
자바에서는 다음페이지로 전달하는 방법이 있다.   
우리가 jsp에서는 값을 안 담고 이동할때 스크립트를 쓰거나,respond.sendRedrirect를 썻고 , 값을 담을때는  request.setAttribute를 써서 객체를 담고 PageContext.forward를 썻다.   
그러나 지금은 자바파일이기때문에 pageContext가 안되므로 다른방법으로 값을 담아서 이동해야한다. 
그 방법이         

##### 코드
```java
request.setAttribute("lists", lists);   //전달할객체를 담고
RequestDispatcher dispatch = request.getRequestDispatcher("listboard.jsp");  //getRequestDispatcher("url") 
dispatch.forward(request, response);

```

# mybatis란
mybatis (orm= object relation mapping) 이라는 명칭을 지니고 있으며 객체 관계 연결 프레임워크라고 보면된다.
일단 mapping이라는것부터 이해해보자. 
mtbatis에서 mapping이란 DB에 있는 하나하나의 컬럼과 dto에 맴버필드에 있는것들을 매칭시키는 역할을 mybatis에서 알아서
처리를 해준다.

예를들어 설명하자면 Dao에서 결과값을  while문을 돌려서 
rs.getint(1) 이런식으로 하나하나씩 쿼리에서 결과값을 받고 dto에 전달했다면

```mybatis 적용전
//글 상세보기 기능:상세보기는 글하나에 대한 정보를 구하기때문에 유니크한 값 seq가 필요함	
	public YoungSangDto getBoard(int seq) {
		YoungSangDto dto = new YoungSangDto();
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs=null;
		//DB연결할때 쓸 내용
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="HK";
		String password="HK";
		//쿼리 준비할때 쓸 내용
		String sql=" SELECT SEQ,ID,NAME,TITLE,CONTENT,REGDATE FROM BYUNGJUBOARD WHERE SEQ = ? ";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2단계 Connection(DB)연결 성공");
			
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("3단계 쿼리 준비성공");
			rs = psmt.executeQuery();
			System.out.println("4단계 쿼리 성공");
			
			while(rs.next()) {
				
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				
			}
			System.out.println(dto); //dto받은값
			System.out.println("5단계성공");
								
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("6단계 성공");
			} catch (SQLException e) {
				System.out.println("6단계 실패");
				e.printStackTrace();
			}
```

이렇게 적용후에는 결과값을 객체로 받은다음 dto에 전달을 해주기만하면 알아서 dto의 파라미터에 적용시켜준다. 

```mybatis 적용후

//글 상세보기 기능:상세보기는 글하나에 대한 정보를 구하기때문에 유니크한 값 seq가 필요함	
	public YoungSangDto getBoard(int seq) {
		YoungSangDto dto = new YoungSangDto();
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			dto=sqlSession.selectOne(namespace+"detailboard", seq); //결과값으로 객체를 받음
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dto;
	}

```

mapping을 하면서 좋은점은 ? 

우리가 DB에서 넘어온 결과값을 받을때 dto.set()이런식으로 하나하나씩 받았지만 그렇지 않고 객체를 dto에 전달하기 때문에 
뭄텅이로 받아서 코드가 간편해진다.

# mybatis 주의해야할점(1)
````
SELECT SEQ,ID,NAME,TITLE,CONTENT,to_char(REGDATE,'YYYY-DD-MM hh24:mi:ss') FROM BYUNGJUBOARD WHERE SEQ =#{seq}
SELECT SEQ,ID,NAME,TITLE,CONTENT,to_char(REGDATE,'YYYY-DD-MM hh24:mi:ss') as Ajaxregdate FROM BYUNGJUBOARD  WHERE SEQ =#{seq}
````
의 둘이 차이점은 
첫번째의 경우 우리가 dao에서 결과값을 호출하고 받을때 dto의 맴버필드와 결과값의 칼럼명이 다를경우 값이 전달되지 않는다.
첫번째쿼리를 출력해보면 칼럼명이  SEQ,ID,NAME,TITLE,CONTENT,to_char(REGDATE,'YYYY-DD-MM hh24:mi:ss') 로 출력이 된다.
그렇기에 dto의 맴버필드와 칼럼명이 다를경우인것이다.

(그 이유는 mybatis에서는 이름이 같아야지만 mapping이 성립되어 알아서 값을 dto에 전달하는데(Mapping을 하면 dto.set()을 하지않아도 알아서 값을 넣어준다)
이름이 다를경우 성립하지 않아 이름이 같은값만 전달하고 그렇지 않은 맴버필드에는 값을 전달하지 못한다) 

두번째의 경우 우리가 dao에서 결과값을 호출하고 받을때 dto의 맴버필드와 결과값의 칼럼명이 같으므로 값이 전달된다 않는다.
(대소문자는 상관없다 즉 칼럼이 대문자고 맴버필드가 소문자여도 mybatis에서는 알아서 mapping을 해준다.)


			
		}
		
		
		
		return dto;
	}

# mybatis 주의해야할점(2)

DTO와 DATAMapper.xml과 연결할때는 무조건 DTO에 기본생성자를 생성해주어야한다.

Cause: org.apache.ibatis.executor.ExecutorException: No constructor found in min.edu.dto.Dto matching라는 오류가 뜸!!

기본생성자를 생성하지 않을경우 연결이 안되므로 주의하자

## ajax 사용법

Ajax: servlet과 javascript간에 통신

roundtrip(왕복의)패턴을가진다.

우리가 이전에는 JS code에서 요청하면 Servlet에서 처리해주고 다른 곳으로 이동했는데
지금은 JS code로 요청하면 Servlet에서 처리해주고 값을 리턴해주는데 리턴해주는장소가
요청한 장소로 리턴해준다. 

요청한 장소로 리턴해줄때 XML, JSON으로 변환해서 줘야한다

장점:
페이지 이동없이 고속으로 화면을 전환할 수 있다.(깜박현상이 안생김,재로딩안됨)
서버 처리를 기다리지 않고, 비동기 요청이 가능하다.
수신하는 데이터 양을 줄일 수 있고, 클라이언트에게 처리를 위임할 수도 있다.

동기식/비동기식 : 동기, 비동기 의 원래 의미는 통신에서
상대방의 일정 신호에 의해서 다음 동작이 이루어지면 동기
상대방의 상태와 관계없이 일방적으로 동작하면 비동기 입니다

Link : http://jajubogi.tistory.com/14 

JSON이란 ? 
JSON(제이슨[1], JavaScript Object Notation)은 
속성-값(key-value) 쌍으로 이루어진 데이터 오브젝트를 전달하기 위해 
인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷이다. 
비동기 브라우저/서버 통신 (AJAX)을 위해, 넓게는 XML(AJAX가 사용)을 대체하는 주요 데이터 포맷이다
즉 Json이란 key와 value로 데이터를 전달하는 방식

```
json형태(테이터를 배열로표현)
(Obj{
    "key1":"value",
    "key2":[{"a":"av","b":"bv"},{"a":"v","b":"v"}]->value가 배열인경우
    
}
```

값을 가져올때 
Obj["key2"][0]["b"] ==> "bv"

-이 jar파일을 통해서 json방식으로 알아서처리가 가능하다.
-jar파일의 위치는 *lib!!
commons-beanutils-1.8.2.jar
commons-collections-3.2.1.jar
commons-lang-2.5.jar
commons-logging-1.1.1.jar
ezmorph-1.0.6.jar
json-lib-2.3-jdk15.jar

그렇기 때문에 Servlet에서 json방식과 비슷한 Map으로 작성할시 
jar파일을 통해서 알아서 json방식으로 바뀌게 된다.

---------------------------------------
###Ajax 순서

1. 서버에 전달 
```

	$.ajax({
		url:"DetailAjax.do",//요청주소(별명입력하는데 / 빼야함)
		data:"seq="+seq, //보내는 값, data:"key="+value
		type: "post", //전송방식
		datatype:"json", //서버에서 보내주는 데이터 타입
		success:function name(obj) { //서버에서 성공적으로 보내졌다면 실행(obj는 보낸 데이터 받는 변수)
				
				alert(obj.dto.title);
			}
		});

		
	}, function() {
		
	});
```
2. 브라우저에 전달된 값 받기 
```
		String seq = request.getParameter("seq");
		int sseq = Integer.parseInt(seq);
		YoungSangDao dao = new YoungSangDao();
		YoungSangDto dto = dao.getBoardAjax(sseq);
		
		Map<String, YoungSangDto> map = new HashMap<String, YoungSangDto>();
		
		map.put("dto", dto);
```
3.Json 객체로 변환 : fromObject("Json으로 변환해줄 객체"),그런데 이 객체는 출력해줄수 있는 방법 없기 때문에 전용프린터를 만들어야한다.

JSONObject obj=JSONObject.fromObject(map);//JSON으로 바꿔준다. JSON으로 바꿔줄때 주의해야할점은 JSON은 DATE타입은 적용이 안된다, 따라서 JSON을 적용하기 위해서는
쿼리문에서 DATE타입의 칼럼을 String으로 바꿔줘야한다(ex TO_CHAR(REGDATE,'YYYY-MM-DD'))

주의(1) MVC2패턴에서는 mapping을 시켜야하므로 쿼리에서 전달된 객체가 dto와 mapping하기 위해서는 dto의 맴버필드와 쿼리의 칼럼명이 같아야한다/

주의(2) 쿼리문에서 TO_CHAR(REGDATE,'YYYY-MM-DD')로 하고 그 결과값을 받았을때 결과값의 칼럼명은 REGDATE가 아닌 TO_CHAR(REGDATE,'YYYY-MM-DD') 이므로 
AS를 써서 알리아스 처리를 하고, 그 알리아스처리한 이름과 dto에 맴버필드와 같아야하므로 dto에 무조건 알리아스처리한 칼럼과 같은 이름의 dto 맴버필드가 존재해야한다.
 
PrintWriter pw = response.getWriter();//응답(response)을 위한 전용 프린터 만들고,그렇다면 syso와 뭐가 다른걸까? syso는 콘솔에다 출력, printWriter는 브라우저에 출력 
 
4.브라우저에 전달
obj.write(pw); //obj객체가 전용프린터를 받어 브라우저에 출력을 해준다. , 그런데 오류가 뜬다면 데이터에 타입중 Date가 있는지 확인하자 why? //json object는 데이터타입을 변환하지 못한다.


5.서버에 전달된(Json방식으로 전달) key값을 받는다.
alert(obj.dto.title);//OGNL형태(객체이름으로 부름,언어방식문법) , 원래는 자바에서는 dto.getTitle()이라고 꺼내야하는데 ,웹브라우저(jsp)에 전달받은것이므로 객체로만 꺼낼수도있다. (EL)
alert(obj["dto"]["title"]); //javascript문법으로 구하기(obj["key"]["key"]) == var objObject =obj["dto"];
                    					                      objObject["title"];	
