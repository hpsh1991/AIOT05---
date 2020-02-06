package com.unmannedstore.accountmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unmannedstore.accountmanagement.dao.AccountDAO;
import com.unmannedstore.accountmanagement.model.Account;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/RegMailServlet")
public class RegMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private int port;
	private String username;
	private String password;
	private Properties props;
	private AccountDAO accountDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		host = "smtp.gmail.com";
		port = 587;
		username = "aiotunmannedstore@gmail.com";
		password = "aiot05raspberry";
		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		AccountDAO account= new AccountDAO();
		String to =email;
		String VerificationCode = "";
		for(int i=0;i<8;i++){
			VerificationCode+=Integer.toString((int) (Math.random()*9+1));
		}
		Message message = creatMessage(to,email,VerificationCode);
//		try {
//			Transport.send(message);
//		} catch (MessagingException e) {
//				e.printStackTrace();
//		}
		System.out.println("驗證碼密碼已寄送至"+email+",驗證碼:"+VerificationCode);
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("VerificationCode", VerificationCode);
		RequestDispatcher rd = request.getRequestDispatcher("register2.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	Message creatMessage(String to,String email ,String VerificationCode) {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}}
		);
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("aiotunmannedstore@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("信箱驗證");
			message.setSentDate(new Date());
			message.setText("驗證碼:"+VerificationCode);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
    }

}
