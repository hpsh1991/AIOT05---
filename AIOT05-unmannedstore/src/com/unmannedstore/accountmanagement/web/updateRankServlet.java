package com.unmannedstore.accountmanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unmannedstore.accountmanagement.dao.AccountDAO;

/**
 * Servlet implementation class updateRankServlet
 */
@WebServlet("/updateRankServlet")
public class updateRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRankServlet() {
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
		String phone = (String) request.getSession().getAttribute("phone");
		accountDAO=new AccountDAO();
		try {
			// 更新會員等級至3
			accountDAO.updateMemberrankbyphone(phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("editAccountServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
