package com.unmannedstore.accountmanagement.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unmannedstore.accountmanagement.dao.AccountDAO;
import com.unmannedstore.accountmanagement.model.Account;
import com.unmannedstore.imageupload.ImageResponse;
import com.unmannedstore.imageupload.ImgurAPI;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Servlet implementation class insertaccountServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AccountDAO accountDAO;
    private static String img_path="C:\\Users\\User\\Desktop\\image\\";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		accountDAO=new AccountDAO();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 接收顧客輸入的資料
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthday =request.getParameter("date");
		String memberimg=createImgurPATH(request.getParameter("memberimg"));
		int own_points=addpoints(request.getParameter("friendcode"));
		// 隨機產生顧客代碼
		String membercode = createMembercode();
		// 預設一般客戶等級為2
		int memberrank=2;
		// 首次註冊贈送100點數,推薦好友加贈50點數
		int memberpoints=100+own_points;
		Account newAccount = new Account(name, password, email, phone, birthday, memberimg, membercode, memberrank, memberpoints);
		try {
			accountDAO.insertAccount(newAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.print("註冊完成,請重新登入!");
		request.getRequestDispatcher("login.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	static ImgurAPI createImgurAPI(){
		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
			    .baseUrl(ImgurAPI.SERVER)
			    .build();
		return retrofit.create(ImgurAPI.class);
	}
	
	static String createImgurPATH(String memberimg) throws IOException {
		// 上傳圖片
		ImgurAPI imgurApi = createImgurAPI();
		img_path = img_path+memberimg;
		File image = new File(img_path);
		RequestBody req = RequestBody.create(MediaType.parse("image/*"), image);
		Call<ImageResponse> call =  imgurApi.postImage(req);
		Response<ImageResponse> res = call.execute();
		System.out.println("照片上傳狀況(T/F): " + res.isSuccessful()+"   ,照片路徑:"+res.body().data.link);	
		return res.body().data.link;
	}
	
	static String createcode() {
		// 隨機產生顧客代碼(2英文+5數字)
		char engs[] = {'a','b','c','d','e','f','g','h','i','j','k'};
		char nums[]={'1','2','3','4','5','6','7','8','9','0'};
		char randEngStr[] = new char[2];
		char randNumStr[] = new char[5];
		for (int i=0;i<2;i++)
		{
			randEngStr[i] = engs[(int)Math.round(Math.random() * (engs.length - 1))];
		}
		for (int i=0;i<5;i++)
		{
			randNumStr[i] = nums[(int)Math.round(Math.random() * (nums.length - 1))];
		}
		String returnEngStr = new String(randEngStr);
		String returnNumStr = new String(randNumStr);
		return returnEngStr+returnNumStr;
	}
	
	static String createMembercode() {	
		// 確認顧客代碼是否重複,如有重複重新產生一組顧客代碼
		String code=createcode();
		while(accountDAO.checkmembercode(code)) {
			code=createcode();
		}
		return code;
	}
	
	static int addpoints(String friendcode) {
		// 好友推薦贈點功能
		int own_points=0;
		if(accountDAO.checkmembercode(friendcode)) {
			own_points=50;
			int points=0;
			points=100+accountDAO.selectMemberpointsByMembercode(friendcode);
			try {
				accountDAO.updateMemberpoints(points, friendcode);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return own_points;
	}
	

}
