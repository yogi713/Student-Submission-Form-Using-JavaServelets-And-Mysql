package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			PrintWriter print = res.getWriter();
			String url = "jdbc:mysql://localhost:3306/server";
			String username = "root";
			String password = "YOGIcr7123";
			Connection connection =
					DriverManager.getConnection(url, username, password);
			String n = req.getParameter("name");
			String p = req.getParameter("password");
			String query = "insert into numbers values(?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,n);
			pst.setString(2,p);
			pst.executeUpdate();
			RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
			rd.forward(req, res);
		} catch (Exception e) {e.printStackTrace();}
	}
}
