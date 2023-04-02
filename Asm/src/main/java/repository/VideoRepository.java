package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import customModel.UserCustomModel;
import customModel.videoCustomModel;
import entity.Video;
import util.HibernateUtil;

public class VideoRepository {
	public List<Video> getList() {
		List<Video> list = new ArrayList<Video>();
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			Query query = session.createQuery("FROM Video where isActive=1 order by id desc ");
			list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}


	public List<videoCustomModel> getListSortByViewUp() {
		List<videoCustomModel> list = new ArrayList<videoCustomModel>();
		try (Session session = HibernateUtil.getFACTORY().openSession();) {
			Query query = session.createNativeQuery(
					"select video.id,video.title,video.href,SUM(CAST(history.isLiked as int)) as totalLike,video.views,video.shares,video.description from video"
							+ " left join history on history.videoId = video.id where video.isActive =1 "
							+ "	group by video.id,title,href,views,shares,description order by views desc");
			List<Object[]> liObjects = query.getResultList();
			liObjects.forEach((p) -> {
				videoCustomModel videoCustomModel = new videoCustomModel();
				videoCustomModel.setId((Integer) p[0]);
				videoCustomModel.setTitle((String) p[1]);
				videoCustomModel.setHref((String) p[2]);
				videoCustomModel.setLike((Integer) p[3] == null ? 0 : (Integer) p[3]);
				videoCustomModel.setView((Integer) p[4]);
				videoCustomModel.setShare((Integer) p[5]);
				videoCustomModel.setDescription((String) p[6]);
				list.add(videoCustomModel);

			});
			return list;
		} catch (Exception e) {
			
		}
		return null;

	}
	public List<videoCustomModel> getListSortByViewDown() {
		List<videoCustomModel> list = new ArrayList<videoCustomModel>();
		try (Session session = HibernateUtil.getFACTORY().openSession();) {
			Query query = session.createNativeQuery(
					"select video.id,video.title,video.href,SUM(CAST(history.isLiked as int)) as totalLike,video.views,video.shares,video.description from video"
							+ " left join history on history.videoId = video.id where video.isActive =1 "
							+ "	group by video.id,title,href,views,shares,description order by views asc");
			List<Object[]> liObjects = query.getResultList();
			liObjects.forEach((p) -> {
				videoCustomModel videoCustomModel = new videoCustomModel();
				videoCustomModel.setId((Integer) p[0]);
				videoCustomModel.setTitle((String) p[1]);
				videoCustomModel.setHref((String) p[2]);
				videoCustomModel.setLike((Integer) p[3] == null ? 0 : (Integer) p[3]);
				videoCustomModel.setView((Integer) p[4]);
				videoCustomModel.setShare((Integer) p[5]);
				videoCustomModel.setDescription((String) p[6]);
				list.add(videoCustomModel);

			});
			return list;
		} catch (Exception e) {
			
		}
		return null;

	}

