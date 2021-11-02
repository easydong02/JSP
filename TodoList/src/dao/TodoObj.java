package dao;

public class TodoObj {
	private String no,id,todo,ts;

	public String getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getTodo() {
		return todo;
	}

	public String getTs() {
		return ts;
	}

	public TodoObj(String no, String id, String todo, String ts) {
		super();
		this.no = no;
		this.id = id;
		this.todo = todo;
		this.ts = ts;
	}
	
	
	
	
}
