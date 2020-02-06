package com.unmannedstore.accountmanagement.web;
/*�ק� 51 52 56 57*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.unmannedstore.accountmanagement.dao.AccountDAO;

/**
 * Servlet Filter implementation class RegFilter
 */
@WebFilter("/RegMailServlet")
public class RegFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String email=request.getParameter("email");
		PrintWriter out=response.getWriter();
		AccountDAO accountDAO=new AccountDAO();
		Boolean checkEmail=accountDAO.checkAccountByEmail(email);
		// pass the request along the filter chain
		if(email=="") {
			out.print("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:575px'>");
			out.print("<span style='position:absolute;left:825px;top:575px;font-size:14px;color:red'>�п�J�H�c</span>");
			System.out.println("�ϥΪ̵��U:�ϥΪ̥���J�b��");
			request.getRequestDispatcher("register1.jsp").include(request, response);
		}else {
			if(checkEmail) {
				out.print("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:575px'>");
				out.print("<span style='position:absolute;left:825px;top:575px;font-size:14px;color:red'>Email�w�Q�ϥ�</span>");				System.out.println("�ϥΪ̵��U:"+email+"�w�Q�ϥ�");
				request.getRequestDispatcher("register1.jsp").include(request, response);
			}else {
				chain.doFilter(request, response);
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
