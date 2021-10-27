package dao;

public class FeedObj {
	private String id, content, ts,images;
	
	public FeedObj(String id, String content, String ts, String images) {
		this.id =id;
		this.content = content;
		this.ts= ts;
		this.images=images;
	}

	public String getImages() {
		return this.images;
	}

	public String getId() {
		return this.id;
	}


	public String getContent() {
		return this.content;
	}


	public String getTs() {
		return this.ts;
	}
	
}
