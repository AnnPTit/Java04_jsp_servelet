package repository.Impl;

import java.util.List;

import customModel.UserCustomModel;
import customModel.videoCustomModel;
import entity.Video;

public interface VideoImpl {

	List<Video> getList();

	List<videoCustomModel> getListSortByViewUp();

	List<videoCustomModel> getListSortByViewDown();

	List<videoCustomModel> getListSortByLikeUp();

	List<videoCustomModel> getListSortByLikeDown();

	List<UserCustomModel> showUserLike(int videoId);

	List<UserCustomModel> showUserShare(int videoId);

	Video getVideo(int id);

	Video getVideoByHref(String href);

	List<Video> getVideoByTitle(String title);

	Boolean updateView(int videoID, int view);

	Boolean updateShare(int videoID, int view);

	Boolean create(Video video);

	Boolean update(Video video);

	Boolean delete(int videoID);

	List<Video> paginationVideo(int index);

}