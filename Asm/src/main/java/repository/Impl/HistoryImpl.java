package repository.Impl;

import java.util.Date;
import java.util.List;

import entity.History;

public interface HistoryImpl {

	History getHistoryByUserIdAndVideoId(int user, int video);

	Boolean updateViewDate(int userId, int videoId, Date date);

	Boolean createHistory(History history);

	Boolean like(int userId, int videoId);

	Boolean unlike(int userId, int videoId);

	List<History> getFavorite(int userID);
	
	public Boolean updateHistory(History history);
	

}