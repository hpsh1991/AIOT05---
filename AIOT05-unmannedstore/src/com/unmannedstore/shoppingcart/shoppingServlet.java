package com.unmannedstore.shoppingcart;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class shoppingServlet
 */
@WebServlet("/shoppingServlet")
public class shoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private goodsDAO goodsDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingServlet() {
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
		//
        List<String> cart = Optional.ofNullable(
                (List<String>) request.getSession().getAttribute("cart")
            ).orElse(new ArrayList<>());
        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("cartsize", cart.size());
        // 
		goodsDAO=new goodsDAO();
		List<goods> goods=goodsDAO.selectAllgoods();
		request.setAttribute("goods", goods);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopping.jsp");
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
