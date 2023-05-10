package Servlet;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			String url = "jdbc:mysql://localhost:3306/server";
			String username = "root";
			String passWord = "YOGIcr7123";
			Connection connection =
					DriverManager.getConnection(url, username, passWord);
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String sms = req.getParameter("sms");
			String date = req.getParameter("date");
			String gender = req.getParameter("gender");
			String state = req.getParameter("state");
			String queries = req.getParameter("queries");
			String query = "insert into details values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,password);
			pst.setString(3,email);
			pst.setString(4,sms);
			pst.setString(5,date);
			pst.setString(6,gender);
			pst.setString(7,state);
			pst.setString(8,queries);
			pst.executeUpdate();
			RequestDispatcher rd = req.getRequestDispatcher("success.html");
			rd.forward(req, res);
		} catch (Exception e) {e.printStackTrace();}
	}
}
