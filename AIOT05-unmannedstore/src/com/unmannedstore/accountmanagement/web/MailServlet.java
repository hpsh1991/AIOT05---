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
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private int port;
	private String username;
	private String password;
	private Properties props;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
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
		
		if(email=="") {
			System.out.println("帳號未輸入,無法重製密碼");
			out.print("<p align='center'\">請輸入帳號後再點選忘記密碼!!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}else {
			AccountDAO account= new AccountDAO();
			String to =account.selectAccountByEmail(email).getEmail();
			String NewPassword = "";
			for(int i=0;i<8;i++){
			    NewPassword+=Integer.toString((int) (Math.random()*9+1));
			}
			try {
				account.updatePassword(email, NewPassword);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Message message = creatMessage(to,email,NewPassword);
			try {
				Transport.send(message);
			} catch (MessagingException e) {
					e.printStackTrace();
			}
			System.out.println("重製密碼已寄送至客戶的信箱");
			out.print("<p align='center'\">重製密碼已寄送至您的信箱!!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	Message creatMessage(String to,String email ,String NewPassword) {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}}
		);
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("aiotunmannedstore@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("密碼重製");
			message.setSentDate(new Date());
			message.setText("您的帳號:"+email+",密碼已經重製為:"+NewPassword+",登入後請記得更改密碼!");
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
