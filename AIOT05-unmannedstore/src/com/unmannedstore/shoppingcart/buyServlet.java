package com.unmannedstore.shoppingcart;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class buyServlet
 */
@WebServlet("/buyServlet")
public class buyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String good = request.getParameter("good");
	    System.out.println("[�ʪ���]�ӫ~�s��"+good+"�w��J�ʪ���");	    
	    if(good != null && good.trim().length() != 0) {
	        HttpSession session = request.getSession();
	        if(session.getAttribute("cart") != null) {
	            List<String> cart = (List<String>) session.getAttribute("cart");
	            cart.add(good);
	            System.out.println("[�ʪ���]�ʪ������ӫ~�ƶq:"+cart.size());
	            System.out.println("[�ʪ���]�ʪ������ӫ~:"+cart);
	        }
	    }
	    
	    response.sendRedirect("shoppingServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
