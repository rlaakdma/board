package kr.or.ddit.comments.model;

import java.util.Date;

public class CommentsVo {
	private int c_no; // 댓글번호
	private String c_cnt; // 댓글내용
	private int w_no; // 게시글번호
	private int id; // 학생번호
	private Date c_date; // 등록날짜
	private String c_name; // 작성자
	private String c_dlt; // 삭제여부
	
	public CommentsVo () {}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_cnt() {
		return c_cnt;
	}

	public void setC_cnt(String c_cnt) {
		this.c_cnt = c_cnt;
	}

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_dlt() {
		return c_dlt;
	}

	public void setC_dlt(String c_dlt) {
		this.c_dlt = c_dlt;
	}

	@Override
	public String toString() {
		return "CommentsVo [c_no=" + c_no + ", c_cnt=" + c_cnt + ", w_no="
				+ w_no + ", id=" + id + ", c_date=" + c_date + ", c_name="
				+ c_name + ", c_dlt=" + c_dlt + "]";
	}
}