package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.History;
import entity.User;
import entity.Video;
import repository.HistoryRepository;
import repository.UserRepository;
import repository.VideoRepository;
import repository.Impl.HistoryImpl;
import repository.Impl.UserImpl;
import repository.Impl.VideoImpl;
import util.EmailUtility;

@WebServlet(urlPatterns = { "/views/video", "/video/detail", "/like", "/views/favorite", "/views/sendEmail", "/share",
		"/video", "/views/search" })
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Video> liVideos = new ArrayList<>();
	VideoImpl videoRepository = new VideoRepository();
	HistoryImpl historyRepository = new HistoryRepository();
	UserImpl userRepository = new UserRepository();
	EmailUtility emailUtility = new EmailUtility();

	public VideoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		System.out.println(uri);
		if (uri.contains("detail")) {
			this.detailVideo(request, response);
		} else if (uri.contains("like")) {
			this.like(request, response);
		} else if (uri.contains("share")) {
			this.share(request, response);
		} else if (uri.contains("sendEmail")) {
			request.getRequestDispatcher("/views/sendEmail.jsp").forward(request, response);
			return;
		} else if (uri.contains("favorite")) {
			this.favorite(request, response);
		} else if (uri.contains("search")) {
//			request.getRequestDispatcher("/views/video.jsp").forward(request, response);
			this.search(request, response);

		} else if (uri.contains("views/video")) {
			HttpSession session1 = request.getSession();
			String username = (String) session1.getAttribute("username");
			String avatar = (String) session1.getAttribute("avartar");
			if (avatar == null) {
				avatar = "user.png";
			}
			liVideos = videoRepository.getList();
			int size = liVideos.size();
			int itemPerPage = size / 6;
			if (size % 6 != 0) {
				itemPerPage++;
			}
			String page = request.getParameter("page");
			int index = 0;
			if (page == null) {
				index = 1;
			} else {
				index = Integer.valueOf(page);
			}
			liVideos = videoRepository.paginationVideo(index);
			request.setAttribute("itemPerPage", itemPerPage);
			HttpSession session11 = request.getSession();
			int log = 0;
			if (session11.getAttribute("isLogin") == null) {
				log = 0;
			} else {
				log = (Integer) session11.getAttribute("isLogin");
			}
			request.setAttribute("username", username);
			request.setAttribute("avatar", avatar);
			request.setAttribute("isLogin", log);
			request.setAttribute("content", "content");
			System.out.println(liVideos.size());
			request.setAttribute("list", liVideos);
			request.getRequestDispatcher("/views/video.jsp").forward(request, response);

		}

	}

	private void share(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String path = request.getContextPath();
		if (username == null) {
			response.sendRedirect(path + "/views/login");
		} else {
			String index = request.getParameter("index");
			int id = Integer.valueOf(index);
			Video video = videoRepository.getVideo(id);
			request.setAttribute("video", video);
//			response.sendRedirect(path + "/views/sendEmail");
			request.getRequestDispatcher("/views/sendEmail.jsp").forward(request, response);
		}

	}

	private void favorite(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		System.out.println("favorite...");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		HttpSession session11 = request.getSession();
		int log = 0;
		if (session11.getAttribute("isLogin") == null) {
			log = 0;
		} else {
			log = (Integer) session11.getAttribute("isLogin");
		}
		String path = request.getContextPath();
//		System.out.println(username);
		if (username == null) {
			response.sendRedirect(path + "/views/login");
		} else {
			User user = userRepository.getUserbyUserName(username);
			List<History> listFavorite = historyRepository.getFavorite(user.getId());
//			System.out.println(listFavorite);
			request.setAttribute("listFavorite", listFavorite);
			request.setAttribute("content", "myFavorite");
			request.setAttribute("avatar", user.getAvatar());
			request.getRequestDispatcher("/views/video.jsp").forward(request, response);

		}

	}

	private void like(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String path = request.getContextPath();
		if (username == null) {
			response.sendRedirect(path + "/views/login");
		} else {
			User user = userRepository.getUserbyUserName(username);
			String index = request.getParameter("index");
			int id = Integer.valueOf(index);
			Video video = videoRepository.getVideo(id);
			historyRepository.like(user.getId(), video.getId());
			System.out.println(user.getId());
			System.out.println(video.getId());
			System.out.println("Like thanh cong");
			response.sendRedirect(path + "/video/detail?index=" + video.getId());

		}

	}

	private void detailVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String index = request.getParameter("index");
		int id = Integer.valueOf(index);
		Video video = videoRepository.getVideo(id);
