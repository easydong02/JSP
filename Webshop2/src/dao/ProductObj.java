package dao;

public class ProductObj {
	
	private String pid;
	private String pname;
	private String pdescription;
	private String pprice;
	private String pfilename;
	
	public String getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public String getPprice() {
		return pprice;
	}
	public String getPfilename() {
		return pfilename;
	}
	
	public ProductObj(String pid, String pname, String pdescription, String pprice, String pfilename) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.pprice = pprice;
		this.pfilename = pfilename;
	}
	
	
}
