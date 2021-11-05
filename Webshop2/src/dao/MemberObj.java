package dao;

public class MemberObj {
	String cid;
	String cpassword;
	String cname;
	String cgender;
	String cbirth;
	String cemail;
	String cphone;
	String caddress;
	String cregiday;
	
	public MemberObj(String cid, String cpassword, String cname, String cgender, String cbirth, String cemail,
			String cphone, String caddress, String cregiday) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cgender = cgender;
		this.cbirth = cbirth;
		this.cemail = cemail;
		this.cphone = cphone;
		this.caddress = caddress;
		this.cregiday = cregiday;
	}
	
	public String getCid() {
		return this.cid;
	}
	public String getCpassword() {
		return this.cpassword;
	}
	public String getCname() {
		return this.cname;
	}
	public String getCgender() {
		return this.cgender;
	}
	public String getCbirth() {
		return this.cbirth;
	}
	public String getCemail() {
		return this.cemail;
	}
	public String getCphone() {
		return this.cphone;
	}
	public String getCaddress() {
		return this.caddress;
	}
	public String getCregiday() {
		return this.cregiday;
	}
}
