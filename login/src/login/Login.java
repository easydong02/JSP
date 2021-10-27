package login;

public class Login {
	
	
	private String userid;
	private String userpw;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
	public boolean checkLogin() {
		String id = "abc";
		String pw = "1234";
		if(this.userid.equals(id) && this.userpw.equals(pw))
			return true;
		else {
			return false;
		}
	}
	
}
