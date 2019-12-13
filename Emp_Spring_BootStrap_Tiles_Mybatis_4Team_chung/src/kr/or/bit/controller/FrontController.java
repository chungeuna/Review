package kr.or.bit.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dao.EmpDaoInterface;
import kr.or.bit.dto.Emp;


@Controller
public class FrontController{

	private SqlSession sqlsession;
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@RequestMapping("Login.do")
	public String loginForm() {
		return "/WEB-INF/views/login/Login.jsp";
	}
	@RequestMapping("LoginOk.do")
	public String loginOk(HttpServletRequest request, String userid, String pwd) {
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		String isLogin = empdao.checkAdminLogin(userid, pwd);
	
		String view= "";
		
		if (isLogin != null) {
			request.getSession().setAttribute("userid", userid);
			view= "index.jsp";
		} else {
			view = "Login.do";
		}

	return view;
	}
	@RequestMapping("Register.do")
	public String regsiterForm() {
		return "/WEB-INF/views/register/Register.jsp";
	}
	@RequestMapping("RegisterOk.do")
	public String registerOK(Emp emp, HttpServletRequest request) {

		CommonsMultipartFile files = emp.getFilename();
		String filename = files.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		String fpath = path  + "\\" + filename;
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(fpath);
			fs.write(files.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		emp.setImagefilename(filename);
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		empdao.insertEmp(emp);
		
		return "Login.do";
	}
	@RequestMapping("Logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index.jsp";
	}
	@RequestMapping("MemberList.do")
	public String memberList(Model model) {
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		List<Emp> emplist = empdao.getEmps();
		model.addAttribute("emplist",emplist);		
		return "/WEB-INF/views/admin/MemberList.jsp";
	}
	@RequestMapping("MemberDetail.do")
	public String MemberDetail(Model model, String empno) {
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		Emp emp =empdao.getEmpByEmpno(Integer.parseInt(empno));
		model.addAttribute("empdetail",emp);
		System.out.println("디테일 : " + emp);
		return "/WEB-INF/views/admin/MemberDetail.jsp";
	}
	@RequestMapping("MemberEdit.do")
	public String MemberEditForm(String empno,Model model) {
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		Emp emp =empdao.getEmpByEmpno(Integer.parseInt(empno));
		model.addAttribute("emp",emp);
		return "/WEB-INF/views/admin/MemberEdit.jsp";
	}
	@RequestMapping("MemberEditOk.do")
	public String MemberEditOK(Model model, Emp emp,HttpServletRequest request) {
		
		CommonsMultipartFile files = emp.getFilename();
		String filename = files.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("path : " + path);
		String fpath = path  + "\\" + filename;
		FileOutputStream fs = null;
		System.out.println("여기는 타나 edit  1");
		try {
			fs = new FileOutputStream(fpath);
			fs.write(files.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("여기는 타나 edit  2");
		emp.setImagefilename(filename);
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		empdao.updateEmp(emp);
		System.out.println("edit ok : " + emp);
		model.addAttribute("emp",emp);
		return "/WEB-INF/views/admin/MemberEdit.jsp";
	}
	@RequestMapping("MemberDelete.do")
	public String MemberDelete(String empno) {
		EmpDaoInterface empdao = sqlsession.getMapper(EmpDaoInterface.class);
		int row = empdao.deleteEmpByEmpno(Integer.parseInt(empno));
		return "/WEB-INF/views/admin/MemberList.jsp";
	}

}
