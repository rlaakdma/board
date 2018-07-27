package kr.or.ddit.files.model;

public class FilesVo {
	private int f_no;
	private int w_no;
	private String f_picname;
	private String f_picpath;
	private String f_name;
	
	public FilesVo(){}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public int getW_no() {
		return w_no;
	}

	public void setW_no(int w_no) {
		this.w_no = w_no;
	}

	public String getF_picname() {
		return f_picname;
	}

	public void setF_picname(String f_picname) {
		this.f_picname = f_picname;
	}

	public String getF_picpath() {
		return f_picpath;
	}

	public void setF_picpath(String f_picpath) {
		this.f_picpath = f_picpath;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	@Override
	public String toString() {
		return "FilesVo [f_no=" + f_no + ", w_no=" + w_no + ", f_picname="
				+ f_picname + ", f_picpath=" + f_picpath + ", f_name=" + f_name
				+ "]";
	}
}