//		Tang 1 view 
		videoRepository.updateView(video.getId(), video.getViews());
//		---------------
//		Kiem tra xem da dang nhap chua 
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		History history = new History();
		String isLike = "ok";
		String isUnlike = "hide";
		if (username != null) {
			User user = userRepository.getUserbyUserName(username);
			history = historyRepository.getHistoryByUserIdAndVideoId(user.getId(), video.getId());
//			Da co record -> update ngay
			if (history != null) {
				history.setLikedDate(new Date());
				historyRepository.updateViewDate(user.getId(), video.getId(), new Date());
				if (history.getIsLiked() == true) {
					isLike = "hide";
					isUnlike = "show";
				} else {

				}

			} else {
				history = new History();
				history.setUser(user);
				history.setVideo(video);
				history.setViewDate(new Date());
				history.setIsLiked(false);
				history.setIsShared(false);
				history.setLikedDate(null);
				historyRepository.createHistory(history);
				System.out.println("Them Thanh cong history");
			}
		} else {

		}

		request.setAttribute("isUnlike", isUnlike);
		request.setAttribute("isLike", isLike);
		request.setAttribute("videoDetail", video);
		request.getRequestDispatcher("/views/video_detail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost run ...");
		String uri = request.getRequestURI();
		if (uri.contains("share")) {
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			Video video = videoRepository.getVideo(Integer.valueOf(id));
			this.guiMail(request, response);
			videoRepository.updateShare(video.getId(), video.getShares());
			// Cap nhat isShare in History
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			String path = request.getContextPath();
			if(username == null) {
				response.sendRedirect(path + "/views/login");
			}else {
				User user = userRepository.getUserbyUserName(username);
				History history = new History();
				history = historyRepository.getHistoryByUserIdAndVideoId(user.getId(), video.getId());
				history.setIsShared(true);
				historyRepository.updateHistory(history);
				
			}
			System.out.println("Cap nhat share thanh cong");
		}
//		if (uri.contains("search")) {
//			this.search(request, response);
//		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session11 = request.getSession();
		int log = 0;
		if (session11.getAttribute("isLogin") == null) {
			log = 0;
		} else {
			log = (Integer) session11.getAttribute("isLogin");
		}

		String avatar = (String) session11.getAttribute("avartar");
		if (avatar == null) {
			avatar = "user.png";
		}
		request.setAttribute("avatar", avatar);
		request.setAttribute("isLogin", log);
		String title = request.getParameter("key");
		List<Video> liVideos = videoRepository.getVideoByTitle(title);
		request.setAttribute("list", liVideos);

		request.setAttribute("content", "content");
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
//		String path = request.getContextPath();
//		response.sendRedirect(path + "/views/video");
	}

	private void guiMail(HttpServletRequest request, HttpServletResponse response) {
		try {
			String email = request.getParameter("email");
			String href = request.getParameter("href");
			emailUtility.guiMail(email, " Xem Video Cùng Tôi : https://www.youtube.com/embed/" + href);
			System.out.println("Gui mail thanh cong toi : "+email);
			String path = request.getContextPath();
			response.sendRedirect(path + "/views/video");
		} catch (Exception e) {
			System.out.println("Loi");
			System.out.println(e);
		}

	}

}
