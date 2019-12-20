package kr.or.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

@RestController
public class AjaxController {
	
	private SqlSession sqlSession;

	@Autowired
	public void setSqlsession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping(value="GetDeptNos.do", method= RequestMethod.POST)
	public List<Integer> getDeptsNo(HttpServletResponse response) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		List<Integer> list = dao.getDethNos();
		return list;
	}
	@RequestMapping(value="GetJobRegister.do", method= RequestMethod.POST)
	public List<String> getJobRegister(HttpServletResponse response) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		List<String> list = dao.getJobRegister();
		return list;
	}
	@RequestMapping(value="GetEmpnos.do", method= RequestMethod.POST)
	public List<Emp> GetEmpnos(HttpServletResponse response) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		List<Emp> list = dao.getEmps();
		return list;
	}
	@RequestMapping(value="ec.do", method= RequestMethod.POST)
	public String chkEmpno(String empno) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		Emp result = dao.getEmpByEmpno(Integer.parseInt(empno));
		String responsedata = "false";
		if(result == null) {
			responsedata = "true";
		}
		return responsedata;
	}
}
