package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import repository.UserRepository;
import repository.Impl.UserImpl;
import util.EmailUtility;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/views/login", "/views/register", "/views/forgot", "/forgot", "/views/changepass",
		"/changepass", "/views/logout" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UserImpl userRepository = new UserRepository();
	EmailUtility emailUtility = new EmailUtility();

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return;
		} else if (uri.contains("register")) {
			request.getRequestDispatcher("/views/Register.jsp").forward(request, response);
			return;
		} else if (uri.contains("forgot")) {
			request.getRequestDispatcher("/views/Forget.jsp").forward(request, response);
			return;
		} else if (uri.contains("changepass")) {
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			return;
		} else if (uri.contains("logout")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", null);
			session.setAttribute("password", null);
			session.setAttribute("isLogin", 0);
			session.setAttribute("avartar", "user.png");
//			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			String path = request.getContextPath();
			response.sendRedirect(path + "/views/login");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (uri.contains("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			if (username == null) {
//				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				String path = request.getContextPath();
				response.sendRedirect(path + "/views/login");

			} else {
				user = userRepository.logIn(username, password);
			}

			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("isLogin",1);
				session.setAttribute("isAdmin", 0);
				session.setAttribute("avartar",user.getAvatar());
//				System.out.println(user.getAvatar());
				String path = request.getContextPath();
				if (user.getIsAdmin() == true) {
					session.setAttribute("isAdmin", 1);
					response.sendRedirect(path + "/admins/Admin");
				} else {
//					response.sendRedirect(path + "/views/video");
					HttpSession session1 = request.getSession();
					int isLog = (Integer) session1.getAttribute("isLogin");
					request.setAttribute("isLogin", isLog);
//					request.getRequestDispatcher("/views/video.jsp").forward(request, response);
					response.sendRedirect(path + "/views/video");
					return;
				}

			} else {
				request.setAttribute("error", "This account is not valid!");
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);

			}
		}

		if (uri.contains("forgot")) {
			try {
				this.sendNewPass(request, response);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (uri.contains("changepass")) {
			this.changePass(request, response);
		}

	}

	private void changePass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String path = request.getContextPath();
		String pass = request.getParameter("password");
		String newPass = request.getParameter("newPass");
		String rePass = request.getParameter("reNewPass");

		if (!newPass.equals(rePass)) {
			request.setAttribute("mess", "Password does not match ");
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			return;
		}
		if (username == null) {
			request.setAttribute("mess", "Please login frist!");
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);

		} else {
			User user = userRepository.getUserbyUserName(username);
			if (!user.getPassword().equals(pass)) {
				request.setAttribute("mess", "Password incorect! ");
				request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
				return;
			} else {
				user.setPassword(newPass);
				userRepository.updateUser(user);
				System.out.println("Cap Nhat Mat Khau Thanh Cong");
//				request.getRequestDispatcher("/views/ChangePass").forward(request, response);
				response.sendRedirect(path + "/views/login");
			}

		}
	}

	private void sendNewPass(HttpServletRequest request, HttpServletResponse response)
			throws AddressException, MessagingException, ServletException, IOException {
		String email = request.getParameter("email");
		User user = userRepository.getUserByEmail(email);
		if (user == null) {
			HttpSession session = request.getSession();
			session.setAttribute("mess", "Email is not valid");
			String path = request.getContextPath();
			request.getRequestDispatcher("/views/Forget.jsp").forward(request, response);
			return;
		}

		String pass = user.getPassword();
		emailUtility.guiMail(email, "Your password is " + pass);
		HttpSession session = request.getSession();
		session.setAttribute("mess", "Password Will send to your email");
		String path = request.getContextPath();
		response.sendRedirect(path + "/views/login");
	}

}
