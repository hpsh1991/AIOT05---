package com.unmannedstore.accountmanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Servlet implementation class SMSServlet
 */
@WebServlet("/SMSServlet")
public class SMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ACCOUNT_SID =
            "ACa4c0a4fad1104c35ae284d3b9de97778";
    public static final String AUTH_TOKEN =
            "17b02d13614e7ef455c25836c70e0e1e";
    public static final String TAIWAN ="+886"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMSServlet() {
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
		String phone = request.getParameter("phone");
		String code=createcode();
		//SMS
		//System.out.println(SMSsend(phone, code));
		System.out.println("[Twilio]已從系統發送驗證碼簡訊至:"+phone+"驗證碼為:"+code);
		
        HttpSession session=request.getSession();
		session.setAttribute("phone", phone);
		session.setAttribute("phoneCode", code);
		RequestDispatcher rd = request.getRequestDispatcher("phonecheck.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	static String createcode() {
		// 隨機產生手機驗證碼(5數字)
		char nums[]={'1','2','3','4','5','6','7','8','9','0'};
		char randNumStr[] = new char[5];
		for (int i=0;i<5;i++)
		{
			randNumStr[i] = nums[(int)Math.round(Math.random() * (nums.length - 1))];
		}
		String returnNumStr = new String(randNumStr);
		return returnNumStr;
	}
	
	static String SMSsend(String phone,String code) {
		//手機驗證碼
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber(TAIWAN+phone), // to
                        new PhoneNumber("+12158393212"), // from
                        "code is:"+code)
                .create();
        
        
		
		return "[Twilio]id:"+message.getSid();
	}

}
