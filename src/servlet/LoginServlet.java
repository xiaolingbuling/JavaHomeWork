package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginUser;
import user.User;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		user.setName(name);
		user.setPassword(pw);
		
		LoginUser dao = new LoginUser();
		User ruser = dao.loginuser(user);
		
		if(ruser != null) {
			request.setAttribute("user",ruser);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			System.out.println("账号密码错误");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
