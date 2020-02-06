package com.unmannedstore.temperature;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tempServlet
 */
@WebServlet("/tempServlet")
public class tempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private temperatureDAO temperatureDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		temperatureDAO=new temperatureDAO();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		List<temperature> listTemperatures = temperatureDAO.selectAllTemp();
		request.setAttribute("listTemperatures", listTemperatures);
		RequestDispatcher dispatcher = request.getRequestDispatcher("temp-list.jsp");
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
