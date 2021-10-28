package dao;

public class UserObj {
	private String id,name,ts;
	
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getTs() {
		return ts;
	}


	public UserObj(String id, String name, String ts) {
		this.id = id;
		this.name = name;
		this.ts = ts;
	}
}
