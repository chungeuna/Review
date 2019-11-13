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
 * Servlet implementation class CarSaveServlet
 */
@WebServlet("/carsave")
public class CarSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String product = request.getParameter("product");
		//POINT (session) 
		//JSP: 내장 객체 : session.getId() >>>자동지원 
		//서블릿: session 얻어서 사용해야한다 >> request 객체한테 
		//getSession은 현재 만들어진 세션 객체 주소값 리턴한다 
		//서블릿 >> getSession 이용해서 얻는다 
	
		HttpSession session = request.getSession();
		System.out.println("session ID: " + session.getId());
		//구매한 목록 session에다가 저장 
		List<String> list = (ArrayList<String>) session.getAttribute("productlist");
		System.out.println("리스트 컬렉션 : " + list);
		if(product == null ) {
			out.print("상품을 선택하지 않으셨네요");
		}else {
			if(list == null ) { //list 장바구니 
				System.out.println("list collection is null");
				list = new ArrayList<String>();
				list.add(product);
				session.setAttribute("productlist", list); //다른 페이지에서 공유하려면  session 
				
			}else {
				System.out.println("list collection is not null");
				list.add(product);
			}
		}
		out.print("<html>");
			out.print("<body>");
				out.print("<a href ='carbasket'>장바구니 보기</a>");
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
