package dao;

public class TodoObj {
	private String no, id, todo, done, ts;

	public TodoObj(String no, String id, String todo, String done, String ts) {
		super();
		this.no = no;
		this.id = id;
		this.todo = todo;
		this.done = done;
		this.ts = ts;
	}

	public String getNo() {
		return this.no;
	}

	public String getId() {
		return this.id;
	}

	public String getTodo() {
		return this.todo;
	}
	
	public String getDone() {
		return this.done;
	}
	
	public String getTs() {
		return this.ts;
	}

}
