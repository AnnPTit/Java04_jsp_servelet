package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "href")
	private String href;

	@Column(name = "poster")
	private String poster;

	@Column(name = "views")
	private Integer views;

	@Column(name = "shares")
	private Integer shares;

	@Column(name = "description")
	private String description;

	@Column(name = "isActive")
	private Boolean isActive;

	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	private List<History> liHistories;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(Integer id, String title, String href, String poster, Integer views, Integer shares,
			String description, Boolean isActive, List<History> liHistories) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.shares = shares;
		this.description = description;
		this.isActive = isActive;
		this.liHistories = liHistories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<History> getLiHistories() {
		return liHistories;
	}

	public void setLiHistories(List<History> liHistories) {
		this.liHistories = liHistories;
	}

}