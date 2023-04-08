package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import repository.UserRepository;
import repository.Impl.UserImpl;

@WebServlet("/index")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<User> list = new ArrayList();
	private UserImpl userRepository = new UserRepository();

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet run ... ");

		list = userRepository.getList();
		System.out.println(list.size());
		request.setAttribute("list", list.get(0).getUsername());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
