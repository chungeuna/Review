package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	//변수만들기 
	private String encoding;

    public EncodingFilter() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(request.getCharacterEncoding() == null) {
			System.out.println("before: " + request.getCharacterEncoding());
			request.setCharacterEncoding(this.encoding);
			System.out.println("after: " + request.getCharacterEncoding());
		}
		//request(요청이 왔을 때 구현되는 보조관심)
		chain.doFilter(request, response);
		//response (응답할 때 처리되는 코드) 
		System.out.println("response 응답처리");
		//dofilter 기준으로 앞에 >> 요청이 올때 걸러지는 필터 
		//뒤에 >>  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//최초 요청시 한번만 실행되는 자원 
		//getInitParamter >> web.xml 자원 끌어올 수 있다 
		this.encoding = fConfig.getInitParameter("encoding"); //key-value : utf-8이라는 문자가 나온다 
		System.out.println("Filter init : " + this.encoding);
		
		/*  <init-param>
  			<param-name>encoding</param-name>
  			<param-value>UTF-8</param-value>
  			</init-param>
		 */
	}

}
