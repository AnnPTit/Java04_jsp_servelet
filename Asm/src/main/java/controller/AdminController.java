package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import customModel.UserCustomModel;
import customModel.videoCustomModel;
import entity.User;
import entity.Video;
import repository.HistoryRepository;
import repository.UserRepository;
import repository.VideoRepository;
import repository.Impl.HistoryImpl;
import repository.Impl.UserImpl;
import repository.Impl.VideoImpl;

@WebServlet(urlPatterns = { "/admins/Admin", "/admins/Admin/add", "/admins/Admin/update", "/admins/Admin/deleteUser" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Video> liVideos = new ArrayList<>();
	VideoImpl videoRepository = new VideoRepository();
	HistoryImpl historyRepository = new HistoryRepository();
	UserImpl userRepository = new UserRepository();

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "sortUpLike";
		}
		String page = request.getParameter("page");
		String uri = request.getRequestURI();
		if (uri.contains("deleteUser")) {
			this.deleteUser(request, response);
			return;
		}

		if (page == null) {
			page = "home";
		} else if (page.equals("Update")) {
			System.out.println("Update run ");
			String id = request.getParameter("id");
			int id1 = Integer.valueOf(id);
			Video video = videoRepository.getVideo(id1);
			request.setAttribute("video", video);

		} else if (page.equals("Delete")) {
			int id = Integer.valueOf(request.getParameter("id"));
			videoRepository.delete(id);
			System.out.println("Xoa Thanh Cong");
			String path = request.getContextPath();
			response.sendRedirect(path + "/admins/Admin?page=video");
			return;

		} else if (page.equals("ManagerUser")) {
			List<User> list = new ArrayList<>();
			list = userRepository.getList();
			request.setAttribute("listUser", list);
			System.out.println(list.size());

		} else if (page.equals("video")) {
			List<Video> liVideos = videoRepository.getList();
			request.setAttribute("page", page);
			request.setAttribute("listVideo", liVideos);
			request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
			return;
		}
		request.setAttribute("page", page);
		System.out.println(action);
		if ("sortUpLike".equals(action)) {
			this.sortUpLike(request, response);
		} else if ("sortDownLike".equals(action)) {
			this.sortDownLike(request, response);
		} else if ("showUserLike".equals(action)) {
			this.showUserLike(request, response);
		}else if ("sortUpView".equals(action)) {
			this.sortUpView(request, response);
		}else if ("sortDownView".equals(action)) {
			this.sortDownView(request, response);
		}else if ("showUserShare".equals(action)) {
			this.showUserShare(request, response);
		}

	}

	private void showUserShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index = request.getParameter("index");
		List<UserCustomModel> listUser = videoRepository.showUserShare(Integer.valueOf(index));
//		System.out.println(listUser.size());
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByLikeUp();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.setAttribute("ListUserLike", listUser);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;
		
	}

	private void sortDownView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByViewDown();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;
		
	}

	private void sortUpView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByViewUp();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;
		
	}

	private void showUserLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		List<UserCustomModel> listUser = videoRepository.showUserLike(Integer.valueOf(index));
//		System.out.println(listUser.size());
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByLikeUp();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.setAttribute("ListUserLike", listUser);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;
	}

	private void sortUpLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByLikeUp();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;
	}

	private void sortDownLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<videoCustomModel> list = new ArrayList<>();
		list = videoRepository.getListSortByLikeDown();
		System.out.println(list.size());
		System.out.println(list.get(0).getTitle());
		request.setAttribute("listVideo", list);
		request.getRequestDispatcher("/admins/Admin.jsp").forward(request, response);
		return;

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("index");
		User user = userRepository.getUserByID(Integer.valueOf(id));
		user.setIsActive(false);
		userRepository.updateUser(user);
		System.out.println("Xoa Thanh Cong");
		String path = request.getContextPath();
		response.sendRedirect(path + "/admins/Admin?page=ManagerUser");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("add")) {
			this.add(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String href = request.getParameter("href");
		String poster = request.getParameter("poster");
		String description = request.getParameter("description");
		Video video1 = videoRepository.getVideoByHref(href);
		Video video = new Video();
		video.setId(video1.getId());
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		video.setIsActive(true);
		video.setViews(video1.getViews());
		video.setShares(video1.getShares());
		videoRepository.update(video);
		String path = request.getContextPath();
		response.sendRedirect(path + "/admins/Admin?page=video");

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String href = request.getParameter("href");
		String poster = request.getParameter("poster");
		String description = request.getParameter("description");
		Video video = new Video();
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		video.setIsActive(true);
		video.setViews(0);
		video.setShares(0);
		videoRepository.create(video);
		System.out.println("Them video thanh cong");
		String path = request.getContextPath();
		response.sendRedirect(path + "/admins/Admin?page=video");
	}

}
