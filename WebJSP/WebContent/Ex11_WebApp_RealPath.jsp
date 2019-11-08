<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--  URI (Universal Resource Identifier)
- 인터넷상의 자원을 식별하기 위한 표기법 및 규약
- URL + URN = URI
- 인터넷 환경에서 URI는 대부분 URL을 의미, URN은 사용이 제한적

URL (Uniform Resource Locator)
- 물리적인 경로, 즉 자원의 위치 정보를 포함
- 프로토콜, 도메인, 아이피, 포트 등
- 컴퓨터로부터 접근 가능한 형태의 자원만 검색될 수 있어 제한적
- 우리가 흔히 보는 'http://test.com/test.jpg' 형태

URN (Uniform Resource Name)
- 독립적인 이름을 제공하기 위해 존재
- 자원에 대해 영속적이고 유일
- 자원의 위치와는 무관
- 예를들어 우리나라에서는 주민등록번호가 대표적

StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 String uri = request.getRequestURI();         // URI : 프로젝트 이하 경로 (CP + SP)
 String cp = request.getContextPath();         // CP : 프로젝트 명
 String sp = request.getServletPath();         // SP : 패키지 + 파일명
 
 System.out.println("URL : " + url);
 System.out.println("URI  : " + uri);
 System.out.println("CP   : " + cp);
 System.out.println("SP   : " + sp);
 
-----------------------------------------------------------------
 URL : http://localhost:8090/WebJSP/Ex11_WebApp_RealPath.jsp
 URI  : /WebJSP/Ex11_WebApp_RealPath.jsp
 CP   : /WebJSP
 SP   : /Ex11_WebApp_RealPath.jsp -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String resurcepath= "/download/note.txt";
out.print(resurcepath + "<br>");

out.print("request.getRequestURL() " + request.getRequestURL() +"<br>");
// http://localhost:8090/WebJSP/Ex11_WebApp_RealPath.jsp
out.print("request.getRequestURI() " + request.getRequestURI()+"<br>");
// /WebJSP/Ex11_WebApp_RealPath.jsp
out.print("request.getContextPath() " + request.getContextPath()+"<br>");
// /WebJSP
out.print("request.getServletPath() "+request.getServletPath()+"<br>");
// /Ex11_WebApp_RealPath.jsp
request.getContextPath();

//CP: 웹에서 바라보는 경로, 가상 경로 
//예상: C:\SmartWeb\Web\WebJSP\JSPLab\WebJSP
String realContextPath = application.getRealPath("/WebJSP");
out.print("ContextPath의 realPath " + realContextPath+"<br>");
//실경로: C:\SmartWeb\Web\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\WebJSP

String realFilePath = application.getRealPath(resurcepath);
out.print("resurcepath realfilePath :  " + realFilePath+"<br>");
//C:\SmartWeb\Web\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\download\note.txt


//예상 경로와 실경로가 다른 이유
//톰캣 이클립스에 내장하고 배포했을 때 그 경로 위 경로 
//getRealPath 실제 배포된 경로를 뽑아온다 
//파일 업로드할때 사용 (실제 배포되는 경로)
//게시판 만들기에서 우리가 파일 업로드시 다시 본다 아래코드 활용

//include >> jsp부터 나온다...> 공통 페이지 뽑아내기

%>
</body>
</html>