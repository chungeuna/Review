package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	private NoticeDao noticeDao;
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@RequestMapping("notice.htm")
	public String listBoard(String pg, String f, String q, Model model) {
		//디폴트 값 
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		//조건처리 
		if(pg != null && pg.equals("")) {
			page = Integer.parseInt(pg);
		}
		if(f != null && f.equals("")) {
			field = f;
		}
		if(q != null && q.equals("")) {
			query = q;
		}
		
		//Dao 데이터 받아오기
		List<Notice> list = null;
		try {
			list = noticeDao.getNotices(page, field, query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list",list);  //view까지 전달 (forward)  
		
		return "customer.notice"; //"notice.jsp"		
	}
	
	@RequestMapping("noticeDetail.htm")
	public String detailBoard(Model model, String seq) {
		Notice notice = null;
		try {
			notice = noticeDao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		model.addAttribute("notice",notice);
		return "customer.noticeDetail"; //"noticeDetail.jsp"
	}
	//글쓰기 화면 (noticeReg.htm) 
	//return "redirect:notice.htm";  >> redirect  == location.href 리턴할 때 이렇게 ...
	//requestMapping(value="notice.htm",method=RequestMethod.POST)
	
	//글쓰기 처리 (noticeReg.htm) 
	//requestMapping(value="notice.htm",method=RequestMethod.GET)
	//파일 ... customer 폴더 밑에 upload  
	//글쓰기 ~ 완료 
	//라이브러리에 추가하기, multipartResolv ... 
	@RequestMapping(value="noticeReg.htm", method=RequestMethod.GET)
	public String writeForm() {
		//return "/customer/noticeReg.jsp";
		return "customer.noticeReg";
	}
	@RequestMapping(value="noticeReg.htm", method = RequestMethod.POST)
	public String submit(Notice notice, HttpServletRequest request) {
		List<CommonsMultipartFile> files = notice.getFiles();
		//Notice DTO
		//private List<CommonsMultipartFile> files;
		//files[0] = new CommonsMultipartFile() >> 1.jpg 
		//files[1] = new CommonsMultipartFile() >> 2.jpg
		
		List<String> filenames = new ArrayList<String>(); //파일명 관리 
		if(files != null && files.size() > 0) {  //최소 1개의 업로드가 있다면 
			for(CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;
				if(!filename.equals("")) { //실 파일 업로드 
					FileOutputStream fs= null;
					try {
						fs = new FileOutputStream(fpath);
						fs.write(multifile.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fs.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				filenames.add(filename); //파일명 별도로 관리(DB insert) 
				
			}
		}
		notice.setFileSrc(filenames.get(0));
		notice.setFileSrc(filenames.get(1));
		try {
			noticeDao.insert(notice);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		/*
		 * // String filename = imagefile.getOriginalFilename();
		 * notice.setFileSrc(filename); // String path =
		 * request.getServletContext().getRealPath("/customer/upload"); String fpath =
		 * path + "\\" + filename; FileOutputStream fs = null; try { fs = new
		 * FileOutputStream(fpath); fs.write(imagefile.getBytes()); } catch (IOException
		 * e) { e.printStackTrace(); } finally { try { fs.close(); } catch (IOException
		 * e) { e.printStackTrace(); } } try { noticeDao.insert(notice); } catch
		 * (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
		 */
		
		return "redirect:notice.htm";
	}
	//글 삭제하기(noticeDel.htm) 
	// return "redirect: notice.htm
	
	//글 수정하기(화면 :select ... where seq=?) : GET : seq(parameter) 
	//noticedao.getNotice(seq) 
	//Model model > 필요한 데이터 저장 >> 화면단에 보여줘야한다 >>  noticeEdit.jsp 
	//글 수정하기 (처리 : update ... where seq=  ? ) : POST  > 파라미터로 notice 필요
	//parameter Notice n >> insert 동일 
	//무조건 파일 첨부하는 형태로 
	//상세페이지로 다시 가기 
	//return "rdeirect:noticeDetail.html?seq=" + n.getSeq();
	
	@RequestMapping("noticeDel.htm")
	public String deleteBoard(String seq) {
		int notice = 0;
		try {
			notice = noticeDao.delete(seq);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		//model.addAttribute("notice",notice);
		return "redirect: notice.htm";
	}
	
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.GET)
	public String editBoard(Model model, String seq) {
		Notice notice = null;
		try {
			notice = noticeDao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		model.addAttribute("notice",notice);
	//	return "noticeEdit.jsp";
		return "customer.noticeEdit";
	}
	
	@RequestMapping(value="noticeEdit.htm", method=RequestMethod.POST)
	public String editOKBoard(Notice notice, String seq, HttpServletRequest request) {
		List<CommonsMultipartFile> files = notice.getFiles();
		//Notice DTO
		//private List<CommonsMultipartFile> files;
		//files[0] = new CommonsMultipartFile() >> 1.jpg 
		//files[1] = new CommonsMultipartFile() >> 2.jpg
		
		List<String> filenames = new ArrayList<String>();
		if(files != null && files.size() > 0) {  //최소 1개의 업로드가 있다면 
			for(CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;
				if(!filename.equals("")) { //실 파일 업로드 
					FileOutputStream fs= null;
					try {
						fs = new FileOutputStream(fpath);
						fs.write(multifile.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fs.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				filenames.add(filename); //파일명 별도로 관리(DB insert) 
				
			}
		}
		notice.setFileSrc(filenames.get(0));
		notice.setFileSrc(filenames.get(1));
		try {
			noticeDao.insert(notice);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:noticeDetail.htm?seq=" + notice.getSeq();
	}
	
	
}
