package kr.or.ddit.write.model;

import java.util.Date;

public class WriteVo {
	private int w_no; 		// 게시글번호
	private int b_no; 		// 게시판번호
	private int w_pno; 		// 게시글번호(부모게시글)
	private int id; 		// 아이디
	private String w_title; // 제목
	private int w_gno; 	 	// 게시글그룹번호
	private Date w_date; 	// 작성일시
	private String w_cnt; 	// 게시글내용
	private String w_name;  // 게시글작성자
	private String w_dlt;   // 게시글삭제여부
	
	public WriteVo(){}

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getW_pno() {
		return w_pno;
	}

	public void setW_pno(int w_pno) {
		this.w_pno = w_pno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getW_title() {
		return w_title;
	}

	public void setW_title(String w_title) {
		this.w_title = w_title;
	}

	public int getW_gno() {
		return w_gno;
	}

	public void setW_gno(int w_gno) {
		this.w_gno = w_gno;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getW_cnt() {
		return w_cnt;
	}

	public void setW_cnt(String w_cnt) {
		this.w_cnt = w_cnt;
	}

	public String getW_name() {
		return w_name;
	}

	public void setW_name(String w_name) {
		this.w_name = w_name;
	}

	public String getW_dlt() {
		return w_dlt;
	}

	public void setW_dlt(String w_dlt) {
		this.w_dlt = w_dlt;
	}

	@Override
	public String toString() {
		return "WriteVo [w_no=" + w_no + ", b_no=" + b_no + ", w_pno=" + w_pno
				+ ", id=" + id + ", w_title=" + w_title + ", w_gno=" + w_gno
				+ ", w_date=" + w_date + ", w_cnt=" + w_cnt + ", w_name="
				+ w_name + ", w_dlt=" + w_dlt + "]";
	}
}