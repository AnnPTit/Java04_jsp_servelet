package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.User;
import repository.UserRepository;
import repository.Impl.UserImpl;
import service.UploadService;

@MultipartConfig()
@WebServlet("/views/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UploadService uploadService = new UploadService();
	UserImpl userImpl = new UserRepository();

	public ProfileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = userImpl.getUserbyUserName(username);
		request.setAttribute("userLogged", user);
		request.setAttribute("avatar", user.getAvatar());
		request.setAttribute("content", "profile");
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = userImpl.getUserbyUserName(username);

		String fileName = uploadService.upload(request, "avatar");
//		Part part = request.getPart("avatar");
//		String fileName = part.getSubmittedFileName();
//		String uploadFile = "/upload/" + fileName;
//		String realPath = request.getRealPath(uploadFile);
		if(fileName == null) {
			request.getSession().setAttribute("userLogged", user);
			request.setAttribute("avatar", session.getAttribute("avartar"));
			request.setAttribute("content", "profile");
			request.setAttribute("erorr", "No file is chose!");
//			request.setAttribute("avatar", "");
			request.getRequestDispatcher("/views/video.jsp").forward(request, response);
			return;
		}
//		part.write(realPath);
		session.setAttribute("avartar", fileName);
		// Update avartar
		user.setAvatar(fileName);
		userImpl.updateUser(user);
		request.getSession().setAttribute("userLogged", user);
		request.setAttribute("avatar", fileName);
		request.setAttribute("content", "profile");
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
		
		
//		response.sendRedirect(request.getContextPath() + "/views/profile");

	}

}
