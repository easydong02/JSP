package dao;

public class BoardObj {
	
	private String bid;
	private String btitle;
	private String bcontent;
	private String bmember;
	private String bfilename;
	private String bdate;
	public String getBid() {
		return bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public String getBmember() {
		return bmember;
	}
	public String getBfilename() {
		return bfilename;
	}
	public String getBdate() {
		return bdate;
	}
	public BoardObj(String bid, String btitle, String bcontent, String bmember, String bfilename, String bdate) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bmember = bmember;
		this.bfilename = bfilename;
		this.bdate = bdate;
	}
	

}
