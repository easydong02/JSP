package dao;

public class FeedObj {
	private String id,content,ts,images;
	
	
	public String getId() {
		return id;
	}


	public String getContent() {
		return content;
	}


	public String getTs() {
		return ts;
	}


	public String getImages() {
		return images;
	}


	public FeedObj(String id,String content, String ts, String images) {
		this.id = id;
		this.content = content;
		this.ts = ts;
		this.images = images;
	}
}
