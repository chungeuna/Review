package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;

import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Reply;

//jsp가 요청하는 객체 (Singleton)
public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardService() {}
	public static BoardService getInstance() {
		
		return instance;
	}
	//서비스 요청 (글쓰기) 
	public int writeok(Board boarddata) throws Exception {
		BoardDao dao = new BoardDao();
		int result = dao.writeok(boarddata);
		return result;
	}
	//서비스 요청(글목록)
	public List<Board> list (int cpage, int pagesize) throws Exception {
		BoardDao dao = new BoardDao();
		
		return dao.list(cpage, pagesize);
	}
	//서비스 요청(글 목록에 있는 게시물 총 건수)
	public int totalBoardCount() throws Exception {
		BoardDao dao = new BoardDao();
		return dao.totalBoardCount();
	}
	//서비스 요청 (상세보기) 
	public Board content(int idx) throws NamingException {
		return new BoardDao().getContent(idx);
	}
	//글 상세보기시 조회수 증가하기 
	public boolean addReadnum(String idx) throws NamingException {
		return new BoardDao().getReadNum(idx);
	}
	//서비스 요청(게시글 삭제하기) :jspboard,reply
	public int board_Delete(String idx, String pwd) throws NamingException {
		return new BoardDao().deleteOK(idx, pwd);
	}
	//서비스 요청(댓글 입력하기)
	public int replyWrite(int idx_fk,String writer, String userid, String content, String pwd) throws NamingException {
		return new BoardDao().replywrite(idx_fk, writer, userid, content, pwd);
	}
	//서비스 요청(댓글 목록 조회하기)
	public List<Reply> replyList(String idx_fk) throws NamingException {
		return new BoardDao().replylist(idx_fk);
	}	
	//서비스 요청(댓글 삭제하기)
	public int replyDelete(String no, String pwd) throws NamingException {
		return new BoardDao().replyDelete(no, pwd);
	}
	//답글쓰기 
	public int rewriteok(Board boardata) throws NamingException  {
		return new BoardDao().reWriteOk(boardata);
	}
}
