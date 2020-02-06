package com.unmannedstore.accountmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unmannedstore.accountmanagement.dao.AccountDAO;
import com.unmannedstore.accountmanagement.model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String email=request.getParameter("email");
		HttpSession session=request.getSession();
		session.setAttribute("loginaccount", email);
		accountDAO=new AccountDAO();
		Account account=accountDAO.selectAccountByEmail(email);
		int memberrank=account.getMemberrank();
		if(memberrank==1) {
			response.sendRedirect("manager.jsp");
			System.out.println("管理者登入:"+email);
		}else {
			response.sendRedirect("user.jsp");
			System.out.println("使用者登入:"+email);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
