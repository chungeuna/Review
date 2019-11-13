package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class carbasket
 */
@WebServlet("/carbasket")
public class carbasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carbasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니에 담긴 목록 보기 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		System.out.println("session ID: " + session.getId());
		/* 1. getSession() 또는 getSession(true)  
		 * - HttpSession 타입의 객체가 이미 존재한다면 그 세션 객체의 주소를 반환하고 
		 * - 존재하지 않으면 새로운 세션을 만든다 
		 * 2. getSession(false) : 
		 *  - HttpSession 타입의 객체가 이미 존재한다면 그 세션 객체의 주소를 반환하고 
		 *  - 존재하지않으면 ^null값^ 리턴 
		 */
		out.print("<html>");
		out.print("<body>");
			out.print("<h3>장바구니</h3>");
			if(session != null) { //사실 필요없는 코드... >> false란 전제를 깔면 
				//구매한 상품 리스트 출력 
				List<String> list = (ArrayList<String>) session.getAttribute("productlist");
				out.print("상품 목록: " +  list.toString() +"<br>");
			}else {
				out.print("장바구니 비어있어요");				
			}
			out.print("<a href='product.html'>상품 구매 페이지</a><br>");
			out.print("<a href='cardelete'>장바구니 비우기</a>");
		out.print("</body>");
		out.print("</html>");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
