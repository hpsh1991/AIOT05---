package com.unmannedstore.accountmanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unmannedstore.accountmanagement.dao.AccountDAO;
import com.unmannedstore.accountmanagement.model.Account;


/**
 * Servlet implementation class editAccountServlet
 */
@WebServlet("/editAccountServlet")
public class editAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		accountDAO = new AccountDAO();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("loginaccount");
		System.out.println("editAccountServlet:"+name);
		session.setAttribute("loginaccount", name);	
		Account existingAccount=accountDAO.selectAccountByName(name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("account-form.jsp");
		request.setAttribute("account", existingAccount);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
