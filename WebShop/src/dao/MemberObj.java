package dao;

public class MemberObj {
	private String cid,cpassword,cname,cgender,cbirth,cemail,cphone,caddress,cregiday;
	
	public String getCid() {
		return cid;
	}
	public String getCpassword() {
		return cpassword;
	}
	public String getCname() {
		return cname;
	}
	public String getCgender() {
		return cgender;
	}
	public String getCbirth() {
		return cbirth;
	}
	public String getCemail() {
		return cemail;
	}
	public String getCphone() {
		return cphone;
	}
	public String getCaddress() {
		return caddress;
	}
	public String getCregiday() {
		return cregiday;
	}
	
	
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
}


