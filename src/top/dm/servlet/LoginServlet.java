package top.dm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.dm.dao.UserDao;
import top.dm.entity.User;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = UserDao.getLoginDao().findUser(username, password);
			if (user == null) {
				request.setAttribute("msg", "”√ªß√˚/√‹¬Î¥ÌŒÛ");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				response.sendRedirect(this.getServletContext().getContextPath() + "/index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
