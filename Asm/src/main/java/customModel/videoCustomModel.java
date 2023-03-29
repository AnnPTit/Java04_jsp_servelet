package customModel;

public class videoCustomModel {

	private int id;
	private String title, href;
	private int like, view, share;
	private String description;

	public videoCustomModel(int id, String title, String href, int like, int view, int share, String description) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.like = like;
		this.view = view;
		this.share = share;
		this.description = description;
	}

	public videoCustomModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
