package kr.or.bit.dao;
/* DB 작업 
 * CRUD 작업을 하기 위한 함수를 생성하는 곳 
 * 
 * memo table에 데이터를 
    전체조회  : select id,email,content from memo
    조건조회 : select id,email,content from memo where id= ?
    수정  update memo set email= ?, content= ? where id = ?
    삭제  delete from memo where id = ?
    삽입  insert into memo(id,email,content) values(?,?,?)
 * 
 * default 5개 
 * >> 필요하면 더 만들어라 추가해도 된다
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.DB_Close;

public class memodao {
	/*
	Connection conn = null;
	public memodao() {
		conn = Singleton_Helper.getConnection("oracle");
		
	}
	*/
	/*
	DataSource ds = null;
	public memodao() {
		try {
			Context context = new InitialContext(); //현재 프로젝트에서 이름기반으로 검색을 할 것이다  
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			//각각의 함수 안에서 커넥션을 얻고 반환하고 ... 
			//
		}catch(Exception e) {
			
		}
		
	}
	*/
	//한건의 데이터를 read 한다 (where 조건에 사용되는 컬럼은 반드시** 유니크 또는 프라이머리 키가 있어야한다 >> 한건의 데이터란 보장을 하기 때문에) 
	public memo getMemolistById(String id) {
		/* select id,email,content from memo where id= ?
		 * memo m = new memo();
		 * m.setId(rs.getInt(1)) .... 
		 * return m;
		 */
		
		return null;
	}
	//전체 데이터 read (where라는 조건 절이 없다) 
	public ArrayList<memo> getMemolist() throws SQLException {
		Connection conn = ConnectionHelper.getConnection("oracle");  //객체얻기 
		PreparedStatement pstmt = null;
		String sql = "select id,email,content from memo";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<memo> memolist = new ArrayList<>();
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			memolist.add(m);
		}
		//반환하기 
		
		
		DB_Close.close(rs);
		DB_Close.close(pstmt);
		conn.close();
		
		return memolist;
	}
	//insert 
	//parameter id,email,content 
	//권장: public int insertMemo(momo m ) {}  >> FrameWork 자동화 작업 
	public int insertMemo(String id, String email,String content) {
		Connection conn = null;
		
		int resultrow = 0;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "insert into memo(id,email,content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			pstmt.setString(3, content);
			
			resultrow = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Insert: " + e.getMessage());
		}finally {
			DB_Close.close(pstmt);
			try {
				conn.close();  //반환하기 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return resultrow;
	}
	public int updateMemo(memo m) {
		//update memo set email= ?, content= ? where id = ?
		//m.getId()
		return 0;
	}
	//Delete
	public int deleteMemo(String id) {
		//delete from memo where id = ?
		return 0;
	}
	//추가 함수 (ID 존재 유무 판단 함수) 
	public String isCheckById(String id ){
		//id 존재하면 false 리턴, 존재하지 않으면 true 리턴  >>문자열
		Connection conn = null;
		int resultrow = 0;
		String chk="false";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "select id from memo where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		resultrow = pstmt.executeUpdate();
		if(resultrow > 0){
				return "false";
		}else {
				chk="true";
		}
		} catch(Exception e) {
		DB_Close.close(rs);
		DB_Close.close(pstmt);
		
		try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
		return chk;
	}
}
