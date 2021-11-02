package dao;

public class UserObj {
	String id,pw,name,ts;

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getTs() {
		return ts;
	}

	public UserObj(String id, String pw, String name, String ts) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ts = ts;
	}
	
	
}
