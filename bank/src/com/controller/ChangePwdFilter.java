package com.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangePwdFilter
 */
public class ChangePwdFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChangePwdFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String pwd=request.getParameter("pwd");
		String cnfpwd=request.getParameter("cnfpwd");
		if(pwd.equals(cnfpwd))
		{
			chain.doFilter(request, response);
		}
		else
		{
		((HttpServletResponse)	(response)).sendRedirect("/bank/error.html");
		}
		
	  }
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
