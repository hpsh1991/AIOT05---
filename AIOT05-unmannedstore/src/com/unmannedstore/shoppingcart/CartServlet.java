package com.unmannedstore.shoppingcart;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private goodsDAO goodsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		List<String> listcarts = (List<String>) request.getSession().getAttribute("cart");
		
        if (listcarts.isEmpty()) {
        	System.out.println("購物車是空的");
            response.sendRedirect("shoppingServlet");
            return;
        }

        
        Map<String, Long> goods = listcarts.stream().collect(
                    groupingBy(String::toString, counting())
                );
        
        System.out.println("Map<String, Long> goods:"+goods);
    	Set keySet = goods.keySet(); 
    	Iterator it = keySet.iterator();
    	
    	List<Cart> newlistcart=new ArrayList<>();
    	goodsDAO =new goodsDAO();
    	int totalprice=0;
    	while(it.hasNext()) {
    		String key=(String) it.next();
    		
    		Long value=goods.get(key);
    		
        	int id= Integer.parseInt(key);
        	goods selectGoods=goodsDAO.selectGoodsByID(id);
        	String name=selectGoods.getName();
        	int price=selectGoods.getPrice();
        	int quantity=value.intValue();
        	int total=price*quantity;
        	String img=selectGoods.getImg();
        	newlistcart.add(new Cart(id, name, price, quantity,total, img));
        	totalprice+=price*quantity;
    	}
    	System.out.println("totalprice"+totalprice);
    	System.out.println("newlistcart"+newlistcart);
    	request.setAttribute("totalprice", totalprice);
    	request.setAttribute("newlistcart", newlistcart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
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
