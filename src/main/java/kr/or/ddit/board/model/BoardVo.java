package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private int b_no;
	private int id;
	private String b_boardname;
	private String b_name;
	private Date b_date;
	private String b_use;
	
	public BoardVo(){}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getB_boardname() {
		return b_boardname;
	}

	public void setB_boardname(String b_boardname) {
		this.b_boardname = b_boardname;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public String getB_use() {
		return b_use;
	}

	public void setB_use(String b_use) {
		this.b_use = b_use;
	}

	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", id=" + id + ", b_boardname="
				+ b_boardname + ", b_name=" + b_name + ", b_date=" + b_date
				+ ", b_use=" + b_use + "]";
	}
}