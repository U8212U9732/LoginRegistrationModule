package top.dm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.dm.dao.UserDao;
import top.dm.entity.User;

public class RegServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && password != null) {
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setPassword(password);
			boolean reg=UserDao.getLoginDao().addUser(user);
			if(reg){
				response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp");
			}else{
				request.setAttribute("msg", "注册失败");
				this.getServletContext().getRequestDispatcher("/reg.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "用户名/密码不能为空");
			this.getServletContext().getRequestDispatcher("/reg.jsp").forward(request, response);
		}

	}

}