	public List<videoCustomModel> getListSortByLikeUp() {
		List<videoCustomModel> list = new ArrayList<videoCustomModel>();
		try (Session session = HibernateUtil.getFACTORY().openSession();) {
			Query query = session.createNativeQuery(
					"select video.id,video.title,video.href,SUM(CAST(history.isLiked as int)) as totalLike,video.views,video.shares,video.description from video"
							+ " left join history on history.videoId = video.id where video.isActive =1 "
							+ "	group by video.id,title,href,views,shares,description order by SUM(CAST(history.isLiked as int)) desc");
			List<Object[]> liObjects = query.getResultList();
			liObjects.forEach((p) -> {
				videoCustomModel videoCustomModel = new videoCustomModel();
				videoCustomModel.setId((Integer) p[0]);
				videoCustomModel.setTitle((String) p[1]);
				videoCustomModel.setHref((String) p[2]);
				videoCustomModel.setLike((Integer) p[3] == null ? 0 : (Integer) p[3]);
				videoCustomModel.setView((Integer) p[4]);
				videoCustomModel.setShare((Integer) p[5]);
				videoCustomModel.setDescription((String) p[6]);
				list.add(videoCustomModel);

			});
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<videoCustomModel> getListSortByLikeDown() {
		List<videoCustomModel> list = new ArrayList<videoCustomModel>();
		try (Session session = HibernateUtil.getFACTORY().openSession();) {
			Query query = session.createNativeQuery(
					"select video.id,video.title,video.href,SUM(CAST(history.isLiked as int)) as totalLike,video.views,video.shares,video.description from video"
							+ " left join history on history.videoId = video.id where video.isActive =1 "
							+ "	group by video.id,title,href,views,shares,description order by SUM(CAST(history.isLiked as int)) asc");
			List<Object[]> liObjects = query.getResultList();
			liObjects.forEach((p) -> {
				videoCustomModel videoCustomModel = new videoCustomModel();
				videoCustomModel.setId((Integer) p[0]);
				videoCustomModel.setTitle((String) p[1]);
				videoCustomModel.setHref((String) p[2]);
				videoCustomModel.setLike((Integer) p[3] == null ? 0 : (Integer) p[3]);
				videoCustomModel.setView((Integer) p[4]);
				videoCustomModel.setShare((Integer) p[5]);
				videoCustomModel.setDescription((String) p[6]);
				list.add(videoCustomModel);

			});
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public List<UserCustomModel> showUserLike(int videoId) {
		List<UserCustomModel> list = new ArrayList<UserCustomModel>();
		try (Session session = HibernateUtil.getFACTORY().openSession();) {
			Query query = session.createNativeQuery(
					"select [user].username,email from [user] join history on history.userId = [user].id  where videoId =:videoId and isLiked =1 ");
			query.setParameter("videoId", videoId);
			List<Object[]> liObjects = query.getResultList();
			liObjects.forEach((p) -> {
				UserCustomModel userCustomModel = new UserCustomModel();
				userCustomModel.setUsername((String) p[0]);
				userCustomModel.setEmail((String) p[1]);
				list.add(userCustomModel);
			});
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Video getVideo(int id) {
		Video video = new Video();
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			Query query = session.createQuery("FROM Video where id =:id and isActive=1");
			query.setParameter("id", id);
			video = (Video) query.getSingleResult();
			return video;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public Video getVideoByHref(String href) {
		Video video = new Video();
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			Query query = session.createQuery("FROM Video where href =:href and isActive=1");
			query.setParameter("href", href);
			video = (Video) query.getSingleResult();
			return video;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public List<Video> getVideoByTitle(String title) {
		List<Video> video = new ArrayList<>();
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			Query query = session.createQuery("FROM Video where title like :title and isActive=1");
			query.setParameter("title", "%" + title + "%");
			video = query.getResultList();
			return video;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public Boolean updateView(int videoID, int view) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("Update Video set views=:view where id=:id");
			query.setParameter("view", view + 1);
			query.setParameter("id", videoID);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public Boolean updateShare(int videoID, int view) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("Update Video set shares=:view where id=:id");
			query.setParameter("view", view + 1);
			query.setParameter("id", videoID);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public Boolean create(Video video) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			session.save(video);
			/*
			 * query.setParameter("view", view + 1); query.setParameter("id", videoID);
			 * query.executeUpdate();
			 */
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public Boolean update(Video video) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			session.update(video);
			/*
			 * query.setParameter("view", view + 1); query.setParameter("id", videoID);
			 * query.executeUpdate();
			 */
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public Boolean delete(int videoID) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("Update Video set isActive=0 where id=:id");

			query.setParameter("id", videoID);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return false;
	}

	public List<Video> paginationVideo(int index) {
		List<Video> ds = new ArrayList<>();

		try (Session session = HibernateUtil.getFACTORY().openSession()) {
			int pageSize = 6; // Số bản ghi trên mỗi trang
			int start = (index - 1) * pageSize; // Vị trí bắt đầu
			String sql = "SELECT * FROM Video ORDER BY views desc OFFSET :start ROWS FETCH NEXT 6 ROWS ONLY";
			Query query = session.createNativeQuery(sql, Video.class);
			query.setParameter("start", start);
			ds = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
